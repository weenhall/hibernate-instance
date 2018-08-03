package com.donetone;

import com.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by wen on 2018/8/2
 */
public class EmployeeTest {

    @Test
    public void testAddEmployee() {
        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();
        IDCard idCard = new IDCard("小明", "武汉市");
        idCard.setId("001");
        Employee emp = new Employee(1, idCard);
        session.save(idCard);
        session.save(emp);
        tx.commit();
        HibernateUtils.closeSession(session);
    }

    @Test
    public void testQuery(){
        Session session=HibernateUtils.getSession();
        Employee employee=session.get(Employee.class,2);
        IDCard idCard=employee.getIdCard();

        HibernateUtils.closeSession(session);
    }
}
