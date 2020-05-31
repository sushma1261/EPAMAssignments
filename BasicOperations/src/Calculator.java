
public class Calculator {
	/*
	 	* Addition of 2 numbers
	 	* @param a
	 	* @param b
	 	* @return integer addition of 2 numbers
	 */
	int add(int a,int b) {
		return a+b;
	}
	
	/*
	 	* Multiplication of 2 numbers
	 	* @param a
	 	* @param b
	 	* @return integer multiplication of 2 numbers
	 */
	
	int multiply(int a, int b) {
		return a*b;
	}
	
	/*
	 	* Division of 2 numbers
	 	* @param a
	 	* @param b
	 	* @return integer division of 2 numbers
	 */
	
	int divide(int a, int b) {
		try {
			return a/b;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
