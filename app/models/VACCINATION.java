package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VACCINATION
{
    @Column (name="VACCINE_ID")
    public Integer vaccineId;

    @Column (name="VACCINE_NAME")
    public String vaccineName;

    @Column (name="BOOSTER_REQUIRED")
    public String boosterRequired;

    @Column (name="BOOSTER_TIME")
    public String boosterTime;

    @Column (name="VACCINE_DESCRIPTION")
    public String vaccineDescription;

}
