package homeWork11;

import java.io.File;
import java.io.IOException;

class Main {

	public static void main(String[] args) throws GroupOverflowException, StudentNotFoundException{
		
		
		
		String testGroupName = "test_group_name";
		
		ScannerStudentParams scanner = new ScannerStudentParams();	
		
		Student prepareStudent = new Student(
				scanner.getName(),
				scanner.getLastName(),
				scanner.getGender(),
				scanner.getId(),
				scanner.getGroupName()
		);		
		
		Group group = new Group();
		group.addStudent(prepareStudent);
		group.setGroupName(testGroupName);
		System.out.println(group);
	
		
		
		GroupFileStorage groupFileStorage = new GroupFileStorage();
		
		groupFileStorage.saveGroupToCSV(group);
		
		File file = new File("/Users/deniskuschev/eclipse/ProgUA/Home Tasks/test_group_name.csv");
		
		try {
			Group loadedGroup = groupFileStorage.loadGroupFromCSV(file);
			System.out.println(loadedGroup);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		File workDir = new File("/Users/deniskuschev/eclipse/ProgUA/Home Tasks/");	
		
		File testFindinfFile = groupFileStorage.findFileByGroupName(testGroupName, workDir);
		System.out.println(testFindinfFile);
		
		
//		ScannerStudentParams scanner = new ScannerStudentParams();	
//		
//		Student prepareStudent = new Student(
//				scanner.getName(),
//				scanner.getLastName(),
//				scanner.getGender(),
//				scanner.getId(),
//				scanner.getGroupName()
//		);
//
//		System.out.println(prepareStudent);
//
//		
//		Group mainGroup = new Group();
//		mainGroup.setGroupName(scanner.getGroupName());
//		mainGroup.addStudent(prepareStudent);
//		
//		
//		System.out.println(mainGroup);
//		
		
	}

}
