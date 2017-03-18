package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MedicalHistory
{
    @Column (name ="MEDICAL_HISTORY_ID")
    public Integer medicalHistoryId;

    @Column (name ="DATE_DIAGNOSED")
    public Integer dateDiagnosed;

    @Column (name ="DATE_RESOLVED")
    public String dateResolved;

    @Column (name ="MEDICAL_CONDITION_ID")
    public Integer medicalConditionId;

}
