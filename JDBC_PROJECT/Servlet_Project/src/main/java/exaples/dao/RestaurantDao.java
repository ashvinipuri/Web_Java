package exaples.dao;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//package example.jdbc.bean.Restaurant;
import java.util.Collection;

import example.bean.Restaurant;
import examples.utlis.Jdbc_Utils;


//if i called main method here then there will no changes for others like Account or employees

public class RestaurantDao implements DaoInterface<Restaurant, Integer> {

	@Override
	public Collection<Restaurant> retrieveAll() {
		/*
		 * This method connects to DB , fetches all record converts them into java
		 * objects of Restaurant class,puts those objects into some collection and
		 * returns the collection
		 *
		 */
		Collection<Restaurant> allRestaurants = new ArrayList<Restaurant>();
		String sqlQuery = "Select  * from restaurant_master";

		try {
			Connection conn = Jdbc_Utils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);

			while (rs.next()) {
				int restaurantId = rs.getInt(1);
				String restaurantName = rs.getString(2);
				int branchCount = rs.getInt(4);
				String restaurantCuisine = rs.getString(3);
				Restaurant rst = new Restaurant(restaurantId, restaurantName, restaurantCuisine, branchCount);

				allRestaurants.add(rst);
			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return allRestaurants;

	}

	public Restaurant retrieveOne(Integer id) {
		Restaurant foundRestaurant = null;
		String sqlQuery = "select * from Restaurant_master where rest_id=?";
		try (Connection conn = Jdbc_Utils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlQuery);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int restaurantId = rs.getInt(1);
				String restaurantName = rs.getString(2);
				int branchCount = rs.getInt(4);
				String restaurantCuisine = rs.getString(3);
				foundRestaurant = new Restaurant(restaurantId, restaurantName, restaurantCuisine, branchCount);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return foundRestaurant;
	}

	public void create(Restaurant newRestaurant) {
		/*
		 * This method accepts a 'Restaurant' Object: newRestaurant and stores it as a
		 * record in the db table
		 */
		String sqlQuery = "insert into restaurant_master values(?,?,?,?)";
		try {
			Connection conn = Jdbc_Utils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
//extracting the values from Restaurant object: newRestaurant
//using getter methods

			int restaurantId = newRestaurant.getRestaurantId();
			String restaurantName = newRestaurant.getName();
			String restaurantCuisine = newRestaurant.getCuisine();
			int restaurantBranchCount = newRestaurant.getBranchCount();

//substituting these values in place of '?' using preparedStatement
			pstmt.setInt(1, restaurantId);
			pstmt.setString(2, restaurantName);
			pstmt.setString(3, restaurantCuisine);
			pstmt.setInt(4, restaurantBranchCount);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + "record inserted.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void update(Restaurant modifiedRestaurant) {
		/*
		 * This method receives the modified state of the Restaurant Object :
		 * modifiedRestaurant and Reflects that state into DB
		 */
		String sqlQuery = "update restaurant_master set rest_name=?, rest_cuisine=?,rest_branch_count=? where rest_id=?";

		try (

				Connection conn = Jdbc_Utils.getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);

		) {
			// capturing modified state of restaurant object:modifiedRestaurant
			// using getter method
			int restaurantId = modifiedRestaurant.getRestaurantId();

			String restaurantName = modifiedRestaurant.getName();

			String restaurantCuisine = modifiedRestaurant.getCuisine();

			int restaurantBranchCount = modifiedRestaurant.getBranchCount();

			// substituting these values in place of '?' using preparedStatement

			pstmt.setInt(4, restaurantId);

			pstmt.setString(1, restaurantName);

			pstmt.setString(2, restaurantCuisine);

			pstmt.setInt(3, restaurantBranchCount);

			int updateCount = pstmt.executeUpdate();

			System.out.println(updateCount + "record Updated Succesfully.");
		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

	@Override
	public void delete(Integer id) {
		/* This method performs record deletion aganst identity
		 */
		 String sqlQuery ="delete from restaurant_master where rest_id=? ";
		 
		 try (

					Connection conn = Jdbc_Utils.getConnection();

					PreparedStatement pstmt = conn.prepareStatement(sqlQuery);

			) {
			 pstmt.setInt(1, id);
			 int updateCount =pstmt.executeUpdate();
			 System.out.println(updateCount + "record deleted ");
			 }
			 catch(Exception ex) {
				 ex.printStackTrace();
			 }
		 }
	}


