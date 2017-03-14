package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PatientAllergy
{
    @Column (name ="PATIENT_ALLERGY_ID")
    public Integer patientAllergyId;

    @Column (name ="PATIENT_ID")
    public Integer patientId;

    @Column (name ="ALLERGY_ID")
    public Integer allergyId;
}
