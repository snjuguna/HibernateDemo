package com.hernate.studentDemo.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		Query query = session.createQuery("from User where password = :param");
		query.setParameter("param", "root");
		
		List<User> list = query.getResultList();
		
		for (User user: list) {
			System.out.println(user.getName() + " " + user.getPhoneNo());
		}
		User user = session.get(User.class, 19);
		
		System.out.print(user.getName() + " ");
		System.out.print(user.getPhoneNo());
		User user1 = new User();
		
		user1.setId(15);
		user1.setName("kim");
		user1.setPhoneNo("888000");
		user1.setDob(new Date());
		user1.setUsername("kim");
		user1.setPassword("mberly");
		
		session.beginTransaction();
		
		session.save(user1);  //Insert new user
		//session.update(user);  //update existing user
		//session.delete(user);  //delete existing user
		
		session.getTransaction().commit();
		
		session.close();
	}

}

