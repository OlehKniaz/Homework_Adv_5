package entities;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Bucket {
    private int id;
    private Timestamp createDate;
}
