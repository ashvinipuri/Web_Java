package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Movie;
public class RecordInsertionExample {

	public static void main(String[] args) {
		//step 1: configure Hibernate using 'Configuration' class
Configuration conf =new Configuration();
conf =conf.configure();
//Obtain a SessionFactory using 'Configuration' class
SessionFactory factory =conf.buildSessionFactory();
// Step 3: Obtain a Session using SessionFactoy
Session currentSession =factory.openSession();
// step 4:  Create an entity class object
Movie movieObject=new Movie("M03","Baby","Action",2013);
//step 5: Obtain a Transaction and start the same
Transaction tx=currentSession.beginTransaction();
// step 6: Store the entity class object using Session
currentSession.persist(movieObject);
// step 7: Commit the Transaction
tx.commit();
// step 8: Close the Session
currentSession.close();
// step 9: close the SessionFactory
factory.close();
System.out.println("Record added");

	}

}
