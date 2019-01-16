package com.cg.hms.service;

import com.cg.hms.exception.HMSException;
import com.cg.hms.model.Patient;

public interface HMSService {

	int insertDetails(Patient patient) throws HMSException;

	boolean validateDetails(Patient patient) throws HMSException;

}
