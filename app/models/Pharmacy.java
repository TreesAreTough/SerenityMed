package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pharmacy
{
    @Column (name ="PHARMACY_ID")
    public Long pharmacyId;

    @Column (name ="PHARM_NAME")
    public String pharmName;

    @Column (name ="PHARM_ADDRESS")
    public String pharmAddress;

    @Column (name ="PHARM_STATE")
    public String pharmState;

    @Column (name ="PHARM_CITY")
    public String pharmCity;

    @Column (name ="PHARM_ZIP")
    public String pharmZip;

}
