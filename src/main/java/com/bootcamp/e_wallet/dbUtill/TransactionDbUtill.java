package com.bootcamp.e_wallet.dbUtill;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

import com.bootcamp.e_wallet.model.TransactionEntity;

public class TransactionDbUtill {

	private static SessionFactory  sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public TransactionDbUtill(SessionFactory connection) {
		sessionFactory = connection;
	}

	public void  addTransactionTopUp(TransactionEntity topUp) {
		Session sess = sessionFactory.openSession();
		Transaction transaction;
		try {
			transaction = sess.beginTransaction();
			sess.save(topUp);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			//transaction.rollback();
			System.out.println("Top Up failed!");
		} finally {
			sess.close();
		}
	}
}
