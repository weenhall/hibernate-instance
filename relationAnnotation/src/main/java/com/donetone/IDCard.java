package com.donetone;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wen on 2018/8/1
 */
@Entity
public class IDCard {
    @Id
    @GenericGenerator(name = "ids",strategy = "assigned")
    @GeneratedValue(generator ="ids")
    private String id;

    @Column
    private String name;
    @Column
    private String address;
    @OneToOne(mappedBy = "idCard")
    private Employee employee;

    public IDCard() {
    }

    public IDCard(String name, String address) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
