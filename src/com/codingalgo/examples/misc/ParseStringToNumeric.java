package com.codingalgo.examples.misc;

import static java.lang.Math.*;

public class ParseStringToNumeric {

//	'5' has the ASCII value 53; '0' has the ASCII value 48
//	if we write '5'-'0' it evaluates to 53-48, or the int 5
//	if we write char c = 'B'+32; then c stores 'b'
//	if we write char c = 'b'-32; then c stores 'B'
//	ASCII table : https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
	
	public static void main(String[] args) {
		
		System.out.println('c' - '0');	
//		System.out.println(toInt("1234"));
		System.out.println(convertFloat("125.341"));
	}
	
	//for loop
	public static int convertString(String number){

			int len = number.length()-1;
		    int sum = 0;
		    for(int i = 0 ; i < number.length() ; i++, len--){
		        sum += (number.charAt(i) - '0') * pow(10,len);    
		    }		
		    return sum;
		}
	
	//recursive
	public static int toInt(String s) {
	    if(s.length() == 1) {
	        return s.charAt(0) - '0';
	    } else {
	        return  (int) ((s.charAt(0) - '0') * Math.pow(10, s.length() - 1) + toInt(s.substring(1)));
	    //  return (s.charAt(s.length() - 1) - '0') + 10 * toInt(s.substring(0, s.length() - 1));    
	    }
	}
	
	public static float convertFloat(String number){
	    
	    float sum = 0;
	    String[] parts = number.split("\\.");
	    	 
	    sum += convertString(parts[0]);
	    sum += convertString(parts[1]) * Math.pow(10, -1*parts[1].length());
	    
	    return sum;

	}
}
