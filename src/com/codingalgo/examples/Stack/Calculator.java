package com.codingalgo.examples.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given an arithmetic equation consisting of positive integers,+,-,* and/ (no parentheses), compute the result.
 * 
	EXAMPLE
	Input: 2*3+5/6*3+15
	Output: 23.5
 *
 */
public class Calculator {
	
	public static void main(String[] args) {
		String equation = "2*3+5/6*3+15";
		Map<Character,Integer> priority = new HashMap<>();
		priority.put('+',1);
		priority.put('-',1);
		priority.put('*',2);
		priority.put('/',2);
		
		calculate(equation,priority);
	}
	
	//	2*3+5/6*3+15
	public static void calculate(String eq,Map<Character,Integer> priority){
		Stack<Double> number = new Stack<>();
		Stack<Character> operator = new Stack<>();
		
		for(int i = 0 ; i < eq.length() ; i++){
			char c = eq.charAt(i);
			if(Character.isDigit(c)){
				StringBuffer  sb = new StringBuffer();
				sb.append(eq.charAt(i));
				while(i+1 < eq.length() && Character.isDigit(eq.charAt(i+1))){
					i++;
					sb.append(eq.charAt(i));
				}
				number.push(Double.parseDouble(sb.toString()));
			}else{
					while(!operator.isEmpty() && checkPriority(priority, c, operator.peek())){
						double value = compute(number.pop(),number.pop(),operator.pop());
						number.push(value);
					}
					operator.push(c);
			}
		}
		System.out.println("Output = "+compute(number.pop(),number.pop(),operator.pop()));
	}
	
	public static boolean checkPriority(Map<Character,Integer> priority, char op, char topOp){
		return priority.get(op) <= priority.get(topOp);
	}
	
	public static double compute(double b, double a, char op){
		switch(op){
			case '+' : return a + b;
			case '-' : return a - b;
			case '*' : return a * b;
			case '/' : return a / b;
		}
		return 0;
	}

}
