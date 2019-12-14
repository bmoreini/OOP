package edu.vtc.oop.bmoreinis;

public class SpecifiedSearch {

	public static void main(String[] args) throws NullPointerException, IndexOutOfBoundsException, NotFoundException {
		System.out.print(search(a,3));

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
	 
	public static int search (int[] a, int x) throws NotFoundException,NullPointerException,IndexOutOfBoundsException {
		try {
			Boolean found = false;
			for (int i=0;i<a.length;i++) {
				if (a[i]==x) {
					found = true;
					return i;
				}
			}
			if (found==false) {
				throw new NotFoundException("Integer "+x+" was not found in array. -1 is returned.");
			}
		} 
		catch (NullPointerException e) {
			System.out.println("The array was empty.");
   			} 
		catch (IndexOutOfBoundsException e) {
		}
		return -1;		
	}
	
	private static int[] a = new int[] {1,2,3,4};
}
