package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class DBManager<T> implements DBAccess<T> {



	private String dbName;
	private String dbTable;
	
	private String dbUri;
	private  Connection connect;

	//TODO ojo no sera miembro
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	//private final String table;


	public DBManager(String dbhost, String dbName, String dbTable){
		this.dbTable =dbTable;
		this.dbName = dbName;
		this.dbUri = "jdbc:mysql://host/dbName?user=root&password=12345";
				dbUri = dbUri.replace("host", dbhost)
				.replace("dbName", dbName);
	}
	
	@Override
	public abstract T insert(T object) throws SQLException;

	@Override
	public abstract void update(T object) throws SQLException;

	@Override
	public abstract  T select(int id) throws SQLException;
	@Override
	public abstract ArrayList<T> select(String strSQL);

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	 public void deleteAll() throws SQLException{			
		try{
			preparedStatement = connect
			        .prepareStatement("truncate "+dbTable);
			
	        preparedStatement.executeUpdate();		
	    
	    } catch (SQLException e) {
	    	close(); 
            throw e;
	    }finally{
	    	
	    }
	}

	@Override
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null; 
            }


            if (connect != null) {
                connect.close();
                connect = null; 
            }
            /*
            if(preparedStatement != null){
            	preparedStatement.close();
            	preparedStatement = null;
            }*/
            
        } catch (Exception e) {

        }
    }
	
	@Override
	public void connect(String user, String password) 
			throws SQLException, ClassNotFoundException{
		
		 try {
	        	String uri=dbUri.replace("root", user)
	        			.replaceAll("12345", password);
	            // Cargar el driver MYSQL
	            Class.forName("com.mysql.jdbc.Driver");
	            // jdbc:mysql://ip database // database ? 
	            /*connect = DriverManager
	                    .getConnection("jdbc:mysql://localhost/"+ dbName +"?"
	                            + "user=" + user + "&password=" + password);
				*/
	            connect=DriverManager.getConnection(uri);
	            // Statements allow to issue SQL queries to the database
	            //statement = connect.createStatement();
		 	}catch (ClassNotFoundException e){
		 		throw e;
	        } catch (Exception e) {
	        	close(); 
	            throw e;
	        } 
	        
	    }
	/** getters y seters, metodos accesorios */
	
	public String getDbTable() {
		return dbTable;
	}
	public String getDbName() {
		return dbName;
	}

	
	protected Connection getConnected(){
		return connect;
	}
	
}
