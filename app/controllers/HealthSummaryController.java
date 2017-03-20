package controllers;


import models.GoogleCharts;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class HealthSummaryController extends Controller
{
    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public HealthSummaryController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getHealthSummary()
    {
        List<GoogleCharts> lineChart = (List<GoogleCharts>) jpaApi.em().createNativeQuery("select x.value val1, y.value val2,x.date_taken from (select pv.PATIENT_VITAL_ID, v.vital_name, pv.value, pv.date_taken from patient p \n" +
                "join patient_vital pv on p.PATIENT_ID = pv.PATIENT_ID\n" +
                "join vitals v on pv.VITAL_ID = v.VITAL_ID where v.vital_NAME = 'weight in lbs') x join \n" +
                "(select lp.LAB_PULLED_ID, l.lab_name, lp.value, lp.date_taken from patient p\n" +
                "join lab_pulled lp on p.PATIENT_ID = lp.PATIENT_ID\n" +
                "join lab l on lp.LAB_ID = l.LAB_ID where l.lab_name = 'Total cholesterol') y\n" +
                "on x.date_taken = y.date_taken order by date_taken asc", GoogleCharts.class).getResultList();

        List<GoogleCharts> barChart = (List<GoogleCharts>) jpaApi.em().createNativeQuery("select x.value val1, y.value val2,x.date_taken from (select lp.LAB_PULLED_ID, l.lab_name, lp.value, lp.date_taken from patient p \n" +
                "join lab_pulled lp on p.PATIENT_ID = lp.PATIENT_ID\n" +
                "join lab l on lp.LAB_ID = l.LAB_ID where l.lab_name = 'Hemoglobin A1c') x join\n" +
                "(select lp.LAB_PULLED_ID, l.lab_name, lp.value, lp.date_taken from patient p\n" +
                "join lab_pulled lp on p.PATIENT_ID = lp.PATIENT_ID\n" +
                "join lab l on lp.LAB_ID = l.LAB_ID where l.lab_name = 'Gucose') y\n" +
                "on x.date_taken = y.date_taken\n" +
                "order by date_taken asc", GoogleCharts.class).getResultList();

        return ok(views.html.healthSummaryPage.render(lineChart, barChart));
    }


}
