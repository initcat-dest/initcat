package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class CommUser implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String phone;
    private String password;
    private String name;
    private Integer six;
    private Integer age;
    private Integer activateStatus;
    private Date createTime;
    private Date activateTime;
    private Date updateTime;
    private String memo;

}