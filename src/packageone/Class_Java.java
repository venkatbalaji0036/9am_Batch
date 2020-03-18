package packageone;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Class_Java {
	public static void main(String args[]) {
		Class_Java obj = new Class_Java();
		obj.Java_Operations();
	}
	
	//Conditional Statements
	/*
	 * 2 conditional(if, switch)
	 * 3 Looping statement( for, while, do-while)
	 */
	public void Java_Operations() {
		int i=10;
		int j=20;
		int k=20;
		
		if(i>j) {
			System.out.println("i is greater than j");
		}else if(j>=k){
			System.out.println("j is greater than or eqaul to k ");
		}else {
			System.out.println("This is in else part");
		}
		
		System.out.println("==================================================");
		int m=j;
		switch(m) {
		case 10: 
			System.out.println("This is the value of i");
			break;
		case 20:
			System.out.println("This is the value of j and k");
			break;
		default:
			System.out.println("This is not a value equalent to 10 and 20");
			break;
		}
		
		System.out.println("==================================================");
		
		//Looping statements
		
		for(int n=i;n<=j;n++) {
			System.out.println(n);
		}
		
		System.out.println("==================================================");
		
/*		while(i<=j) {
			System.out.println(i);
			i=i+1;
			if(i==15) {
				i=i+1;
			}
		}*/
		
		System.out.println("=================================================");
		
		int x=9;
		do {
			x=x+1;
			if(x!=15) {
				System.out.println(x);
			}else {
				break;
			}
		}while(x<j);
	
	//
		/*
		 *  Fibonacci series

 Prime number

 Factorial

 Armstrong number

		 * 
		 * 
		 * 
		 */
		
		
		//0 1 1 2 3 5 8 13 .... 
		
/*		int y=0;
		int z=1;
		
		int temp = y+z;
		syoso temp
		
		
		 y = z;
		z = temp;
		
		temp = y+z;
		syso temp; */
		
		
		//Prime number
		
	/*	13/2 = 6.5 = 7
		
		13/1 = 0
		13/2 = 
		13/3
		13/4
		13/7*/
		
		
	/*	10!
		
		10*9*8*7*6*5*4*3*2*1
		
		int value=1;
		for(int i=10;i<1;i--) {
			System.out.println(i);
			value=value*i;
		} */
		
		//1634
		
	/*	
		1^4+6^4+3^4+4^4 = 1634
		
		
		10)1634(163
		   1630
		 --------
		      4
		 --------
		
		 
		 10)163(16
		    160
		    ---
		      3
		    ---
		
		*/
		
		
		
		System.out.println("===========================================================");
		
		int Array1[] = new int[5];
		int []Array2 = new int[5];
		int[] Array3 = new int[5];
		
		Array1[0] = 10;
		Array1[1] = 20;
		//Array1[2] = 30;
		Array1[3] = 40;
		Array1[4] = 50;
		//Array1[5] = 50;
		
		for(int a=0;a<Array1.length;a++) {
			System.out.println(Array1[a]);
		}
		
		
		System.out.println("======================================================");
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		
		LocalDateTime date_time = LocalDateTime.now();
		System.out.println(date_time);
		
		ZoneId zid = ZoneId.of("-05:00");
		
		LocalDateTime date_time1 = LocalDateTime.now(zid);
		System.out.println(date_time1);
		
		System.out.println("======================================================");
		
		
		
		String str1 = new String();
		str1 = "This is a String";
		
		String str2 = " This is a second string";
		
		System.out.println(str1.charAt(10)); // S
		System.out.println(str1.compareTo(" "+str2)); 
		System.out.println(str1+" "+str2);
		System.out.println(str1.contains("String"));
		System.out.println(str1.indexOf('S'));
		System.out.println(str1.length());
		System.out.println(str1.replace('s', 'Z'));
		System.out.println(str1.substring(2, 11));
		System.out.println(str1.trim());
		//System.out.println(str1.);
		
		System.out.println("==========================================================");
		
		//Conversions
		int VariableOne = 10;
		String StringOne = "20";
		
		System.out.println(Integer.toString(VariableOne)+StringOne);
		System.out.println(VariableOne+Integer.parseInt(StringOne));
		
		
		System.out.println("=========================================================");
		
		ArrayList<Integer> AL = new ArrayList<Integer>();
		AL.add(10);
		AL.add(20);
		AL.add(30);
		AL.add(40);
		AL.add(30);
		
		System.out.println(AL);
		
		System.out.println(AL.contains(30));
		System.out.println(AL.remove(3));
		System.out.println(AL.size());
		System.out.println(AL.get(3));
		AL.add(4, 60);
		System.out.println(AL);
		
		System.out.println("============================================================");
		
		LinkedList<Integer> LL = new LinkedList<Integer>();
		LL.add(100);
		LL.addAll(AL);
		System.out.println(LL);
		LL.addFirst(1000);
		LL.addLast(2000);
		System.out.println(LL);
		LL.removeAll(AL);
		System.out.println(LL);
		System.out.println(LL.size());
		
		System.out.println("============================================================");
		
		HashSet<Integer> HS = new HashSet<Integer>();
		HS.add(5);
		HS.addAll(LL);
		HS.addAll(AL);
		System.out.println(HS);
		
		System.out.println(HS.size());
		
		System.out.println("============================================================");
		
		LinkedHashSet<Integer> LHS = new LinkedHashSet<Integer>();
		LHS.add(8);
		LHS.addAll(LL);
		LHS.addAll(AL);
		LHS.addAll(HS);
		
		System.out.println(LHS);
		
		//System.out.println(LHS.);
		
		System.out.println("============================================================");
		
		HashMap<Integer, String> HM = new HashMap<Integer, String>();
		HM.put(1230, "Employee1230");
		HM.put(1231, "Employee1231");
		HM.put(1232, "Employee1232");
		HM.put(1233, "Employee1233");
		HM.put(1234, "Employee1234");
		HM.put(1235, "Employee1235");
		HM.put(1236, "Employee1235");
		
		
		System.out.println(HM);
		
		System.out.println("============================================================");
		
		LinkedHashMap<Integer, String> LHM = new LinkedHashMap<Integer, String>();
		LHM.put(1001, "1001Employee");
		System.out.println(LHM);
		LHM.putAll(HM);
		System.out.println(LHM);
		System.out.println(LHM.containsKey(1234));
		System.out.println(LHM.remove(1234));
		System.out.println(LHM);
		System.out.println(LHM.size());
		//System.out.println(LHM.);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
