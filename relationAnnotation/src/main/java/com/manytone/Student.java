package com.manytone;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wen on 2018/8/3
 * 多对一单向映射
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int sex;
    @Column
    private int age;

    @ManyToOne(cascade ={CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "cid",referencedColumnName = "id")
    private Clazz clazz;


    public Student() {
    }

    public Student(String name, int sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
