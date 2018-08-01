package com.sonetone;

import com.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.EnumSet;

/**
 * Created by wen on 2018/8/1
 */
public class EmployeeTest {
    @Test
    public void testSchemaExport(){
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        SchemaExport export = new SchemaExport();
        export.create(EnumSet.of(TargetType.DATABASE),metadata);
    }

    @Test
    public void testAddEmp(){
        Session session= HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        IDCard idCard=new IDCard("小明","武汉市");
        idCard.setId("001");
        Employee emp=new Employee(1,idCard);

        session.save(idCard);
        session.saveOrUpdate(emp);
        tx.commit();
        HibernateUtils.closeSession(session);
    }

    @Test
    public void testQuery(){
        Session session=HibernateUtils.getSession();
        Employee employee=session.get(Employee.class,1);
        IDCard idCard=session.get(IDCard.class,"001");
        System.out.println(employee);
    }
}
