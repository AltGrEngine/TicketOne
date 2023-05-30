package com.example.TicketOne.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Database {
	
	private final String user = "root";
	private final String password = "root";
	private final String percorso = "jdbc:mysql://localhost:3306/";
	private final String addDBConn = "?useSSL=false&serverTimezone=UTC";
	
	private Connection cn; 

	public Database(String nomeDatabase) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(percorso + nomeDatabase + addDBConn, user, password);
			
		} catch (ClassNotFoundException e) {
			System.err.println("Classe Driver non trovata !!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossibile collegarsi al Database");
			e.printStackTrace();
		}
	}
	
	public void chiudiConnection() {
		try {
			if(cn != null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		return this.cn;
	}
	
	public void chiudiItem(PreparedStatement ps, ResultSet rs) {
		try {
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
	
	public Map<Integer, Map<String, String>> executeQuery(String query, String... params) {

		Map<Integer, Map<String, String>> ris = new HashMap<Integer, Map<String, String>>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = getConnection().prepareStatement(query);
			for(int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			System.out.println("\u001B[32m" + "PreparedStatement: " + ps + "\u001B[0m");
			
			rs = ps.executeQuery();
			
			Map<String, String> mapParam;
			ResultSetMetaData metaData;
			while(rs.next()) {
				
				metaData = rs.getMetaData();
				mapParam = new LinkedHashMap<String, String>();
				
				for(int i = 0; i < metaData.getColumnCount(); i++) {
					mapParam.put(metaData.getColumnName(i+1).toLowerCase().replace("_", "")
							, rs.getString(i+1));
				}
				
				ris.put(rs.getInt("ID"), mapParam);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			chiudiItem(ps, rs);
		}
		
		return ris;
	}

	public boolean executeUpdate(String query, String... params) {

		PreparedStatement ps = null;
		
		try {
			
			ps = getConnection().prepareStatement(query);
			for(int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			
			ps.executeUpdate();
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			chiudiItem(ps, null);
		}
		
	}
	
	
}
