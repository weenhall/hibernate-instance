package com.donetone;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wen on 2018/8/1
 * 员工实体 一对一双向映射
 */
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int sex;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "iid",unique = true)
    private IDCard idCard;

    public Employee() {
    }

    public Employee(int sex, IDCard idCard) {
        this.sex = sex;
        this.idCard = idCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", sex=" + sex +
                ", idCard=" + idCard +
                '}';
    }
}
