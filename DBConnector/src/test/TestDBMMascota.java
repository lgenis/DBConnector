package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.DBMMascota;
import model.Mascota;

public class TestDBMMascota {
	


	@Test
	public void testInsert() {
		boolean result = true;
		DBMMascota dbManager = 
				new DBMMascota("localhost", "dbTest", "mascota");
		
		Mascota Mascota1 =  getMockDBMMascota();
		
		
		try {
			dbManager.connect("root", "poodb");
			dbManager.insert(Mascota1);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			
		}finally{
			dbManager.close();
		}
		
		Assert.assertEquals(true, result);
		Assert.assertEquals(true, Mascota1.getId()!=-1);
	}
	
	@Test
	public void testUpdate() {
		boolean result = true;
		DBMMascota dbManager = 
				new DBMMascota("localhost", "dbTest", "mascota");
		
		Mascota Mascota1 = getMockDBMMascota();
		Mascota MascotaUpdated=null;

		try {
			dbManager.connect("root", "poodb");
			dbManager.insert(Mascota1);
			
			Mascota1.setMyName("Don update");
			Mascota1.setPeso(100f);
			Mascota1.setAltura(30f);
			Mascota1.setLargo(10f);
			Mascota1.setTypeClass("Roedor");
			
			dbManager.update(Mascota1);
			
			MascotaUpdated=dbManager.select(Mascota1.getId());
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally{
			dbManager.close();
		} 
		Assert.assertEquals(true,result);
		
		Assert.assertEquals("Don update", Mascota1.getMyName());
		Assert.assertEquals(100f, Mascota1.getPeso(), 0.1);
		Assert.assertEquals(30f, Mascota1.getAltura(), 0.1);
		Assert.assertEquals(10f, Mascota1.getLargo(), 0.1);;
		Assert.assertEquals("Roedor", Mascota1.getTypeClass());
		
		Assert.assertEquals(true, MascotaUpdated.getId()!=-1);
		
		
	}
	
	@Test
	public void testGet() {
		boolean result = true;
		DBMMascota dbManager = 
				new DBMMascota("localhost", "dbTest", "mascota");
		Mascota Mascota1 = getMockDBMMascota();
		Mascota results = null;
		try {
			dbManager.connect("root", "poodb");
			
			int id = dbManager.insert(Mascota1);
			Mascota1.setId(id);
			results=dbManager.select(Mascota1.getId());

		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}finally{
			dbManager.close();
		} 
		
		Assert.assertTrue(result);
		Assert.assertEquals(Mascota1.getMyName(), results.getMyName());
		Assert.assertEquals(Mascota1.getPeso(), results.getPeso(), 0.1);
		Assert.assertEquals(Mascota1.getTypeClass(), results.getTypeClass());
	}
	
	
	

	
	@Test
	public void testSelect() {
		boolean result = true;
		DBMMascota dbManager = 
				new DBMMascota("localhost", "dbTest", "Mascota");
		
		Mascota Mascota1 = getMockDBMMascota("user1");
		Mascota Mascota2 = getMockDBMMascota("user2");
		Mascota Mascota3 = getMockDBMMascota("user3");
		Mascota Mascota4 = getMockDBMMascota("user4");
		Mascota Mascota5 = getMockDBMMascota("xuser");
		
		ArrayList<Mascota> results1 = null;
		ArrayList<Mascota> results2 = null;
		ArrayList<Mascota> results3 = null;
		
		try {
			dbManager.connect("root", "poodb");
			
			dbManager.deleteAll();
			
			dbManager.insert(Mascota1);
			dbManager.insert(Mascota2);
			dbManager.insert(Mascota3);
			dbManager.insert(Mascota4);
			dbManager.insert(Mascota5);
			
			results1 = dbManager.select("nombre", "LIKE", "'user%'");
			results2 = dbManager.select("nombre", "=", "'user1'");
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
	
	private Mascota getMockDBMMascota(){
		return getMockDBMMascota("root");
	}
	
	private Mascota getMockDBMMascota(String myName){
		
		Mascota Mascota1 = new Mascota();
		Mascota1.setMyName(myName);
		Mascota1.setPeso(5f);
		Mascota1.setAltura(2f);
		Mascota1.setLargo(1.2f);
		
		Mascota1.setTypeClass("Ave");
		return Mascota1;
	}
	
}
