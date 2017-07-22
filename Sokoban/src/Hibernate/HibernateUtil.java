package Hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class HibernateUtil {

	private static HibernateUtil instance = new HibernateUtil();

	public static HibernateUtil getInstance() {
		return instance;
	}

	private SessionFactory factory;

	private HibernateUtil() {
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
	}

	public void addRecord(Record record) {
		Session session = null;
		Transaction tx = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			session.save(record);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	//pulling all records from data base
	public List<Record> getAllRecords() {

		Session session = factory.openSession();

		@SuppressWarnings("unchecked")
		Query<Record> query = session.createQuery("FROM Record");
		List<Record> list = query.list();

		return list;
	}
	
//	public List<Record> getUserRecord(){
//		
//	}

	public void close() {
		factory.close();
	}
}
