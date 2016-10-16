package com.mkyong.core;

import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class Test {
	public static void main(String[] args) {

		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("testdb1");

			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("user1");

			/**** Insert ****/
			// create a document to store key and value
			/*for(int i=0;i<100;i++){
			BasicDBObject document = new BasicDBObject();
			document.put("name", "mkyong");
			document.put("age", 30+i);
			document.put("createdDate", new Date());
			table.insert(document);
			}*/
			/**** Find and display ****/
			BasicDBObject searchQuery = new BasicDBObject();
			 //new BasicDBObject("$lt", 50);
			searchQuery.put("age",new BasicDBObject("$lt", 50));
			
			DBCursor cursor = table.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			/**** Update ****/

			/**** Find and display ****/

			/**** Done ****/
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
