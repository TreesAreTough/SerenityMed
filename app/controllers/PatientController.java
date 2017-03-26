package controllers;


import models.*;
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

    @Transactional(readOnly = true)
    public Result getFormFancyElements()
    {
        List<MedicalHistoryManager> currentMedicalHistory = (List<MedicalHistoryManager>) jpaApi.em().createNativeQuery("select mh.medical_history_id, mh.date_diagnosed, mh.date_resolved, mh.patient_id, mh.medical_condition_id, mc.mc_name from medical_history mh\n" +
                "join medical_condition mc on mh.MEDICAL_CONDITION_ID = mc.MEDICAL_CONDITION_ID\n" +
                "where mh.DATE_RESOLVED is null", MedicalHistoryManager.class).getResultList();

        List<MedicalHistoryManager> pastMedicalHistory = (List<MedicalHistoryManager>) jpaApi.em().createNativeQuery("select mh.medical_history_id, mh.date_diagnosed, mh.date_resolved, mh.patient_id, mh.medical_condition_id, mc.mc_name from medical_history mh\n" +
                "join medical_condition mc on mh.MEDICAL_CONDITION_ID = mc.MEDICAL_CONDITION_ID\n" +
                "where mh.DATE_RESOLVED is not null", MedicalHistoryManager.class).getResultList();

        List<Patient> patientList = (List<Patient>) jpaApi.em().createQuery("select p from Patient p", Patient.class).getResultList();

        List<Medical_Condition> medCondition = (List<Medical_Condition>) jpaApi.em().createQuery("select mc from Medical_Condition mc", Medical_Condition.class).getResultList();

        return ok(views.html.formFancyElements.render(currentMedicalHistory, pastMedicalHistory, patientList, medCondition));
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
        RxNomName rxNomName = null;
        return ok(views.html.pageBlank.render(rxNomName));
    }


    public Result getPageFaq()
    {
        return ok(views.html.pageFaq.render());
    }

    public Result getPageInbox()
    {
        return ok(views.html.pageInbox.render());
    }

    public Result getPageKnowledge()
    {
        return ok(views.html.pageKnowledgebase.render());
    }

    public Result getPageLogin()
    {
        return ok(views.html.pageLogin.render());
    }

    public Result getPageLoginAlt()
    {
        return ok(views.html.pageLoginAlt.render());
    }

    public Result getNewMessage()
    {
        return ok(views.html.pageNewMessage.render());
    }

    public Result getPagePricingTables()
    {
        return ok(views.html.pagePricingTables.render());
    }

    public Result getProjectDetail()
    {
        return ok(views.html.pageProjectDetail.render());
    }

    public Result getPageProject()
    {
        return ok(views.html.pageProjects.render());
    }

    public Result getRegistration()
    {
        return ok(views.html.pageRegister.render());
    }

    public Result getPageInvoice()
    {
        return ok(views.html.pageInvoice.render());
    }

    public Result getSearchResult()
    {
        return ok(views.html.pageSearchResult.render());
    }

    public Result getPageSubmitTicket()
    {
        return ok(views.html.pageSubmitTicket.render());
    }

    public Result bootstrapTest()
    {
        return ok(views.html.pageUserProfile.render());
    }




}
