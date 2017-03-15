package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Allergies
{
    @Column (name="ALLERGY_ID")
    public Long allergyId;

    @Column (name="ALLERGY_NAME")
    public String allergyName;

    @Column (name="ALLERGY_DESCRIPTION")
    public String allergyDescription;
}
