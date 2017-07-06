package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


import model.Mascota;

public class DBMMascota extends DBManager<Mascota> {

	public DBMMascota(String dbhost, String dbName, String dbTable) {
		super(dbhost, dbName, dbTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Mascota mapDbToObject(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String nombre = resultSet.getString("nombre");
		Float peso = resultSet.getFloat("peso");
		Float altura = resultSet.getFloat("altura");
		Float largo = resultSet.getFloat("largo");
		String tipo = resultSet.getString("tipo");
		
		Mascota mascota = new Mascota();
		mascota.setId(id);
		mascota.setMyName(nombre);
		mascota.setPeso(peso);
		mascota.setAltura(altura);
		mascota.setLargo(largo);
		mascota.setTypeClass(tipo);
		
		return mascota;
	}
	protected HashMap<String,Object> mapObjectToDb(Mascota masco){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("nombre",masco.getMyName()); 
		map.put("peso",masco.getPeso()); 
		map.put("altura",masco.getAltura());
		map.put("largo",masco.getLargo());
		//map.put("propietario",masco.getPropietario());
		map.put("tipo",masco.getTypeClass());
		return map;	
	}
}
