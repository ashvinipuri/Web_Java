package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import eample.hibernate.utils.HibernateUtilities;
import example.hibernate.entity.Actor;


public class RecordUpdationExample {

	public static void main(String[] args) {
		try(
				SessionFactory factory =HibernateUtilities.getSessionFactory();
				Session session =factory.openSession();
				){
			// Loading an Entity of type Actor against  an ID : A03
		Actor foundActor =	session.find(Actor.class, "A03");
		Transaction tx =session.beginTransaction();
		
		foundActor.setFirstName("Alia");
		foundActor.setLastName("Bhatt");
		
		tx.commit();
		System.out.println("Record Updated");
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
