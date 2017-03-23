package models;
import javax.persistence.*;
import java.sql.Date;
@Entity
public class LabManager
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="LAB_PULLED_ID")
    public Long labPulledId;

    @Column (name ="DATE_TAKEN")
    public Date dateTaken;

    @Column (name ="PATIENT_ID")
    public String  patientId;

    @Column (name ="LAB_ID")
    public Long labId;

    @Column (name ="DOCTOR_ID")
    public Long doctorId;

    @Column (name="VALUE")
    public String value;

    @Column(name="LAB_NAME")
    public String labName;

    @Column(name="DOC_NAME")
    public String docName;
}