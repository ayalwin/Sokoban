package Hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibenateRun {

	
	public static void main(String[] args) {
	
		Record r= new Record("ron", "level2", 35,100);
		HibernateUtil util=HibernateUtil.getInstance();
		util.addRecord(r);
		util.close();


	}

}
