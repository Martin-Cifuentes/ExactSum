package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static int[] nombreDelArreglo;
	public final static String SEP = " ";
	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public final static Scanner sc = new Scanner (System.in);
	public static ArrayList<String> answers = new ArrayList<String>();
	//public static ArrayList<Integer> solution = new ArrayList<Integer>();
	//public static Integer[] solution;
	
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
		

			
			
			//System.out.println("Ingrese la cantidad de libros, sus precios y el total de dinero que tiene");

			
			int totalMoney = 0;
			String[] bookPrices;
			
			String line = br.readLine();
			
			while(!line.equals("") && line != null){
				
				try {
				int cantBooks= Integer.parseInt(line);
				Integer[] solution = new Integer[cantBooks];
				line = br.readLine();
				
				
				bookPrices = line.split(SEP);
				
				line = br.readLine();
				
				
				totalMoney = Integer.parseInt(line);
				
				
				Integer[] prices = toIntegerArray(bookPrices);
				
				//String[] results = searchBestPrices(prices,totalMoney).split(SEP);
				Integer[] ans = toIntegerArray(searchBestPrices(prices,totalMoney).split(SEP));
				
				//selectionSort(prices);
				solution = (Integer[])arrayListSort(prices).toArray();
				
				
				
				int x = binarySearch(solution,ans[0]);
				
				int y = binarySearch(solution,ans[1]);
				
				
				line = br.readLine();
				
				
				line = br.readLine();
				
				bw.newLine();
				
				
				answers.add("Peter should buy books whose prices are " + solution[y] + " and " + solution[x] + ".\n");
				
				}
				catch(NumberFormatException nfe) {
					System.out.println("Los precios deben ser numericos" );
					return;
				}
				catch(Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				
				
				
			}
			
			
		}
			
	public static String searchBestPrices(Integer[] prices, int total) {
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
	
	public static Integer[] toIntegerArray(String[] strArray) {
		Integer[] intArray = new Integer[strArray.length];
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
	
	public static List<Integer> arrayListSort(Integer[] array) {
		List<Integer> numbers = new ArrayList <>();
		numbers = Arrays.asList(array);
		Collections.sort(numbers);
		return numbers;
	}
	
	/*public static void bubbleSort(int[] prices) {
		for(int j = 0; j < prices.length-1; j++) {
			for(int i = 0; i < prices.length-1; i++) {
				if(prices[i]>prices[i+1]) {
					int temp = prices[i];
					prices[i] = prices[i + 1];
					prices[i + 1] = temp;
					
				}
				
			}
			
		}
		
		
		
	}*/
	public static void selectionSort(int[] prices) {
		for(int i = 0 ; i < prices.length; i++) {
			int min = prices[i];
			for(int j = i+1; j < prices.length; j++) {
				if(prices[j] < min) {
					int temp =  prices[j];
					prices[j] = min;
					min = temp;
				}
			}
			prices[i] = min;
		}
	}
	/*public static void insersionSort(int[] prices) {
		for(int i = 1; i < prices.length; i++) {
			for(int j = i; j > 0 && prices[j-1]> prices[j];j--){
				int temp = prices[j];
				prices[i] = prices[j - 1];
				prices[j - 1] = temp;
			}
		}
	}
	*/
	/*public static int binarySearch(ArrayList<Integer> a, int x) {
		int pos = -1;
		int i = 0;
		int j = a.size()-1;
		
		
		while(i <= j &&	pos<0) {
			int m = (i + j)/2;
				if(a.get(i) == x) {
					pos = m;
				}else if(a.get(i)>x){
					j = m+1;
				}else {
					i = m + 1;
				}
		}
		
		return pos;
		
	}*/
	public static int binarySearch(Integer[] a, int x) {
		int pos = -1;
		int i = 0;
		int j = a.length-1;
		int m = 0;
		
		while(i <= j &&	pos<0) {
			
			m = (i + j)/2;
			if(a[m] == x) {
				pos = m;
			}else if(a[m]>x){
				j = m-1;
			}else {
				i = m + 1;
			}
		}
		
		return pos;
		
	}
	
	
}