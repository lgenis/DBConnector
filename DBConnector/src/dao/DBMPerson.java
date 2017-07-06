package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import model.Person;

public class DBMPerson extends DBManager<Person>{
	public DBMPerson(String dbhost, String dbName, String dbTable) {
		super(dbhost, dbName, dbTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Person mapDbToObject(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		String surname= resultSet.getString("surname");
		String phone = resultSet.getString("phone");
		String email = resultSet.getString("email");
		String address = resultSet.getString("address");
		
		Person persona = new Person();
		persona.setId(id);
		persona.setName(name);
		persona.setSurname(surname);
		persona.setPhone(phone);
		persona.setEmail(email);
		persona.setAddress(address);
		
		return persona;
	}
	protected HashMap<String,Object> mapObjectToDb(Person persona){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name",persona.getName()); 
		map.put("surname",persona.getSurname()); 
		map.put("phone",persona.getPhone());
		map.put("email",persona.getEmail());
		map.put("address",persona.getAddress());
		
		return map;	
	}
}
