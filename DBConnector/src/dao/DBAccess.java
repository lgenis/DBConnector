package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DBAccess <T>{
	/**Conexion a la base de datos
	 * 
	 * @param user				usuario de la base de datos
	 * @param password			palabra secreta de la base de datos
	 * @return 
	 * @return 
	 * @throws exec
	 */
	
	public    void connect(String user, String password)
		throws SQLException, ClassNotFoundException;
	
	/**
	 * Inserta un objeto T en la tabla
	 * @param object objeto de tipo T
	 * @return 
	 * @throws SQLException 
	 */
	public T insert(T object) throws SQLException;
	
	/**
	 * Actualiza un objeto de tipo T, donde T contiene las columnas de la tabla a actualizar
	 * @param object
	 * @throws SQLException 
	 */
	public void update(T object) throws SQLException;
	
	/**
	 * Recupera un objeto de tipo T segun el id, los miembros de T contienen los valores de las
	 * columnas de la tabla
	 * @param id
	 * @return
	 */
	public T select(int id);
	
	/**Ejecuta un selec segun strSQL, y retorna un ArrayList con todos los objetos
	 * recuperados
	 * @param strSQL
	 * @return
	 */
	public ArrayList<T> select(String strSQL);
	
	/**
	 * Elimina el registro segun el id
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * Elimina todos los objetos de la tabla, reinicia el contador de id
	 * @throws SQLException 
	 */
	public void deleteAll() throws SQLException;
	
	/**
	 * Cierrra una conexion
	 */
	public void close();
	
}