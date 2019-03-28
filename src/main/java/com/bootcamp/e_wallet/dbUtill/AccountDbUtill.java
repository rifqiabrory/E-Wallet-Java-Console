package com.bootcamp.e_wallet.dbUtill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

import com.bootcamp.e_wallet.model.AccountEntity;

public class AccountDbUtill {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public AccountDbUtill(SessionFactory sessFact) {
		sessionFactory = sessFact;
	}
	
	public void addAccount(AccountEntity account) {
		Session sess = sessionFactory.openSession();
		try {
			Transaction transaction = sess.beginTransaction();
			sess.save(account);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Failed insert!");
		}
	}
}
