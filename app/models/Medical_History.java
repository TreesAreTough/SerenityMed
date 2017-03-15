package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medical_History
{
    @Column (name ="MEDICAL_HISTORY_ID")
    public Long medicalHistoryId;

    @Column (name ="DATE_DIAGNOSED")
    public Long dateDiagnosed;

    @Column (name ="DATE_RESOLVED")
    public String dateResolved;

    @Column (name ="MEDICAL_CONDITION_ID")
    public Long medicalConditionId;

}
