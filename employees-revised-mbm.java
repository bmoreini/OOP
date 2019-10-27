package edu.vtc.oop.bmoreinis;

/**
 * Employees
 * 
 * Employee and Salary management. Methods are assumed to be called elsewhere, so set public static.
 * All user input is handled elsewhere, so exceptions are used for bad data. 
 * Employees array is set private, given length must not be altered elsewhere.  
 * Salaries array is set private, given length must not be altered elsewhere.  
 * HR NOTE: aboveSalary Array returns names but not salaries, but could be used to deduce salary information. 
 * IT Note: Due to constraints of legacy system, we are compelled to use arrays rather than
 * array lists. We must therefore define a set length for all arrays, set initially at 100. 
 * In the event company grows beyond 100 employees, software will require refactoring.
 * Also, as arrays are 1D (not key/value pairs), unique values are needed for employee names. 
 * 
 * @author Bram
 *
 */
public class Employees {
	
	/** 
	 * Upper limit of employees and salaries.  Altering this limit requires data refactoring, not handled here. 
	 */
	private int maxEmployees = 100;
	
	/** 
	 * Lower non-inclusive limit of salaries.  Altering this limit may require data refactoring, not handled here. 
	 * This value is included because Exam rubric specified "salary must exceed some minimum value".  
	 */
	private int minimumSalary = 0;

	/** 
	 * Unique names of up to 100 employees or null values, each name paired with an entry in salaries array. Never null.
	 */
	private String[] employees = new String[maxEmployees];

	/** 
	 * For each employee, annual salary in dollars, in corresponding position to name in employee array. 
	 * For validation purposes, all employees salaries must be greater than 0. Never null.
	 */
	private int[] salaries = new int[maxEmployees];
	

	/**
	 * Adds a new employee to the employees array by finding the first null value and replacing with new value, 
	 *   checking whether the corresponding value in salaries is 0, and replacing it with new nonzero salary if so.
	 * References minimumSalary value for global threshold for minimum salaries.  References maxEmployees to
	 *   verify array length integrity .
	 * 
	 * @param newEmployee - the unique name of the new employee, not null. This presumes a previous method, 
	 *     uniqueEmployee(), which checks a manually input name against current employees 
	 *     and prompts the user to alter the name if there is an existing duplicate.
	 *     Standard name alteration patterns are specified in uniqueEmployee.
	 * @param salary - the annual salary of the new employee, in dollars.
	 *      Throws DuplicateNameException if newEmployee string is already present in employees array 
	 *      Throws ZeroSalaryException if salary entered is 0. 
	 *      Throws SalaryDataCorruptionException if salary element corresponding to new employees value is nonzero. 
	 *      Throws SalaryNullException if salaries is null.
	 *      Throws SalaryOutOfBoundsException if salary does not exceed minimumSalary
	 *      Throws EmployeesNullException if employees is null.
	 *      Throws NullEmployeeException if newEmployee is null.
	 *      Throws EmptyEmployeeException if newEmployee is empty.
	 *      Throws ArrayLengthMisMatchException if Salaries and Employees not equal in length to maxEmployees. 
	 */
	public static void addEmployee(String newEmployee, int salary)
			throws DuplicateNameException,ZeroSalaryException,SalaryDataCorruptionException,SalaryNullException,SalaryOutOfBoundsException,EmployeeNullException,NullEmployeeException,EmptyEmployeeException,ArrayLengthMisMatchException {
	}

	/**
	 * Removes a retiring employee from employees replacing name with null and corresponding salary with 0.
	 * References maxEmployees to verify array length integrity.
	 * 

	 * @param retiringEmployeeName - the unique name of the retiring employee. 
	 *     Throws DuplicateNameException if retiringEmployeeName is found in more than one location in employees array.
	 *     Throws NameNotFoundException if retiringEmployeeName string is not present in employees array 
	 *     Throws ZeroSalaryException if salary associated with specified retiringEmployeeName is already 0. 
	 *     Throws SalaryNullException if salaries is null.
	 *     Throws EmployeeNullException if employees is null.
	 *     Throws NullRetiringEmployeeException if retiringEmployee is null. 
	 *     Throws ArrayLengthMisMatchException if Salaries and Employees not equal in length to maxEmployees. 
	 */
	public static void retire(String retiringEmployeeName)
			throws ArrayIndexOutOfBoundsException,IllegalArgumentException,ConstraintViolationException,SalaryNullException,EmployeeNullException,NullRetiringEmployeeException,ArrayLengthMisMatchException {
	}

	/**
	 * Returns the unique names of all employees earning above (not at) a manually-entered minimum salary threshold newMinSalary. Returns 0 if no employee salaries are above threshold. 
	 * References maxEmployees to verify array length integrity.
	 * 
	 * @param newMinSalary - a minimum salary threshold for the aboveSalary report, other than global minSalary.
	 * @return aboveSalary [] - String array of names of employees whose salaries are above the minSalary threshold.
	 *     Throws EmployeeDataCorruptionException if employee associated with a nonzero salary is 0.
	 *     Throws ArrayIndexOutOfBoundsException if salaries array length does not match employees array length. 
	 *     Throws SalaryNullException if salaries is null.
	 *     Throws EmployeeNullException if employees is null.
	 *     Throws ArrayLengthMisMatchException if Salaries and Employees not equal in length to maxEmployees. 
	 */
	public static String[] employeesAboveSalary(int minSalary) throws 
	EmployeeDataCorruptionException, ArrayIndexOutOfBoundsException,SalaryNullException,EmployeeNullException,ArrayLengthMisMatchException {
		String[] aboveSalary = new String[100];
		int iCount=-1;
		for(int i = 0; i<salaries.length; i++) {
			if(salaries[i]>minSalary) {
				try {
					if(employees[i]!=null) {
						iCount ++;
						aboveSalary[iCount]=employees[i];
					}
					else {
						throw new EmployeeDataCorruptionException("A null employee was matched with a nonzero salary.");
					}
					return aboveSalary;
				} catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Salaries array length "+salaries.length +" did not match employees array "+
							 "length "+ employees.length+" indicating corrupt data. Restore from backup.");
				}
			}
		}
	}
}
