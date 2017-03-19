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

    public Result getFormFancyElements()
    {
        return ok(views.html.formFancyElements.render());
    }

    public Result getFormInplace()
    {
        return ok(views.html.formInplaceEditing.render());
    }

    public Result getFormLayouts()
    {
        return ok(views.html.formLayouts.render());
    }

    public Result getFormTextEditor()
    {
        return ok(views.html.formTextEditor.render());
    }

    public Result getFormValidations()
    {
        return ok(views.html.formValidations.render());
    }

    public Result getFormWizard()
    {
        return ok(views.html.formWizard.render());
    }

    public Result getIndex()
    {
        return ok(views.html.index.render());
    }

    public Result getIndex2()
    {
        return ok(views.html.index2.render());
    }

    public Result getMaps()
    {
        return ok(views.html.maps.render());
    }

    public Result get404()
    {
        return ok(views.html.page404.render());
    }

    public Result get505()
    {
        return ok(views.html.page505.render());
    }

    public Result getPageBlank()
    {
        return ok(views.html.pageBlank.render());
    }

    public Result getPageFaq()
    {
        return ok(views.html.pageFaq.render());
    }

    public Result bootstrapTest()
    {
        return ok(views.html.pageInbox.render());
    }


}
