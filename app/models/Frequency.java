package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Time;

@Entity
public class Frequency
{
    @Column (name="FREQUENCY_ID")
    public Integer frequencyId;

    @Column (name="FREQUENCY")
    public Time frequency;
}
