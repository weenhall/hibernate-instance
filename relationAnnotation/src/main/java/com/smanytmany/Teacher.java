package com.smanytmany;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wen on 2018/8/6
 */
@Entity
@Table
public class Teacher implements Serializable {

    @Id
    @GenericGenerator(name = "tid",strategy = "assigned")
    @GeneratedValue(generator = "tid")
    private String id;

    @Column
    private String name;

    public Teacher() {
    }

    public Teacher(String id,String name) {
        this.id=id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
