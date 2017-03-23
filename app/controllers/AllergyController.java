package controllers;


import models.Allergies;
import models.AllergyManager;
import models.Patient;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class AllergyController  extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public AllergyController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getAllergyManager() {
        List<AllergyManager> allergyManagerList = (List<AllergyManager>) jpaApi.em().createNativeQuery("select pa.PATIENT_ALLERGY_ID, pa.patient_id, pa.allergy_id, p.first_name, a.allergy_name from patient_allergy pa\n" +
                "join patient p on p.PATIENT_ID = pa.PATIENT_ID\n" +
                "join allergies a on pa.ALLERGY_ID = a.ALLERGY_ID", AllergyManager.class).getResultList();

        List<Allergies> allergy = (List<Allergies>) jpaApi.em().createQuery("select a from Allergies a", Allergies.class).getResultList();

        List<Patient> patientList = (List<Patient>) jpaApi.em().createQuery("select p from Patient p", Patient.class).getResultList();


        return ok(views.html.allergyManagerPage.render(allergyManagerList, allergy, patientList));

    }
}
