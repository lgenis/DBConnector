package test;



import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.DBManager;
import model.Comments;

public class TestDBManager {
	@Test
	public void testConnection(){
		boolean result = true;
		DBManager dbManager = new MockManager();
		
		
		try {
			dbManager.connect("root", "poodb");
			//dbManager.deleteAll();
		}catch (Exception e){
			e.printStackTrace();
			result = false;
		}finally {
			dbManager.close();
		}
		
		Assert.assertEquals(true, result);
	}
	

	@Test
	public void testDeleteAll(){
		boolean result = true;
		DBManager dbManager = 
				new MockManager();
		
		try{
			dbManager.connect("root", "poodb");
			dbManager.deleteAll();
		}catch (Exception e){
			e.printStackTrace();
			result = false;
		}finally{
			dbManager.close();
		}
		
		Assert.assertEquals(true, result);
	}
	
	
	
	public static class MockManager extends DBManager{
		public MockManager() {
			super("localhost", "dbtest", "comments");
		}

		@Override
		public Object insert(Object object) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void update(Object object) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public Object select(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList select(String strSQL) {
			// TODO Auto-generated method stub
			return null;
		}
		

	}
	
}
