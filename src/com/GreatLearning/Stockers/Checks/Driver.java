/**
 * 
 */
package com.GreatLearning.Stockers.Checks;

import java.util.Scanner;

/**
 * @author Neeraj Tiwari
 *
 */
public class Driver {
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * isAscending if its true then display in ascending order
	 * isAscending if its false then display in descending order
	 * @param isAscending
	 * @param j 
	 * @param i 
	 * @param stockPrice 
	 */
	public void displayStockPrices(boolean isAscending, double[] stockPrice, int left, int right)
	{
		if(isAscending)
		{
			SortData mySort = new SortData();
			mySort.sort(stockPrice, left, right);
			for(int i=stockPrice.length-1;i>=0;i--)
			System.out.println(stockPrice[i]+" ");
		}
		else
		{
			SortData mySort = new SortData();
			mySort.sort(stockPrice, left, right);
			for(int i=0;i<stockPrice.length;i++)
			System.out.println(stockPrice[i]+" ");
		} 
	}
	
	/**
	 * Count for stocks whose price rose up today.
	 * @param isUpOrDown 
	 */
	public int companiesWithPriceRoseToday(boolean[] isUpOrDown)
	{
		int count=0;
		for(int i=0;i<isUpOrDown.length;i++)
		{
			if(isUpOrDown[i])
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Count for stocks whose price declined  today.
	 */
	public int companiesWithPriceDeclinedToday(boolean[] isUpOrDown)
	{
		int count=0;
		for(int i=0;i<isUpOrDown.length;i++)
		{
			if(!isUpOrDown[i])
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Search a Stock with specific price.
	 * @param stockPrice 
	 * @param searchPrice
	 */
	public String searchSpecificStockPrice(double[] stockPrice)
	{
		SortData mySort = new SortData();
		mySort.sort(stockPrice, 0, stockPrice.length-1);
		System.out.println("enter the key value");	
		double searchPrice = sc.nextDouble();
		int j=0;
		for(int i=0;i<stockPrice.length;i++)
		{
			if(stockPrice[i]==searchPrice) return "Stock of value "+searchPrice+" is present";
		}
		return "Value not found";
	}
	
	

}
