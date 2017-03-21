package models;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Frequency
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="FREQUENCY_ID")
    public Long frequencyID;

    @Column (name="FREQUENCY")
    public Long frequency;
}
