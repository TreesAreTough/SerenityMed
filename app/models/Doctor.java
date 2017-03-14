package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Doctor
{
    @Column (name="DOCTOR_ID")
    public Integer doctorId;

    @Column (name="DOC_NAME")
    public String docName;

    @Column (name="DOC_SPECIALITY")
    public String docSpeciality;

    @Column (name="DOC_PHONE")
    public String docPhone;

    @Column (name="DOC_ADDRESS")
    public String docAddress;

    @Column (name="DOC_CITY")
    public String docCity;

    @Column (name="DOC_STATE")
    public String docState;

    @Column (name="DOC_ZIP")
    public String docZip;

}
