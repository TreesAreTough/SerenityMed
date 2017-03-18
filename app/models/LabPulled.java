package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class LabPulled
{
    @Column (name ="LAB_PULLED_ID")
    public Integer labPulledId;

    @Column (name ="LAB_DATE")
    public Date labDate;

    @Column (name ="PATIENT_ID")
    public Integer patientId;

    @Column (name ="LAB_ID")
    public Integer labId;

    @Column (name ="DOCTOR_ID")
    public Integer doctorId;

}
