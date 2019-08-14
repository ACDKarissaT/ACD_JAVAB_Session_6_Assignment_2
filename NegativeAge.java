package assignment2;

import java.util.Scanner;

class NegativeAgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int age;
	public NegativeAgeException(int age) {
		this("Negative age." + age);
		this.age = age;
	}
	public NegativeAgeException(String message) {
		super(message);
	}
}
public class NegativeAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			printAge(scanInt(sc, "Enter age: "));
		} catch (NegativeAgeException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			printAge(scanInt(sc, "Enter age: "));
		} catch (NegativeAgeException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
	static void printAge(int i) throws NegativeAgeException{
		if (i >= 0) {
			System.out.println("Age is " + i);
		} else {
			throw new NegativeAgeException(i);
		}
	}
	
	static int scanInt(Scanner sc, String prompt) {
		int num = 0;
		boolean pass = false;
		while (!pass) {
			System.out.print(prompt);
			try {
				num = sc.nextInt();
				pass = true;
			} catch(Exception e){
				System.out.println("Input must be a number.");
			}
			if (sc.hasNextLine()) sc.nextLine();
		}
		return num;
	}
}
