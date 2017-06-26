 	package com.codingalgo.examples.DesignPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeDesignPattern {

	public static void main(String[] args) {
		
		EmployeeComponent ceo = new EmployeeComposite("Chuck Robbins", Designation.CEO, 1000001,""); 
		EmployeeComponent vp = new EmployeeComposite("Gopalratnam", Designation.VicePresident, 100001,"\t"); 
		EmployeeComponent director_1 = new EmployeeComposite("Raman Prabhakaran", Designation.Director, 1000,"\t\t");
		EmployeeComponent manager_3 = new EmployeeComposite("Sujata Joshi", Designation.Manager, 103,"\t\t\t");
		EmployeeComponent director_2 = new EmployeeComposite("Stephen Liem", Designation.Director, 1000, "\t\t");
		EmployeeComponent manager_1 = new EmployeeComposite("Jeff Lawless", Designation.Manager, 101,"\t\t\t");
		EmployeeComponent manager_2 = new EmployeeComposite("Janet Su", Designation.Manager, 102,"\t\t\t");
		EmployeeComponent  team_1_1 = new Employee("Hiral Shah", Designation.TeamMember, 11,"\t\t\t\t");
		EmployeeComponent team_1_2 = new Employee("Resmi K.", Designation.TeamMember, 12,"\t\t\t\t");
		EmployeeComponent team_1_3 = new Employee("Pavan S.", Designation.TeamMember, 13,"\t\t\t\t");
		EmployeeComponent team_2_1 = new Employee("Ramkumar S.", Designation.TeamMember, 14,"\t\t\t\t");
		
		ceo.addEmployee(vp);
		vp.addEmployee(director_1);
		vp.addEmployee(director_2);
		director_1.addEmployee(manager_3);
		director_2.addEmployee(manager_1);
		director_2.addEmployee(manager_2);		
		manager_1.addEmployee(team_1_1);
		manager_1.addEmployee(team_1_2);
		manager_1.addEmployee(team_1_3);		
		manager_2.addEmployee(team_2_1);
		
		ceo.print();
	}
}



enum Designation {CEO, VicePresident,Director, Manager, TeamMember; }

abstract class EmployeeComponent {
	
	public void addEmployee(EmployeeComponent e){
		throw new UnsupportedOperationException();
	}
	
	public void removeEmployee(EmployeeComponent e){
		throw new UnsupportedOperationException();
	}
	
	public EmployeeComponent getChild(int i){
		throw new UnsupportedOperationException();
	}
	
	public String getName(){
		throw new UnsupportedOperationException();
	}
	
	public Designation getDesignation(){
		throw new UnsupportedOperationException();
	}
	
	public int getSalary(){
		throw new UnsupportedOperationException();
	}
	
	public void print(){
		throw new UnsupportedOperationException();
	}
}	

class EmployeeComposite  extends EmployeeComponent	{
	
		ArrayList<EmployeeComponent> subordinates;
		
		String empName;
		Designation desg;
		int salary;
		String tab;
		
		public EmployeeComposite(String empName, Designation desg, int salary, String tab){
			this.empName=empName;
			this.desg=desg;
			this.salary=salary;
			this.tab=tab;
			subordinates = new ArrayList<>();
		}
		
		public EmployeeComponent getChild(int i) {
			return subordinates.get(i);
		}
		
		public String getEmpName() {
			return empName;
		}
		
		public Designation getDesg() {
			return desg;
		}
		
		public int getSalary() {
			return salary;
		}
		
		public void addEmployee(EmployeeComponent e){
			subordinates.add(e);
		}
		
		public void removeEmployee(EmployeeComponent e){
			subordinates.remove(e);
		}
			
		public void print(){
			System.out.println(tab+"Designation: " +desg);
			System.out.println(tab+"Employee Name: " +empName+  " ; Salary: " +salary);
			System.out.println();
			
			Iterator<EmployeeComponent> itr = subordinates.iterator();
			while(itr.hasNext()){
					itr.next().print();
			}
		}
}

class Employee extends EmployeeComponent{
	
	String empName;
	Designation desg;
	int salary;
	String tab;
	
	public Employee(String empName, Designation desg, int salary, String tab){
		this.empName=empName;
		this.desg=desg;
		this.salary=salary;
		this.tab=tab;
	}
	
	public String getEmpName() {
		return empName;
	}
	public Designation getDesg() {
		return desg;
	}
	public int getSalary() {
		return salary;
	}	
	
	public void print(){
		System.out.println(tab+"Designation: " +desg);
		System.out.println(tab+"Employee Name: " +empName+  " ; Salary: " +salary);
		System.out.println();
	}
	
}