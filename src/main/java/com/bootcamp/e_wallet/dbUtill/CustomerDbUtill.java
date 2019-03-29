package com.bootcamp.e_wallet.dbUtill;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.bootcamp.e_wallet.model.CustomerEntity;

public class CustomerDbUtill {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public CustomerDbUtill(SessionFactory connection) {
		sessionFactory = connection;
	}

	public List<CustomerEntity> getAllCustomer() {
		
		List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
		Session sess = sessionFactory.openSession();
		try {
			//sess.beginTransaction();
			Query query = sess.createQuery("From Customer");
			//query.setInteger("", val)
			customers = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (SecurityException ex) {
			ex.printStackTrace();
		}finally {
			sess.close();
		}
		return customers;
	}

	public void addCustomer(CustomerEntity customer) {
		Session sess = sessionFactory.openSession();
		try {
			Transaction transaction = sess.beginTransaction();
			sess.save(customer);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Failed insert!");
		}
	}

}
