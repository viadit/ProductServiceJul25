package org.example.productservicejul25.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private int id;
    private Date createAt;
    private Date lastModifiedAt;
    private boolean isDeleted;
}
