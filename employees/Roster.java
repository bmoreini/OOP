package edu.vtc.oop.bmoreinis;

public class Roster {
	/** Name of the course - never null, never empty */
	private String courseName;
	
	/** Semester the course is being offered - never null, never empty */
	private String semesterName;
	
	/** Students enrolled in the course - never null, may be empty, no duplicate students, no null students */
	private Student[] students;
	
	/**
	 * Determines if a student is on this course's roster
	 * 
	 * @param student - never null
	 * @return true if the student is on the roster, false otherwise
	 * @throws NullPointerException if student is null
	 */
	public boolean isEnrolled(Student student) throws NullPointerException {
		for(int i=0;i<students.length;i++) {
			if (students[i].idNumber==student.getStudentID()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get all students on this roster
	 * @return the students enrolled. Returns an empty array if no students are on the roster.
	 */
	public Student[] studentsEnrolled() {
		final Student [] enrolledStudents = new Student [students.length];
		if(students.length>0) {
			for(int i=0;i<students.length;i++) {
				try {
					enrolledStudents[i]=students[i].clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return enrolledStudents;
	}
	
	/**
	 * Adds a student to the roster. If the student is already on the roster, they are not added.
	 * @param student - never null
	 * @return if the student was added to the roster
	 * @throw NullPointerException if student is null
	 */
	public boolean add(Student student) throws NullPointerException {
		if (isEnrolled(student)) {
			return false;
		}
		
		// Code to actually add the student
		return true;
	}
	
	private void repOK() {
		// No nulls
		assert(courseName != null);
		assert(semesterName != null);
		assert(students != null);
		
		// Course name and semester name can't be empty
		assert(courseName.length() > 0);
		assert(semesterName.length() > 0);
		
		// No null students, no duplicate students
		for (int i = 0; i < students.length; i++) {
			assert(students[i] != null);
			
			for (int j = i + 1; j < students.length; j++) {
				assert(!students[i].equals(students[j]));
			}
		}
		
	}
}
