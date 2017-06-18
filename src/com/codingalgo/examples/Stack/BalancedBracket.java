package com.codingalgo.examples.Stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedBracket {

	public static void main(String[] args) {
		
//		String[] expressionArray = {"()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}",
//				"{][({(}]][[[{}]][[[())}[)(]([[[)][[))[}[]][()}))](]){}}})}[{]{}{((}]}{{)[{[){{)[]]}))]()]})))[",
//				"[)](][[([]))[)",
//				"]}]){[{{){",
//				"{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){[",
//				"()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})",
//				"){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{",
//				"[(})])}{}}]{({[]]]))]})]",
//				"[{",
//				"{}([{()[]{{}}}])({})",
//				"{({}{[({({})([[]])}({}))({})]})}",
//				"()[]",
//				"{)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()((",
//				"[][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}",
//				"(}]}",
//				"(([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}",
//				"[(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}",
//				"()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]",
//				"({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[[",
//				")}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{",
//				"}([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}"};
//		
//		for (int a0 = 0; a0 < expressionArray.length; a0++) {
//            System.out.println((isBalanced(expressionArray[a0])) ? "YES" : "NO" );
//        }
        
		 System.out.println((isBalanced("(h[{l<l>o}!]~()()()(")) ? "YES" : "NO" );
	}
	
	/* public static boolean isBalanced(String expression) {
		 
		 System.out.println(expression.length());
		
	        
		 	if(expression.length() % 2 != 0){
	            return false;
	        }
	        
	        Set<Character> openBrackets = new HashSet<Character>();
	        Set<Character> closeBrackets = new HashSet<Character>();
	        Stack<Character> stack = new Stack<Character>();
	        Map<Character,Character> map = new HashMap<Character,Character>();
	        
	        map.put('(',')');
	        map.put('{','}');
	        map.put('[',']');
	        
	        openBrackets.add('{');
	        openBrackets.add('[');
	        openBrackets.add('(');
	        
	        closeBrackets.add('}');
	        closeBrackets.add(']');
	        closeBrackets.add(')');
	        
	        Character bracket;
	        
	        for(int i = 0 ; i < expression.length() ; i++){	            
	            bracket = expression.charAt(i);
	            
	            if(openBrackets.contains(bracket)){
	                stack.push(bracket);
	            }
	            
	            if(closeBrackets.contains(bracket)){
	               if(stack.isEmpty()){
	                   return false;
	               }else{
	                    Character c = stack.pop();
	                    if(!map.get(c).equals(bracket)){
	                        return false;
	                    }
	               }   
	            }
	        }
	        
	        if(!stack.isEmpty()){
	        	return false;
	        }
	        
	        return true;
	    }
    */
	
	 public static boolean isBalanced(String expression) {
		 
		 Stack<Character> stack = new Stack<Character>();
		 Map<Character,Character> map = new HashMap<Character,Character>();
		 map.put('(',')');
         map.put('{','}');
         map.put('[',']');
         
         Character paren;
         for(int i = 0 ; i < expression.length() ; i++){
        	 
        	 paren = expression.charAt(i);
        	 if(map.containsKey(paren)) {
        		 stack.push(paren);
        	 }else if(map.containsValue(paren)){
        		 if(!stack.isEmpty() && map.get(stack.peek()) == paren){
        			 stack.pop();
        		 }else{
        			 return false;
        		 }
        	 }
         }
         
         return stack.isEmpty();
		 
	 }
    
    
}
