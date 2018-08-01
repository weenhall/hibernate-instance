package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by wen on 2018/8/1
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        // 创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        StandardServiceRegistry ssr=ssrb.configure("hibernate.cfg.xml").build();
        sessionFactory=config.buildSessionFactory(ssr);
    }

    //获取SessionFactory
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //获取Session
    public static Session getSession(){
        session=sessionFactory.openSession();
        return session;
    }

    //关闭Session
    public static void closeSession(Session session){
        if(session!=null){
            session.close();
        }
    }
}
