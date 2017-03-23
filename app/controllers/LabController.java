package controllers;


import models.LabManager;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class LabController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public LabController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getLabManager()
    {
        List<LabManager> labManagerList = (List<LabManager>) jpaApi.em().createNativeQuery("select lp.lab_pulled_id, lp.date_taken, lp.patient_id, lp.lab_id, lp.doctor_id, lp.value, l.lab_name, p.first_name, d.doc_name from lab_pulled lp\n" +
                "join lab l on lp.lab_id = l.LAB_ID\n" +
                "join patient p on p.patient_id = lp.patient_id\n" +
                "join doctor d on lp.doctor_id = d.doctor_id\n" +
                "order by l.lab_name", LabManager.class).getResultList();

        return ok(views.html.labManagerPage.render(labManagerList));

    }
}
