/**
 * 
 */
package com.GreatLearning.Stockers;

import java.util.Scanner;

import com.GreatLearning.Stockers.Checks.Driver;

/**
 * @author Neeraj Tiwari
 *
 */
public class Main {

	private double stockPrice[];
	private boolean isUpOrDown[];
	private int numberOfCompanies;
	Driver myDriver = new Driver();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main myMain = new Main();
		myMain.getInputs();
		myMain.choiceMakers();
	}
	
	/**
	 * Use this Function to get the Inputs
	 */
	public void getInputs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of companies");
	    numberOfCompanies = sc.nextInt();
		
		stockPrice = new double[numberOfCompanies];
		isUpOrDown = new boolean[numberOfCompanies];
		
		for(int i=0;i<numberOfCompanies;i++)
		{
			System.out.println("Enter current stock price of the company "+(i+1));
			stockPrice[i] = sc.nextDouble();
			
			try
			{
				System.out.println("Whether company's stock price rose today compare to yesterday? ");
				isUpOrDown[i] = sc.nextBoolean();	
				
			}catch (Exception InputMismatchException)
			{
				System.out.println("Enter in right format (true or false)");
				System.out.println("Whether company's stock price rose today compare to yesterday? ");
				isUpOrDown[i] = sc.nextBoolean();	
			}

		}	
	}
	
	/**
	 * Use this function module to make the choices
	 */
	public void choiceMakers()
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("-----------------------------------------------\n" + 
					"Enter the operation that you want to perform\n" + 
					"1. Display the companies stock prices in ascending order\n" + 
					"2. Display the companies stock prices in descending order\n" + 
					"3. Display the total no of companies for which stock prices rose today\n" + 
					"4. Display the total no of companies for which stock prices declined today\n" + 
					"5. Search a specific stock price\n" + 
					"6. press 0 to exit\n" + 
					"---------------------------");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: myDriver.displayStockPrices(true, stockPrice, 0,stockPrice.length-1); 
						break;
						
				case 2: myDriver.displayStockPrices(false, stockPrice, 0, stockPrice.length-1); 
						break;
				
				case 3: System.out.println(myDriver.companiesWithPriceRoseToday(isUpOrDown));
						break;
				
				case 4: System.out.println(myDriver.companiesWithPriceDeclinedToday(isUpOrDown));
						break;
				
				case 5: System.out.println(myDriver.searchSpecificStockPrice(stockPrice));
						break;
				
				case 0: break;
				
				default: System.out.println("Please enter a valid choice!!"); break;	
			}
		}				
		while(choice!=0);
	
	}

}
