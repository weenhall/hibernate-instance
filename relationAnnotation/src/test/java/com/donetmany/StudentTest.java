package com.donetmany;

import com.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by wen on 2018/8/3
 */
public class StudentTest {

    @Test
    public void testAddStu() {
        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();
        Clazz c1 = new Clazz("1", "C201");

        Student s1 = new Student("小A", 1, 18);
        Student s2 = new Student("小B", 2, 18);
        Set<Student> stuSet = new HashSet<Student>();
        stuSet.add(s1);
        stuSet.add(s2);
        c1.setStu(stuSet);

        session.save(s1);
        session.save(s2);
        session.save(c1);
        tx.commit();
        HibernateUtils.closeSession(session);
    }

    @ Test
    public void testQueryStu() {
        Session session=HibernateUtils.getSession();
        Clazz c1=session.get(Clazz.class,"1");
        Student s1=session.get(Student.class,1);
        System.out.println(s1);
    }

}