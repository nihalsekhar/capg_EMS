package com.cg.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.hms.dao.HMSDao;
import com.cg.hms.dao.HMSDaoImpl;
import com.cg.hms.exception.HMSException;
import com.cg.hms.model.Patient;

public class HMSServiceImpl implements HMSService {

	HMSDao hmsDao = new HMSDaoImpl();
	List<String> list = new ArrayList<>();

	/**
	 * method : insertDetails argument : it is taking model object as as
	 * argument return type : this method returns the generated id to the user
	 * author : Capgemini date : 14-01-2019
	 **/

	@Override
	public int insertDetails(Patient patient) throws HMSException {

		return hmsDao.insertDetails(patient);
	}

	/**
	 * method 			: insertDetails 
	 * argument			: it is taking model object as an argument
	 * return type 		: this method returns the validation true or false to the user 
	 * author			: Capgemini 
	 * date 			: 14-01-2019
	 **/

	@Override
	public boolean validateDetails(Patient patient) throws HMSException {
		boolean validateFlag = false;
		if (!checkName(patient.getName())) {
			list.add("Name must start with Capital letter and max length should be 20 characters\n");
		}

		if (!checkGender(patient.getGender())) {
			list.add("Add either male or female or others");
		}
		if (!checkPhone(patient.getPhone())) {
			list.add("Add a valid phone number with 10 digits");

		}
		if (!list.isEmpty()) {
			throw new HMSException(list + "");
		} else {
			validateFlag = true;
		}
		return validateFlag;
	}

	public boolean checkName(String name) {
		String nameRegex = "[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(nameRegex, name);
	}

	public boolean checkGender(String gender) {
		String genderRegex = "^male$|^female$|^others$";
		return Pattern.matches(genderRegex, gender);
	}

	public boolean checkPhone(Long phone) {
		String phoneRegex = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(phoneRegex, Long.toString(phone));
	}
}
