package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medication
{
    @Column (name ="MEDICATION_ID")
    public Integer medicationId;

    @Column (name ="MEDICATION_NAME")
    public String medicationName;

}
