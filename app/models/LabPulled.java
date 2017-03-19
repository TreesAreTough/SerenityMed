package models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class LabPulled
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="LAB_PULLED_ID")
    public Long labPulledID;

    @Column (name ="LAB_DATE")
    public LocalDate labDate;

    @Column (name ="PATIENT_ID")
    public Long patientID;

    @Column (name ="LAB_ID")
    public Long labID;

    @Column (name ="DOCTOR_ID")
    public Long doctorID;

    @Column(name = "VALUE")
    public String value;

}
