package fhc2016;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ThePriceIsCorrect {
	
	public static String NAME = "the_price_is_correct";
	public static String INPUT = "/Users/SB/Downloads/" + NAME + ".txt";
	public static String OUTPUT = "/Users/SB/Downloads/" + NAME + "_out.txt";

	private static String solve(BufferedReader reader) throws IOException {
		String firstLines[] = reader.readLine().split(" ");
		int N = Integer.parseInt(firstLines[0]);
		int P = Integer.parseInt(firstLines[1]);
		String secondLines[] = reader.readLine().split(" ");		
		int[] bis =  readNumbres(secondLines);
		int answer = 0;
		answer = answer(N,P,bis,1, answer);
		return String.valueOf(answer);
	}    
	
	/**
	 * @param n
	 * @param p
	 * @param bis
	 * @param answer
	 * @return
	 */
	private static int answer(int n, int p, int[] bis, int iteration, int answer) {
		//		
		if(iteration>bis.length) {
			return answer;
		}
		for(int i=0; i<bis.length; i++) {
			int sum = 0;
			for(int j=i; j<Math.min(i+iteration,bis.length) && (iteration<=bis.length-i); j++) {
				sum += bis[j];
				if(sum>p) {
					break;
				}
			}
			if(sum>0 && sum<=p) {
				answer++;
			}	
		}			
		return answer(n, p, bis, ++iteration, answer);
	}

	/**
	 * @param secondLines
	 * @return
	 */
	private static int[] readNumbres(String[] secondLines) {
		int[] values = new int[secondLines.length];
		for(int i=0; i < secondLines.length ; i++) {
			values[i] = Integer.parseInt(secondLines[i]);
		}
		return values;
	}


	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(INPUT));
		System.setOut(new PrintStream(new FileOutputStream(OUTPUT)));
		InputStream in = null;
		try {
		    in = System.in;
		    BufferedReader reader =
			new BufferedReader(new InputStreamReader(in));		    
		    int cases = Integer.valueOf(reader.readLine());
		    for (int i = 1; i <= cases; i++) {   
		    	System.out.println("Case #" + i + ": " + solve(reader));
		    }
		} catch (IOException x) {
		    System.err.println(x);
		} catch (NumberFormatException x) {
		    System.err.println(x);
		}
	    }

	
}
