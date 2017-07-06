package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


import model.Comments;

public class DBMComments extends DBManager<Comments>{


	public DBMComments(String dbhost, String dbName, String dbTable) {
		super(dbhost, dbName, dbTable);
	}

	/**
	 * Verifica si la columna esta en la tabla
	 * @param column
	 */
	@Override
	protected Comments mapDbToObject(ResultSet resultSet) throws SQLException {
		// lee el resultado i 
    	int id = resultSet.getInt("id");
        String user = resultSet.getString("myuser");
        String email = resultSet.getString("email");
        String webpage = resultSet.getString("webpage");
        String summary = resultSet.getString("summary");
        Date date = resultSet.getDate("datum");
        String comments = resultSet.getString("comments");
   
        Comments comment = new Comments();    
        comment.setId(id);
        comment.setEmail(email);
        comment.setDatum(date);
        comment.setMyUser(user);
        comment.setSummary(summary);
        comment.setComments(comments);
        comment.setWebpage(webpage);
        return comment; 
	}

	protected HashMap<String,Object> mapObjectToDb(Comments comment){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("myuser",comment.getMyUser()); 
		map.put("email",comment.getEmail()); 
		map.put("webpage",comment.getWebpage());
		map.put("datum",comment.getDatum());
		map.put("summary",comment.getSummary());
		map.put("comments",comment.getComments());
		return map;	
	}
	
	/**
	 * Condiciones bajo las cuales se puede actualizar un objeto.
	 * @param object
	 */
	/*private static void checkFormatUpdate(Comments object){
		if(object.getId()==-1){
			throw new RuntimeException("El objeto que trata de "
					+ "actualizar no tiene un id valido");
		}
		
	}*/

	
}
