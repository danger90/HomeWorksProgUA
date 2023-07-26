package homeWork11;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;

public class GroupFileStorage {
	public void saveGroupToCSV(Group gr) {
		Student[] students = gr.getStudens();
		
		String titleRow = "groupName,studentName,studentLastname,studentGender,studentId";
		String commaSeparator = ",";
		String valueRows = "";
		
		
		for (Student student : students) {
			if (student == null) {
				continue;
			}
			
			valueRows += gr.getGroupName() +  
					commaSeparator +
					student.getName() + 
					commaSeparator + 
					student.getLastName() +
					commaSeparator + 
					student.getGender().toString() +
					commaSeparator + 
					student.getId();
			
			valueRows += "\n";

		}
		
		String result = titleRow + "\n" + valueRows;
		File file = new File("/Users/deniskuschev/eclipse/ProgUA/Home Tasks/"+ gr.getGroupName() +".csv");
		
		
		try (PrintWriter pw = new PrintWriter(file)) {
		        pw.println(result);
		    } catch (IOException e) {
		      // TODO: handle exception
		    }		
	}		
	
	public Group loadGroupFromCSV(File file) throws IOException, GroupOverflowException {
		
		try (InputStream is = new FileInputStream(file)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String temp = "";
			String result = "";
			
			for (;;) {
				temp = br.readLine(); 
				if (temp == null) {
					break; 
				}
				
			    result += temp + System.lineSeparator();          
			}
			
			Group group = new Group();
			String[] rows = result.split("\n");
			
			for (int i = 1;  i < rows.length; i++ ) {
				
				 String[] studentInRow = rows[i].split(",");
				 
				 String gropName = studentInRow[0];
				 String name = studentInRow[1];
				 String lastName = studentInRow[2];
				 Gender gender = Gender.valueOf(studentInRow[3]);
				 int id = Integer.parseInt(studentInRow[4]);
				 
				 Student student = new Student(name, lastName, gender, id, gropName);
				 
				 group.setGroupName(gropName);
				 group.addStudent(student);
			}
			
			return group;		
		} catch (IOException e) {
			throw e; 
		}
	}
	
	public File findFileByGroupName(String groupName, File workFolder) {
		
		String ext = ".csv";
		
		String neededFilename = groupName + ext;
		File[] files = workFolder.listFiles();
	   
	    for (File file : files) {
	    	if (file.getName().equals(neededFilename)) {
	    		return file;
	    	}
	    }
	    
		return null;
	}
}
