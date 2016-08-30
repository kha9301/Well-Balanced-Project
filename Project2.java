
/*		08/03/2016
 * 		Kyeongmin Ha	
 * 		CUNY Queens College - CS 313 Data Structure 	
 * 		Project# 2
 * 		Professor: Joseph Svitak
 * 
 * 		Project2.java
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project2 {
	static String inputFileName = "project2.txt";

	public static void main(String[] args) throws IOException {

		try {
			BufferedReader brTest = new BufferedReader(new FileReader(inputFileName));

			FileInputStream in = new FileInputStream(inputFileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			
			// check if the txt File has a perfect matching brackets
			WellBalanced a = new WellBalanced(br);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
