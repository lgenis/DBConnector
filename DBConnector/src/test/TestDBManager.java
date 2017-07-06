package test;



import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.DBManager;
import model.Comments;
import model.Table;

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
		protected Table mapDbToObject(ResultSet resultSet) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		

	}
	
}
