package models;

import javax.persistence.*;

@Entity
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="DOCTOR_ID")
    public Long doctorID;

    @Column (name="DOC_NAME")
    public String docName;

    @Column (name="DOC_SPECALTY")
    public String docSpecality;

    @Column (name="DOC_PHONE_NUMBER")
    public String docPhoneNumber;

    @Column (name="DOC_ADDRESS")
    public String docAddress;

    @Column (name="DOC_CITY")
    public String docCity;

    @Column (name="DOC_STATE")
    public String docState;

    @Column (name="DOC_ZIP")
    public String docZip;

}
