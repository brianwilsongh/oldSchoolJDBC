package io.github.wilsontheory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.wilsontheory.Cat;

public class DAOthing {
	public Cat getCat(int id){
		Connection conn = null;
		Cat finalCat = null;
		String driver = "org.apache.derby.jdbc.ClientDriver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM cats WHERE id = ?");
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if (result.next()) finalCat = new Cat(id, result.getString("name").trim());
			result.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return finalCat;
		
	}
}
