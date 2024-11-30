package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import eample.hibernate.utils.HibernateUtilities;
import example.hibernate.entity.Actor;

public class RecordInsertionWithoutXMLExample {

	public static void main(String[] args) {
	
	try(
			SessionFactory factory =HibernateUtilities.getSessionFactory();
			Session session =factory.openSession();
			){
		Actor actorObj =new Actor("A03","Alia","Bhatt",30);
		Transaction tx =session.beginTransaction();
		session.persist(actorObj);
		tx.commit();
		System.out.println("Record added");
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	}
}
