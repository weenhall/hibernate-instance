package com.dmanytmany;

import com.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by wen on 2018/8/7
 */
public class StudentTest {

    @Test
    public void testAdd() {
        Session session= HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();

        Teacher t1=new Teacher("t_aa","a老师");
        Teacher t2=new Teacher("t_bb","b老师");
        Teacher t3=new Teacher("t_cc","c老师");

        Student s1=new Student("小红",1,18);
        Student s2=new Student("小黄",1,19);

        Set<Teacher> set1=new HashSet<Teacher>();
        set1.add(t1);
        set1.add(t2);
        Set<Teacher> set2=new HashSet<Teacher>();
        set2.add(t1);
        set2.add(t3);

        s1.setTeacher(set1);
        s2.setTeacher(set2);
        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(s1);
        session.save(s2);
        tx.commit();
        HibernateUtils.closeSession(session);
    }

    @Test
    public void testQuery(){
        Session session=HibernateUtils.getSession();
        Student student=session.get(Student.class,1);
        Student student1=session.get(Student.class,2);

        Teacher teacher=session.get(Teacher.class,"t_aa");
        System.out.println("1");
    }


}