package homeWork11;

import java.util.Scanner;

public class ScannerStudentParams {
	private String name;
	private String lastName;
	private Gender gender;
	private int id;
	private String groupName;

	public ScannerStudentParams() {
		super();
		input();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input student group:");
		String groupName = sc.nextLine();

		System.out.println("Input student name:");
		String name = sc.nextLine();

		System.out.println("Input student last name:");
		String lastName = sc.nextLine();

		System.out.println("Input student gender [MALE or FEMALE or INTERSEX]:");
		String gender = sc.nextLine();
		boolean checkGender = checkGender(gender);
		while (!checkGender) {
			System.out.println("Error! Input gender correctly!");
			gender = sc.nextLine();
			checkGender = checkGender(gender);
		}

		System.out.println("Input student document number:");
		int id = sc.nextInt();

		this.name = name;
		this.lastName = lastName;
		this.gender = Gender.valueOf(gender);
		this.id = id;
		this.groupName = groupName;
	}

	private boolean checkGender(String gender) {
		try {
			if (Gender.valueOf(gender) instanceof Gender) {
				return true;
			}
		} catch (Exception ex ) {
			return false;
		}
	
		return false;
	}

}
