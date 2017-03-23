package controllers;

import models.AppointmentManager;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;


public class AppointmentController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public AppointmentController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getAppointmentManager()
    {
        List<AppointmentManager> appointment = (List<AppointmentManager>) jpaApi.em().createNativeQuery("select a.appointment_id, a.patient_id, a.doctor_id, d.doc_name, d.DOC_SPECIALTY, a.appointment_date, a.appointment_time from appointment a\n" +
                "join doctor d on a.DOCTOR_ID = d.DOCTOR_ID", AppointmentManager.class).getResultList();

        return ok(views.html.appointmentManagerPage.render(appointment));
    }

}
