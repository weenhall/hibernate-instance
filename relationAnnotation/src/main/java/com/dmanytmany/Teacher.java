package com.dmanytmany;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by wen on 2018/8/7
 */
@Entity
@Table
public class Teacher implements Serializable{

    @Id
    @GenericGenerator(name = "id",strategy = "assigned")
    @GeneratedValue(generator = "id")
    private String id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "teacher")
    private Set<Student> stus;

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

    public Set<Student> getStus() {
        return stus;
    }

    public void setStus(Set<Student> stus) {
        this.stus = stus;
    }
}
