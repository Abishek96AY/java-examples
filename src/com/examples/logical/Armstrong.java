package com.examples.logical;

public class Armstrong {
	public static void main(String[] args) {
		myMethod();
		//customMethod();
	}

	public static void customMethod()
	{
		int sumOfCube=0,a,temp;    
		int number=1634;    
		temp=number;    
		while(number>0)    
		{
			a=number%10; //Getting last digit  
			number=number/10;  //Removing last digit from number  
			sumOfCube=sumOfCube+(a*a*a); //Calculating sum of cubes of digits    
		}    
		if(temp==sumOfCube)    
			System.out.println(temp+" is an armstrong number");     
		else    
			System.out.println(temp+ "is not an armstrong number");     
	}    

	public static void myMethod()
	{
		int input = 370;
		int finalSum = 0;
		String strInput = String.valueOf(input);
		char[] ch = strInput.toCharArray();
		int[] intArr = new int[ch.length];
		for (int i = 0; i < ch.length; i++)
		{
			int convertInt = Integer.parseInt(Character.toString(ch[i]));
			int cube = 1;
			for (int j = 0; j < intArr.length; j++) {
				cube = cube * convertInt;
			}
			System.out.println("cube :: "+cube);
			finalSum = finalSum + cube;
			System.out.println("finalSum :: "+cube);
		}
		System.out.println("finalSum :: "+finalSum);
		if (finalSum == input)
		{
			System.out.println("Armstrong Number !!!");
		}
		else
		{
			System.out.println("Not Armstrong Number !!!");
		}
	}
}