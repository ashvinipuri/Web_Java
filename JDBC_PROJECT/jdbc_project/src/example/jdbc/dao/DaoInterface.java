package example.jdbc.dao;

import java.util.Collection;

public interface DaoInterface<T,K>   // T : means Restaurant , K : Integer
{
  // A Method to retrieve all records
	Collection <T> retrieveAll();
	
	//All method to retrieve a single record  based upon its Identity
	 T  retrieveOne(K key);
	 
	 // A method  to insert  a new record
	 
	 void create(T t);
	
	  // A method to update an existing record
	  void update(T t);
	  
	  // A method delete an existing record
	   void delete(K key);  // here k means ID 
}
