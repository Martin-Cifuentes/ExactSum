package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
	public static int[] nombreDelArreglo;
	public final static String SEP = " ";
	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public final static Scanner sc = new Scanner (System.in);
	public static ArrayList<String> answers = new ArrayList();
	public static void main(String[] args) throws IOException {
		pedirDatos();
		mostrarDatos();

	}
	public static void mostrarDatos() {
		for(int i = 0; i < answers.size(); i++) {
			System.out.println(answers.get(i));
		}
	}
	public static void pedirDatos() throws IOException {
		

			
			
			System.out.println("Ingrese la cantidad de libros, sus precios y el total de dinero que tiene");

			int i = 0;
			int totalMoney = 0;
			String[] bookPrices;
			String line = br.readLine();
			
			while(!line.equals("") && line != null){
				
				try {
				int cantBooks= Integer.parseInt(line);
				
				line = br.readLine();
				
				
				bookPrices = line.split(SEP);
				
				line = br.readLine();
				
				totalMoney = Integer.parseInt(line);
				
				
				int[] prices = toIntegerArray(bookPrices);
				String[] results = searchBestPrices(prices,totalMoney).split(SEP);
				int[] ans = toIntegerArray(results);
				line = br.readLine();
				
				line = br.readLine();
				
				
				
				answers.add("Peter should buy books whose prices are " + ans[1] + " and " + ans[0] + ".\n");
				
				}
				catch(NumberFormatException nfe) {
					System.out.println("Los precios deben ser numericos" );
					return;
				}
				
				
				
			}
			
			
		}
			
	public static String searchBestPrices(int[] prices, int total) {
		int statX = 0;
		int statY = 0;
		int d = 99999;
		for(int i = 0; i < prices.length; i++) {
			for(int j = 0; j < prices.length; j++) {
				if(prices[i] < total) {
					if(i != j) {
						int temp = prices[i]-prices[j];
						if(temp >= 0 && temp < d && prices[j] + prices[i] == total) {
							d = temp;
							statX = prices[i];
							statY = prices[j];
						}
					}
				}
			}
		}
		String results = statX + " " + statY;
		return results;
		
		
	}
	/*5
10 2 6 8 4
10

10
5 9 8 10 11 20 2
20

*/
	
	public static int[] toIntegerArray(String[] strArray) {
		int[] intArray = new int[strArray.length];
		try {
			for(int i = 0; i< strArray.length; i++) {
				intArray[i] = Integer.parseInt(strArray[i]);
			}
		}
		catch(NumberFormatException nfe) {
			System.out.println("Los precios deben ser numericos");
		}
		
		return intArray;
		
	}
	
}