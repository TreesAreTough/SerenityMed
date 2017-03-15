package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Patient_Vital
{
    @Column (name ="PATIENT_VITAL_ID")
    public Long patientVitalId;

    @Column (name ="VALUE")
    public String value;

    @Column (name ="DATE")
    public Date date;

    @Column (name ="PATIENT_ID")
    public Long patientId;

    @Column (name ="VITAL_ID")
    public Long vitalId;

}
