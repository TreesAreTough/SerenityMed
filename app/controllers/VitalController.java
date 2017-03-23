package controllers;

import models.VitalDate;
import models.VitalList;
import models.VitalManager;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class VitalController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public VitalController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getVitalManager()
    {
        List<VitalManager> vitalManagerList = (List<VitalManager>) jpaApi.em().createNativeQuery("select pv.PATIENT_VITAL_ID, v.vital_name, pv.value, pv.date_taken from patient_vital pv\n" +
                "join vitals v on pv.VITAL_ID = v.VITAL_ID\n" +
                "order by v.VITAL_NAME, pv.DATE_TAKEN desc", VitalManager.class).getResultList();

        List<VitalDate> vitalDates = (List<VitalDate>) jpaApi.em().createNativeQuery("select date_taken from patient_vital group by date_taken desc limit 3", VitalDate.class).getResultList();


        List<VitalList> vitalList = new ArrayList<>();
        VitalList vitalItem = null;

        int vitalIndex = 1;

        for(VitalManager vital: vitalManagerList)
        {
            if (vitalItem == null || !vitalItem.getVitalName().equals(vital.vitalName))
            {
                vitalItem = new VitalList();
                vitalList.add(vitalItem);
                vitalItem.setVitalName(vital.vitalName);
                vitalIndex = 1;
            }

            switch (vitalIndex)
            {
                case 1:
                    vitalItem.setDate1(vital.dateTaken);
                    vitalItem.setId1((vital.patientVitalID));
                    vitalItem.setValue1(vital.value);
                    break;
                case 2:
                    vitalItem.setDate2(vital.dateTaken);
                    vitalItem.setId2((vital.patientVitalID));
                    vitalItem.setValue2(vital.value);

                    break;
                case 3:
                    vitalItem.setDate3(vital.dateTaken);
                    vitalItem.setId3((vital.patientVitalID));
                    vitalItem.setValue3(vital.value);

                    break;
                default:
                    //we do not care about values past thr third one
            }
            vitalIndex++;
        }
        return ok(views.html.vitalManagerPage.render(vitalList, vitalDates));
    }
}

