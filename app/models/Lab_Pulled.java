package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Lab_Pulled
{
    @Column (name ="LAB_PULLED_ID")
    public Long labPulledId;

    @Column (name ="LAB_DATE")
    public Date labDate;

    @Column (name ="PATIENT_ID")
    public Long patientId;

    @Column (name ="LAB_ID")
    public Long labId;

    @Column (name ="DOCTOR_ID")
    public Long doctorId;

    @Column (name="VALUE")
    public String value;

}
