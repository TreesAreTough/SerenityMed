package models;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Prescription
{
    @Column (name ="PRESCRIPTION_ID")
    public Long prescriptionId;

    @Column (name ="DATE_TAKEN")
    public String dateTaken;

    @Column (name ="DOSAGE")
    public String dosage;

    @Column (name ="MEDICATION_ID")
    public Long medicationId;

    @Column (name ="PATIENT_ID")
    public Long patientId;

    @Column (name ="PHARMACY_ID")
    public Long pharamcyId;

    @Column (name ="DOCTOR_ID")
    public Long doctorId;

    @Column (name ="FREQUENCY_ID")
    public Long frequencyId;
}
