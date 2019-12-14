package edu.vtc.oop.bmoreinis;

/**
 * Employees
 * 
 * Employee and Salary management. NOTE: In order to make data available to
 * methods in other classes, instance variables have been set to public.
 * Note: Due to constraints of legacy system, we are compelled to use arrays rather than
 * array lists. We must therefore define a set length for all arrays, set arbitrarily to 100. 
 * In the event company grows beyond 100 employees, software will require refactoring.
 * Also, due to constraints of system, arrays are not keyed, requiring unique values for
 * employee names.  
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
	 */
	private int minSalary = 0;

	/** 
	 * Unique names of up to 100 employees or null values, each name paired with an entry in salaries array. Never null.
	 */
	public String[] employees = new String[maxEmployees];

	/** 
	 * For each employee, annual salary in dollars, in corresponding position to name in employee array. 
	 * For validation purposes, all employees salaries must be greater than 0. Never null.
	 */
	public int[] salaries = new int[maxEmployees];
	

	/**
	 * Adds a new employee to the company by finding the first null value in names array and replacing with new value, 
	 * checking whether the corresponding value in salaries is 0, and replacing with new nonzero salary if so.
	 * 
	 * @param employees - the employees array. 
	 * @param salaries - the salaries array
	 * @param newEmployee - the unique name of the new employee, not null. This presumes a previous method, 
	 *     uniqueEmployee(), which checks a manually input name against current employees 
	 *     and prompts the user to alter the name if there is an existing duplicate.
	 *     Standard name alteration patterns are specified in uniqueEmployee.
	 * @param salary - the annual salary of the new employee, in dollars.
	 *      Throws DuplicateNameException if newEmployee string is already present in employees array 
	 *      Throws ZeroSalaryException if salary entered is 0. 
	 *      Throws SalaryDataCorruptionException if salary element corresponding to new employees value is nonzero. 
	 *      Throws SalaryNullException if salaries is null.
	 *      Throws SalaryOutOfBoundsException if salary does not exceed minSalary
	 *      Throws EmployeesNullException if employees is null.
	 *      Throws NullEmployeeException if newEmployee is null.
	 *      Throws EmptyEmployeeException if newEmployee is empty.
	 *      Throws ArrayLengthMisMatchException if Salaries and Employees not equal in length to maxEmployees. 
	 */
	public void addEmployee(String[] employees, int[] salaries, String newEmployee, int salary)
			throws DuplicateNameException,ZeroSalaryException,SalaryDataCorruptionException,SalaryNullException,SalaryOutOfBoundsException,EmployeeNullException,NullEmployeeException,EmptyEmployeeException,ArrayLengthMisMatchException {
	}

	/**
	 * Removes a retiring employee from company by replacing name with null and corresponding salary with 0.
	 * 
	 * @param employees - the employees array
	 * @param salaries -the salaries array
	 * @param retiringEmployeeName - the unique name of the retiring employee. 
	 *     Throws DuplicateNameException if retiringEmployeeName is found in more than one location in employees array.
	 *     Throws NameNotFoundException if retiringEmployeeName string is not present in employees array 
	 *     Throws ZeroSalaryException if salary associated with a removed employee is 0. 
	 *     Throws SalaryNullException if salaries is null.
	 *     Throws EmployeeNullException if employees is null.
	 *     Throws NullRetiringEmployeeException if retiringEmployee is null. 
	 *     Throws ArrayLengthMisMatchException if Salaries and Employees not equal in length to maxEmployees. 
	 */
	public void retire(String[] employees, int[] salaries, String retiringEmployeeName)
			throws ArrayIndexOutOfBoundsException,IllegalArgumentException,ConstraintViolationException,SalaryNullException,EmployeeNullException,NullRetiringEmployeeException,ArrayLengthMisMatchException {
	}

	/**
	 * Returns the unique names of all employees earning above (not at) a manually-entered minimum salary threshold newMinSalary. Returns 0 if no employee salaries are above threshold. 
	 * 
	 * @param employees - the employees array
	 * @param salaries  - the salaries array, with non-zero values corresponding to index positions of named employees
	 * @param newMinSalary - a minimum salary threshold for the aboveSalary report, other than global minSalary.
	 * @return aboveSalary [] - String array of names of employees whose salaries are above the minSalary threshold.
	 *     Throws EmployeeDataCorruptionException if employee associated with a nonzero salary is 0.
	 *     Throws ArrayIndexOutOfBoundsException if salaries array length does not match employees array length. 
	 *     Throws SalaryNullException if salaries is null.
	 *     Throws EmployeeNullException if employees is null.
	 *     Throws ArrayLengthMisMatchException if Salaries and Employees not equal in length to maxEmployees. 
	 */
	public String[] employeesAboveSalary(int minSalary) throws 
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
