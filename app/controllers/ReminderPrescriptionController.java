package controllers;

import models.PrescriptionReminderManager;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;


public class ReminderPrescriptionController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public ReminderPrescriptionController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getReminderManager()
    {
        List<PrescriptionReminderManager> reminder = (List<PrescriptionReminderManager>) jpaApi.em().createNativeQuery("select pr.REMINDER_ID, p.PATIENT_ID, p.first_name, p.cell_phone, pr.NEXT_REMINDER, f.frequency, pre.DOSAGE, m.MEDICATION_NAME, f.FREQUENCY_ID, pre.PRESCRIPTION_ID from patient p\n" +
                "join prescription_reminder pr on p.PATIENT_ID = pr.PATIENT_ID\n" +
                "join prescription pre on pr.PRESCRIPTION_ID = pre.PRESCRIPTION_ID\n" +
                "join medication m on pre.MEDICATION_ID = m.MEDICATION_ID\n" +
                "join frequency f on pre.FREQUENCY_ID = f.FREQUENCY_ID", PrescriptionReminderManager.class).getResultList();

        return ok(views.html.prescriptionReminderPage.render(reminder));
    }
}
