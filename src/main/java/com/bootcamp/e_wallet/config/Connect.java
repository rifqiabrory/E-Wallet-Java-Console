package com.bootcamp.e_wallet.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bootcamp.e_wallet.model.AccountEntity;
import com.bootcamp.e_wallet.model.CustomerEntity;
import com.bootcamp.e_wallet.model.TransactionEntity;
import com.bootcamp.e_wallet.model.TransactionTypeEntity;

public class Connect {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory getConnection() {
		System.out.println("Get connecting..");
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(CustomerEntity.class);
		config.addAnnotatedClass(AccountEntity.class);
		config.addAnnotatedClass(TransactionEntity.class);
		config.addAnnotatedClass(TransactionTypeEntity.class);
//		config.addResource("query.hbm.xml");
//		config.addResource("Customer.hbm.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		System.out.println("Successfully connected!");
		return sessionFactory;
	}
}
