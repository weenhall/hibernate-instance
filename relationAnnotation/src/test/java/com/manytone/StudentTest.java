package com.manytone;

import com.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wen on 2018/8/6
 */
public class StudentTest {

    @Test
    public void testaddStudent(){
        Session session= HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        Clazz c1=new Clazz("001","C908");

        Student s1=new Student("小A",1,18);
        Student s2=new Student("小B",2,18);
        s1.setClazz(c1);
        s2.setClazz(c1);

        session.save(c1);
        session.save(s1);
        session.save(s2);
        tx.commit();
        HibernateUtils.closeSession(session);
    }

    @Test
    public void testQueryStu(){
        Session session=HibernateUtils.getSession();
        Student s1=session.get(Student.class,1);
        Student s2=session.get(Student.class,2);
        System.out.println(s1);
    }
}