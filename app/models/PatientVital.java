package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class PatientVital
{
    @Column (name ="PATIENT_VITAL_ID")
    public Integer patientVitalId;

    @Column (name ="VALUE")
    public String value;

    @Column (name ="DATE")
    public Date date;

    @Column (name ="PATIENT_ID")
    public Integer patientId;

    @Column (name ="VITAL_ID")
    public Integer vitalId;

}
