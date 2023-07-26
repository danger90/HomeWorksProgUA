package homeWork11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {
	private String groupName;
	private final Student[] studens;

	public Group() {
		super();
		studens = new Student[10];
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudens() {
		return studens;
	}
	public void addStudent(Student student) throws GroupOverflowException {
		
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] == null) {
				studens[i] = student;
				return;
			}
		}
		
		throw new GroupOverflowException();
	}
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < studens.length; i++) {
			
			
			if(studens[i] != null) {
				if(studens[i].getLastName() == lastName) {
					return studens[i];
				}
			
				
			
			}
		}
		
		throw new StudentNotFoundException();
	}
	
	public boolean removeStudentByID(int id) {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null) {
				if(studens[i].getId() == id) {
					studens[i] = null;
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public void sortStudentsByLastName() {
		Arrays.sort(studens, new StudentsLastNameComporator());
	}
	
	
	public boolean isDublicateStudent() {
		for (int i = 0; i < studens.length; i++) {
			if (isStudent(this.studens[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean isStudent(Student student) {
		for (int i = 0; i < studens.length; i++) {
			if (student.equals(this.studens[i])) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(studens);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(studens, other.studens);
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", studens=" + Arrays.toString(studens) + "]";
	}
	
	
	
	
}
