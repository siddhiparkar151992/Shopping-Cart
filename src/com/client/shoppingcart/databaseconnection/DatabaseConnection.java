package com.client.shoppingcart.databaseconnection;

/*
 * Singleton Connection factory
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {

	private DatabaseConnection() {

	}
	public static MongoDatabase getConnection() {
		MongoClient mongoClient = null;
		MongoDatabase database=null;
		try {
			mongoClient = new MongoClient(new MongoClientURI(
					"mongodb://localhost:27017"));

			
			database = mongoClient.getDatabase( "shoppingcart" );

			System.out.println("Database and Collection Created successfully");

		} catch (Exception e) {
			try {
				
			} catch (Exception e1) {

				e1.printStackTrace();
				mongoClient.close();
			}
		}
		return database;
	}
}
