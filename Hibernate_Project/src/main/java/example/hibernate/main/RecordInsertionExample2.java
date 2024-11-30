package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import eample.hibernate.utils.HibernateUtils;
import example.hibernate.entity.Movie;

public class RecordInsertionExample2 {
  // This program makes use of standard practices
	public static void main(String[] args) {
	try (
			SessionFactory factory= HibernateUtils.getSessionFactory();
			Session session =factory.openSession();
			){
		Movie movieObj =new Movie("M04","Dangal","Inspirational",2017);
		Transaction tx=session.beginTransaction();
		session.persist(movieObj);
		tx.commit();
		System.out.println("Record inserted");
	}
catch(Exception ex) {
	ex.printStackTrace();
}
	}

}
