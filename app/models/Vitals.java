package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Vitals
{
    @Column (name="VITAL_ID")
    public Integer vitalId;

    @Column (name="VITAL_NAME")
    public String vitalName;

    @Column (name="VITAL_DESCRIPTION")
    public String vitalDescription;
}
