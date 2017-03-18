package models;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Prescription
{
    @Column (name ="PRESCRIPTION_ID")
    public Integer prescriptionId;

    @Column (name ="DATE_TAKEN")
    public String dateTaken;

    @Column (name ="DOSAGE")
    public String dosage;

    @Column (name ="MEDICATION_ID")
    public Integer medicationId;

    @Column (name ="PATIENT_ID")
    public Integer patientId;

    @Column (name ="PHARMACY_ID")
    public Integer pharamcyId;

    @Column (name ="DOCTOR_ID")
    public Integer doctorId;

    @Column (name ="FREQUENCY_ID")
    public Integer frequencyId;
}
