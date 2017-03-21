package controllers;


import models.*;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class PrescriptionController  extends Controller
{
    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public PrescriptionController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getPrescriptionManager()
    {
        List<PrescriptionManager> prescription = (List<PrescriptionManager>) jpaApi.em().createNativeQuery("select pre.PRESCRIPTION_ID, m.MEDICATION_ID, p.PATIENT_ID, p.FIRST_NAME, m.medication_name, pre.dosage, f.frequency, pre.frequency_id, d.doc_name, d.doctor_id, pharm.pharmacy_id, pharm.pharm_name, pre.date from patient p\n" +
                "join prescription pre on p.PATIENT_ID = pre.PATIENT_ID\n" +
                "join medication m on pre.MEDICATION_ID = m.MEDICATION_ID\n" +
                "join pharmacy pharm on pre.PHARMACY_ID = pharm.PHARMACY_ID\n" +
                "join doctor d on pre.DOCTOR_ID = d.DOCTOR_ID\n" +
                "join frequency f on pre.FREQUENCY_ID = f.FREQUENCY_ID", PrescriptionManager.class).getResultList();

        List<Patient> patientList = (List<Patient>) jpaApi.em().createQuery("select p from Patient p", Patient.class).getResultList();

        List<Frequency> frequencyList = (List<Frequency>) jpaApi.em().createQuery("select f from Frequency f", Frequency.class).getResultList();

        List<Medication> medicationList = (List<Medication>) jpaApi.em().createQuery("select m from Medication m", Medication.class).getResultList();

        List<Doctor> doctorList = (List<Doctor>) jpaApi.em().createQuery("select d from Doctor d", Doctor.class).getResultList();

        List<Pharmacy> pharmacyList = (List<Pharmacy>) jpaApi.em().createQuery("select ph from Pharmacy ph", Pharmacy.class).getResultList();


        return ok(views.html.pagePrescriptionManager.render(prescription, patientList, frequencyList, medicationList, doctorList, pharmacyList));
    }
}
