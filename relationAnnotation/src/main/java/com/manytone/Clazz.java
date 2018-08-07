package com.manytone;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by wen on 2018/8/3
 */
@Entity
@Table(name = "stu_class")
public class Clazz implements Serializable{
    @Id
    @GenericGenerator(name = "ids",strategy = "assigned")
    @GeneratedValue(generator = "ids")
    private String id;

    @Column
    private String code;


    public Clazz() {
    }

    public Clazz(String id, String code) {
        this.id=id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
