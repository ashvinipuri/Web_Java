package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eample.hibernate.utils.HibernateUtilities;
import example.hibernate.entity.Actor;

public class RecordRetrievalExample {

	public static void main(String[] args) {

		try(
				SessionFactory factory =HibernateUtilities.getSessionFactory();
				Session session =factory.openSession();
				){
			// Loading an Entity of type Actor against  an ID : A03
		Actor foundActor =	session.find(Actor.class, "A03");
		if(foundActor !=null) {
		System.out.println("found Actor:" + foundActor);
		System.out.println("first Name:" + foundActor.getFirstName());
		}
		else     // if i give  wrong id it will give null pointer exception error
			System.out.println("Actor with given ID does not exist");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
