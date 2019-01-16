package com.cg.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cg.hms.exception.HMSException;
import com.cg.hms.model.Patient;
import com.cg.hms.utility.JDBCUtility;

public class HMSDaoImpl implements HMSDao {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	static Logger logger = Logger.getLogger(HMSDaoImpl.class);

	/**
	 * method : insertDetails argument : it is taking model object as as
	 * argument return type : this method returns the generated id to the user
	 * author : Capgemini date : 14-01-2019
	 **/

	@Override
	public int insertDetails(Patient patient) throws HMSException {
		logger.info("In InsertDetails");

		connection = JDBCUtility.getConnection();

		logger.info("Connection is successfull");
		int appointmentId = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertDetails);

			logger.debug("statement is created");
			statement.setString(1, patient.getName());
			statement.setString(2, patient.getGender());
			statement.setLong(3, patient.getPhone());
			statement.setString(4, patient.getProblem());
			statement.executeUpdate();
			logger.info("For Inserting executeUpdate is executed");

			statement = connection.prepareStatement(QueryMapper.getPatientId);
			resultSet = statement.executeQuery();
			logger.info("For ID exectueQuery is executed by the result set");
			resultSet.next();
			appointmentId = resultSet.getInt(1);
			logger.info("ID is generated" + appointmentId);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new HMSException("statement not created");
		} finally {
			logger.info("in finally block");
			try {
				resultSet.close();
				logger.info("ResultSet Closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSException("result set not closed");
			}
			try {
				statement.close();
				logger.info("Statement closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSException("statement not closed");
			}
			try {
				connection.close();
				logger.info("Connection closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSException("connection not closed");
			}
		}
		return appointmentId;
	}

}
