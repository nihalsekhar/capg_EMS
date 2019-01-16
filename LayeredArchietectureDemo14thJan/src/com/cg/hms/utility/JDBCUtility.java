package com.cg.hms.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.hms.exception.HMSException;

public class JDBCUtility {

	static Connection connection = null;

	public static Connection getConnection() throws HMSException {
		Properties properties = null;
		File file = null;
		FileInputStream inputStream = null;
		file = new File("resources/jdbc.properties");
		try {
			inputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(inputStream);

			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String user = properties.getProperty("db.user");
			String password = properties.getProperty("db.pass");

			Class.forName(driver);

			connection = DriverManager.getConnection(url, user, password);
		} catch (FileNotFoundException e) {
			throw new HMSException("File is not found");
		} catch (IOException e) {
			throw new HMSException("File not loaded");
		} catch (ClassNotFoundException e) {
			throw new HMSException("Class is not found");
		} catch (SQLException e) {
			throw new HMSException("Connection was not created");
		}
		return connection;
	}
}
