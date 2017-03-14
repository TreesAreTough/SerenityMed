package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Time;

@Entity
public class PrescriptionReminder
{
    @Column (name = "REMINDER_ID")
    public Integer reminderId;

    @Column (name = "START_TIME")
    public Time startTime;

    @Column (name ="PATIENT_ID")
    public Integer patientId;

    @Column (name = "PRESCRIPTION_ID")
    public Integer prescriptionId;

}
