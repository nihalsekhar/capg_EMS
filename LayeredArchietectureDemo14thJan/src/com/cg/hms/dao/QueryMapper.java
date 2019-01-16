package com.cg.hms.dao;

public interface QueryMapper {

	public static final String insertDetails ="INSERT INTO hms_table VALUES(patient_seq.nextval,?,?,?,sysdate+1,?)";
	public static final String getPatientId ="SELECT patient_seq.CURRVAL FROM DUAL";
}
