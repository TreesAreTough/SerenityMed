package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MedicalCondition
{
    @Column (name="MEDICAL_CONDITION_ID")
    public Integer medicalConditionId;

    @Column (name="MC_NAME")
    public String mcName;

    @Column (name="MC_DESCRIPTION")
    public String mcDescription;

}
