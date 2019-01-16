package com.cg.hms.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.hms.exception.HMSException;
import com.cg.hms.model.Patient;
import com.cg.hms.service.HMSService;
import com.cg.hms.service.HMSServiceImpl;

public class HMSMain {
	static Logger logger = Logger.getLogger(HMSMain.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scanner = null;
		int choices = 0;
		boolean choiceFlag = false;
		HMSService service = null;
		do {
			Long phone = null;
			scanner = new Scanner(System.in);

			System.out.println("*******HOSPITAL MANAGEMENT SYSTEM*******");
			System.out.println("1. Book Appointment");
			System.out.println("2. Get Appointment Details");
			System.out.println("3. View All Booked Appointments");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");

			try {
				boolean phoneFlag = false;
				choices = scanner.nextInt();
				choiceFlag = true;
				switch (choices) {
				case 1:
					scanner.nextLine();
					System.out.println("Enter the Name: ");
					String name = scanner.nextLine();
					do {
						scanner = new Scanner(System.in);
						System.out.println("Enter the Phone: ");
						try {
							phoneFlag = true;
							phone = scanner.nextLong();
						} catch (InputMismatchException e1) {
							phoneFlag = false;
						}
					} while (!choiceFlag);
					scanner.nextLine();
					System.out.println("Enter the gender: ");
					String gender = scanner.nextLine();
					System.out.println("Enter the problem: ");
					String problem = scanner.nextLine();

					Patient patient = new Patient();
					patient.setName(name);
					patient.setGender(gender);
					patient.setPhone(phone);
					patient.setProblem(problem);

					service = new HMSServiceImpl();
					try {
						boolean validateFlag = service.validateDetails(patient);
						if (validateFlag) {
							try {

								int id = service.insertDetails(patient);
								System.out.println(id
										+ " is your appointment id.");
							} catch (HMSException e) {
								System.err.println(e.getMessage());
							}
						}
					} catch (HMSException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				default:
					choiceFlag = false;
					System.err.println("Choices should be in the range of 1-4");
					System.out.println("Enter the input again");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Choices should only be Digits");
				System.out.println("Enter the input again");
			}

		} while (!choiceFlag);
	}
}
