package com.cg.hms.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.hms.dao.HMSDao;
import com.cg.hms.dao.HMSDaoImpl;
import com.cg.hms.exception.HMSException;
import com.cg.hms.model.Patient;

public class HMSDaoImplTest {

	HMSDao dao = null;
	@Before
	public void setUp() throws Exception {
		dao = new HMSDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
	dao = null;
	}

	@Test
	public void testInsertDetails() {
		Patient patient = new Patient();
		patient.setName("Nihal");
		patient.setGender("male");
		patient.setPhone(9176656056l);
		patient.setProblem("fever");
		try{
			int id = dao.insertDetails(patient);
			System.out.println(id+"id updated");
		}catch (HMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
		@Test
		public void testInsertDetailsIsNull() {
			Patient patient = new Patient();
			patient.setName("Nihal");
			patient.setGender("male");
			patient.setPhone(9176656056l);
			patient.setProblem("fever");
			try{
				int id = dao.insertDetails(patient);
				assertNull(id);
			}catch (HMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
		
	}
		@Test
		public void testInsertDetailsIsNotNull() {
			Patient patient = new Patient();
			patient.setName("Nihal");
			patient.setGender("male");
			patient.setPhone(9176656056l);
			patient.setProblem("fever");
			try{
				int id = dao.insertDetails(patient);
				assertNotNull(id);
			}catch (HMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
		
	}
		

}
