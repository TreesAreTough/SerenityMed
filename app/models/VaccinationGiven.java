package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Blob;
import java.sql.Date;

@Entity
public class VaccinationGiven
{
    @Column (name ="VACCINATION_GIVEN_ID")
    public Integer vaccinationGivenId;

    @Column (name ="DATA")
    public Date data;

    @Column (name ="DOCUMENTATION")
    public Blob documentation;

    @Column (name ="PATIENT_ID")
    public Integer patientId;

    @Column (name ="VACCINE_ID")
    public Integer vaccineId;

    @Column (name ="DOCTOR_ID")
    public Integer doctorId;

}
