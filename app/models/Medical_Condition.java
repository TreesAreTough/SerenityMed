package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medical_Condition
{
    @Column (name="MEDICAL_CONDITION_ID")
    public Long medicalConditionId;

    @Column (name="MC_NAME")
    public String mcName;

    @Column (name="MC_DESCRIPTION")
    public String mcDescription;

}
