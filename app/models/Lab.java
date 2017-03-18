package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Lab
{
    @Column (name="LAB_ID")
    public Integer labId;

    @Column (name="LAB_NAME")
    public String labName;

    @Column (name="LAB_DESCRIPTION")
    public String labDescription;

}
