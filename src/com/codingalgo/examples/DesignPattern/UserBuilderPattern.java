package com.codingalgo.examples.DesignPattern;

public class UserBuilderPattern {
	
		private String fname; 
		private String lname;
		private String age;
		private String addr;
		
		private UserBuilderPattern(UserBuilder builder){
			this.fname=builder.fname;
			this.lname=builder.lname;
			this.age=builder.age;
			this.addr=builder.addr;
		}
		
		public String getFname() {
			return fname;
		}
		public String getLname() {
			return lname;
		}
		public String getAge() {
			return age;
		}
		public String getAddr() {
			return addr;
		}
		
		public String toString(){
			return fname + " "+ lname + " " + age +" " +addr;
		}
		
		private static class UserBuilder{
			
			private String fname;
			private String lname;
			private String age;
			private String addr;
			
			public UserBuilder fname(String fname){
				this.fname=fname;
				return this;
			}
			
			public UserBuilder lname(String lname){
				this.lname=lname;
				return this;
			}
			
			public UserBuilder age(String age){
				this.age=age;
				return this;
			}
			
			public UserBuilder addr(String addr){
				this.addr=addr;
				return this;
			}
			
			public UserBuilderPattern build(){
				return new UserBuilderPattern(this);
			}
		}
			
   public static void main(String[] args) {
	   
	   UserBuilderPattern obj = new
			   									UserBuilderPattern.UserBuilder()
		   											.fname("Hiral")
		   											.lname("Shah")
		   											.age("33")
		   											.addr("USA")
		   											.build();
	   
	   System.out.println(obj);
	   
   }
}
