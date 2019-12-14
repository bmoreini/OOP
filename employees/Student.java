package edu.vtc.oop.bmoreinis;

/**
 * Represents a student at a college
 * 
 * @author jxo05160
 *
 */
public class Student implements Cloneable {
	/** Student's first name, never null, never empty */
	private String firstName;

	/** Student's last name, never null, may be empty */
	private String lastName;

	/** Student's ID number, unique for each student, must be >= 0 */
	int idNumber;

	/** Student's major, never null, never empty */
	private String major;

	/** Next student ID number to be issued */
	private static int nextIDNumber = 0;

	/** Constant for undeclared major */
	public final static String UNDECLARED_MAJOR = "UND";
	
	/** Allows cloning of students for public reporting */
	public Student clone()throws CloneNotSupportedException{
		return (Student) super.clone();
	}

	/**
	 * Creates a new student who has chosen a program of study
	 * 
	 * @param firstName - never null, never empty
	 * @param lastName  - never null, may be empty
	 * @param major     - never null, never empty
	 * @throws NullPointerException     if firstName, lastName, or major are null
	 * @throws IllegalArgumentException if firstName or major are empty
	 * 
	 */
	public Student(String firstName, String lastName, String major)
			throws NullPointerException, IllegalArgumentException {
		// Screen for null inputs
		if (firstName == null) {
			throw new NullPointerException("firstName cannot be null");
		}

		if (lastName == null) {
			throw new NullPointerException("lastName cannot be null");
		}

		if (major == null) {
			throw new NullPointerException("major cannot be null");
		}

		// First name and major cannot be empty
		if (firstName.length() == 0) {
			throw new IllegalArgumentException("firstName cannot be empty");
		}

		if (major.length() == 0) {
			throw new IllegalArgumentException("major cannot be empty");
		}

		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.idNumber = nextIDNumber;
		repOK();
		nextIDNumber++;
	}

	/**
	 * Creates a new student who has not chosen a program of study, setting their
	 * major as UNDECLARED_MAJOR
	 * 
	 * @param firstName - never null, never empty
	 * @param lastName  - never null, may be empty
	 * @throws NullPointerException     if firstName or lastName are null
	 * @throws IllegalArgumentException if firstName is empty
	 */
	public Student(String firstName, String lastName) throws NullPointerException, IllegalArgumentException {
		// Screen for null inputs
		if (firstName == null) {
			throw new NullPointerException("firstName cannot be null");
		}

		if (lastName == null) {
			throw new NullPointerException("lastName cannot be null");
		}

		// First name cannot be empty
		if (firstName.length() == 0) {
			throw new IllegalArgumentException("firstName cannot be empty");
		}

		this.firstName = firstName;
		this.lastName = lastName;
		this.major = UNDECLARED_MAJOR;
		this.idNumber = nextIDNumber;
		repOK();
		nextIDNumber++;
	}

	/**
	 * Get this student's full name
	 * 
	 * @return the name, never null, never empty
	 */
	public String getName() {
		if (lastName.length() > 0) {
			return firstName + " " + lastName;
		} else {
			return firstName;
		}
	}

	/**
	 * Get this student's first name
	 * 
	 * @return the name, never null, never empty
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Get this student's last name
	 * 
	 * @return the name, never null, may be empty
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Get this student's ID number
	 * 
	 * @return the ID number, unique for each student
	 */
	public int getStudentID() {
		return idNumber;
	}

	/**
	 * Get this student's major
	 * 
	 * @return the major, never null, never empty
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * Changes the student's program of study
	 * 
	 * @param newMajor - never null, never empty
	 * @throws NullPointerException     - if newMajor is null
	 * @throws IllegalArgumentException - if newMajor is empty
	 */
	public void changeMajor(String newMajor) throws NullPointerException, IllegalArgumentException {
		if (newMajor == null) {
			throw new NullPointerException("newMajor cannot be null");
		}
		
		if (newMajor.length() == 0) {
			throw new IllegalArgumentException("newMajor cannot be empty");
		}
		
		major = newMajor;
		repOK();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + idNumber;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
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
		Student other = (Student) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idNumber != other.idNumber)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		return true;
	}

	private void repOK() {
		assert (firstName != null);
		assert (lastName != null);
		assert (major != null);
		assert (firstName.length() > 0);
		assert (major.length() > 0);
		assert (idNumber >= 0);
	}
}
