package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.DBMPerson;
import model.Person;

public class TestDBMPerson {




		//@Test
		public void testInsert() {
			boolean result = true;
			DBMPerson dbManager = 
					new DBMPerson("localhost", "dbTest", "person");
			
			Person Person1 =  getMockDBMPerson();
			
			
			try {
				dbManager.connect("root", "poodb");
				dbManager.insert(Person1);
			} catch (Exception e) {
				result = false;
				e.printStackTrace();
				
			}finally{
				dbManager.close();
			}
			
			Assert.assertEquals(true, result);
			Assert.assertEquals(true, Person1.getId()!=-1);
		}
		
		@Test
		public void testUpdate() {
			boolean result = true;
			DBMPerson dbManager = 
					new DBMPerson("localhost", "dbTest", "person");
			
			Person Person1 = getMockDBMPerson();
			Person PersonUpdated=null;

			try {
				dbManager.connect("root", "poodb");
				dbManager.insert(Person1);
				
				Person1.setName("Don update");
				Person1.setSurname("update");
				Person1.setPhone("11111111");
				Person1.setEmail("update@update.com");
				
				dbManager.update(Person1);
				
				PersonUpdated=dbManager.select(Person1.getId());
				
			} catch (Exception e) {
				result = false;
				e.printStackTrace();
			}finally{
				dbManager.close();
			} 
			Assert.assertEquals(true,result);
			
			Assert.assertEquals("Don update", Person1.getName());
			Assert.assertEquals("update", Person1.getSurname());
			Assert.assertEquals("11111111", Person1.getPhone());
			Assert.assertEquals("update@update.com", Person1.getEmail());
			
			Assert.assertEquals(true, PersonUpdated.getId()!=-1);
			
			
		}
		
		@Test
		public void testGet() {
			boolean result = true;
			DBMPerson dbManager = 
					new DBMPerson("localhost", "dbTest", "person");
			Person Person1 = getMockDBMPerson();
			Person results = null;
			try {
				dbManager.connect("root", "poodb");
				
				int id = dbManager.insert(Person1);
				Person1.setId(id);
				results=dbManager.select(Person1.getId());

			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}finally{
				dbManager.close();
			} 
			
			Assert.assertTrue(result);
			Assert.assertEquals(Person1.getName(), results.getName());
			Assert.assertEquals(Person1.getSurname(), results.getSurname());
			Assert.assertEquals(Person1.getAddress(), results.getAddress());
		}
		
		
		

		
		@Test
		public void testSelect() {
			boolean result = true;
			DBMPerson dbManager = 
					new DBMPerson("localhost", "dbTest", "Person");
			
			Person Person1 = getMockDBMPerson("user1", "user1@poo.com");
			Person Person2 = getMockDBMPerson("user2", "user2@poo.com");
			Person Person3 = getMockDBMPerson("user3", "user3@poo.com");
			Person Person4 = getMockDBMPerson("user4", "user4@poo.com");
			Person Person5 = getMockDBMPerson("xuser", "user4@poo.com");
			
			ArrayList<Person> results1 = null;
			ArrayList<Person> results2 = null;
			ArrayList<Person> results3 = null;
			
			try {
				dbManager.connect("root", "poodb");
				
				dbManager.deleteAll();
				
				dbManager.insert(Person1);
				dbManager.insert(Person2);
				dbManager.insert(Person3);
				dbManager.insert(Person4);
				dbManager.insert(Person5);
				
				results1 = dbManager.select("name", "LIKE", "'user%'");
				results2 = dbManager.select("name", "=", "'user1'");
				results3 = dbManager.select("id", "BETWEEN", "2 AND 5");

			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}finally{
				dbManager.close();
			} 
			
			Assert.assertTrue(result);
			Assert.assertEquals(4, results1.size());
			Assert.assertEquals(1, results2.size());
			Assert.assertEquals(4, results3.size());

		}
		
		private Person getMockDBMPerson(){
			return getMockDBMPerson("root", "root@root");
		}
		
		private Person getMockDBMPerson(String myUser, String email){
			
			Person Person1 = new Person();
			Person1.setName(myUser);
			Person1.setEmail(email);
			Person1.setSurname("Esto es un surname");
			Person1.setPhone("9999999999");
			
			Person1.setAddress("Esta es una address");
			return Person1;
		}
	}


