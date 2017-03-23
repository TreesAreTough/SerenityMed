package controllers;


import models.VaccinationManager;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class VaccineController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public VaccineController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getVaccineManager()
    {
        List<VaccinationManager> vaccinationManagers = (List<VaccinationManager>) jpaApi.em().createNativeQuery("select v.booster_required, vg.vaccination_given_id, vg.date, vg.doctor_id, vg.patient_id, p.first_name, vg.vaccine_id, v.vaccine_name, d.doc_name from vaccination_given vg\n" +
                "join vaccination v on vg.VACCINE_ID = v.VACCINE_ID\n" +
                "join doctor d on vg.DOCTOR_ID = d.DOCTOR_ID\n" +
                "join patient p on vg.PATIENT_ID = p.PATIENT_ID",VaccinationManager.class).getResultList();

        return ok(views.html.vaccineManagerPage.render(vaccinationManagers));
    }
}
