package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Blob;
import java.sql.Date;

@Entity
public class VaccinationGiven
{
    @Column (name ="VACCINATION_GIVEN_ID")
    public Long vaccinationGivenId;

    @Column (name ="DATA")
    public Date data;

    @Column (name ="DOCUMENTATION")
    public Blob documentation;

    @Column (name ="PATIENT_ID")
    public Long patientId;

    @Column (name ="VACCINE_ID")
    public Long vaccineId;

    @Column (name ="DOCTOR_ID")
    public Long doctorId;

}
