package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Patient_Allergy
{
    @Column (name ="PATIENT_ALLERGY_ID")
    public Long patientAllergyId;

    @Column (name ="PATIENT_ID")
    public Long patientId;

    @Column (name ="ALLERGY_ID")
    public Long allergyId;
}
