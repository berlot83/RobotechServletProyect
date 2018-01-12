package com.cognizant.storageManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cognizant.dao.ConnectionFile;
import com.cognizant.entities.User;

public class DBManagerUser {

	public static ArrayList<User> retriveAllUsers() {
		ArrayList<User> result = new ArrayList<>();
		String user = null;
		String password = null;
		
		try {
			Connection conn = ConnectionFile.getConexion();
			
			if(conn != null) {
				Statement st;
				String sql = "SELECT user, password FROM users";
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					user = rs.getString("user");
					password = rs.getString("password");
					result.add(new User(user, password));
				}
			}
			
		}catch(Exception error) {
			error.printStackTrace();
		}
		return result;
	}
	
	public static boolean retriveUser(String user, String password) {
		ArrayList<User> result = DBManagerUser.retriveAllUsers();
		boolean ingress = false;
		
		try {
			for(User item : result) {
				if( item.getName().equals(user) && item.getPassword().equals(password)) {
					ingress = true;
				}
				else {
					ingress = false;
				}
			}
			
		}catch(Exception error) {
			error.printStackTrace();
		}
		return ingress;
	}
	
}
