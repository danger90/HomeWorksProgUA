package homeWork11;

public class CSVStringConverter implements StringConverter{

	public String toStringRepresentation(Student student) {
		String titleLine = "name,lastname,gender,id,groupName";
		String separator = "\n";
		String valueLine = student.getName() + "," + student.getLastName() + "," + student.getGender().toString() +"," + student.getId() + "," + student.getGroupName();
		
		return titleLine + separator + valueLine;
	}
	
	public Student fromStringRepresentation(String str) {
		String studentData = str.split("\n")[1];
		String[] studentRow = studentData.split(",");
		
		String name = studentRow[0];
		String lastName = studentRow[1];
		Gender gender = Gender.valueOf(studentRow[2]);
		int id = Integer.valueOf(studentRow[3]);
		String groupName = studentRow[4];

		return new Student(name, lastName, gender, id, groupName);
	}
	
}
