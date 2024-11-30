package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import eample.hibernate.utils.HibernateUtilities;
import example.hibernate.entity.Actor;

public class RecordDeletionExample {

	public static void main(String[] args) {
		try(
				SessionFactory factory =HibernateUtilities.getSessionFactory();
				Session session =factory.openSession();
				){
			// Loading an Entity of type Actor against  an ID : A02
		Actor foundActor =	session.find(Actor.class, "A02");
		Transaction tx =session.beginTransaction();
		session.remove(foundActor);
		tx.commit();
		System.out.println("Record Deleted");
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
}
}