package controllers;


import models.Patient;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

public class PatientController extends Controller
{
    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public PatientController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)
    public Result getPatient() {
        List<Patient> patients = (List<Patient>) jpaApi.em().createQuery("select p from Patient p").getResultList();

        return ok(toJson(patients));
    }

    public Result bootstrapTest()
    {
        return ok(views.html.formFancyElements.render());
    }

    public Result getChartsBasic()
    {
        return ok(views.html.chartsbasic.render());
    }

    public Result getChartsInteractive()
    {
        return ok(views.html.chartsinteractive.render());
    }

    public Result getFormBootStrapElements()
    {
        return ok(views.html.formBootstrapElements.render());
    }

    public Result get404()
    {
        return ok(views.html.page404.render());

    }
}
