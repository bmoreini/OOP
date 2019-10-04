package edu.vtc.oop.bmoreinis;

public class SpecifiedSearchWhile {

	public static void main(String[] args) throws NullPointerException, IndexOutOfBoundsException, NotFoundException {
		System.out.print(searchWhile(a,5));

	}
	
	/* 
	 * Search method takes a sorted int array a.  If a is null throws NullPointerException, 
	 * else if x is not in a, throws NotFoundException; else returns position of a in i such 
	 * that a[1] = x
	 * 
	 * @param:  int array a, the sorted array
	 * @param:  int x, the x to be located in array a
	 * @return: int i, the index of the first location of x in array a
	 */
	 
	public static int searchWhile (int[] a, int x) throws NullPointerException,IndexOutOfBoundsException {
		try {
			Boolean found = false;
			int i = -1;
			while (found == false) {
				if (a[i]==x) {
					found = true;
					return i;
				}
				i++;
			}
		} 
		catch (NullPointerException e) {
			System.out.println("The array was empty.");
   			} 
		catch (IndexOutOfBoundsException e) {
			System.out.println("The integer "+x+" was not found in the array.");
		}
		return -1;		
	}
	
	private static int[] a = new int[] {1,2,3,4};
}
