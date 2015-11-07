package innovate;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
 

public  class Challenge {
	/**
	 * @param args
	 */
	
	String[] arrNames;
	String[] arrdoj;
	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	int empId;
	int salInc;
	static int input = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Challenge objclg = new Challenge();
		int input = 0;
		System.out.println("Enter the Question no to display the result!");
		System.out.println("Question 1 ");
		System.out.println("Question 2 ");
		System.out.println("Question 3 ");
		System.out.println("Question 4 ");
		System.out.println("Question 5 ");
		System.out.println("Exit 6 ");
		input = objclg.select();
		if(input < 6)
		{
		System.out.println("Output !!!");
		}
		if(input == 1)
		{
			objclg.indexof();
		}else if(input == 2){
			objclg.removeDuplicate();
		}else if(input == 3){
			objclg.employeeHM();
		}else if(input == 4){
			objclg.employeeList();
		}else if(input == 5){
			objclg.toUpper();
		}else{
			System.out.println("Exited !!!");
			System.exit(0);
		}
		
	}
	
	public int select()
	{
		
		boolean bln_num = false;

		Scanner sca_input = new Scanner(System.in);
		String str_input = sca_input.nextLine();
		bln_num =isInt(str_input.trim(),bln_num);
		if(bln_num)
		{
		input = Integer.parseInt(str_input);
		if(input >6 || input <1)
		{
			System.out.println("Wrong input, select again!");
			select();
		}
		}else{
			System.out.println("Enter only integer from 1 to 6!");
			select();
		}
		return input;
	}

	
	  public boolean isInt(String pos, boolean lcl_number)
	  {
		  lcl_number = true;
		     for(int i=0; i<pos.length();i++)
		     {
		         if(!Character.isDigit(pos.charAt(i)))
		         {
		        	 lcl_number = false;
		        	 break;
		         }
		     }
	         return lcl_number;
	  }
	public void toUpper()
	{
		
		FileWriter writer = null;
		String strPrint = "";
		String strPath = System.getenv("TEMP");
		File file = new File(strPath+"\\Hello1.txt");
		File file2 = new File(strPath+"\\Hello2.txt");
	      // creates the file
	      try {
			file.createNewFile();

	      file2.createNewFile();
	      // creates a FileWriter Object
	      writer = new FileWriter(file); 
	      // Writes the content to the file
	      writer.write("5.	Read a file with text content in lower case " +System.getProperty("line.separator")+" and write it into another file " +System.getProperty("line.separator")+" in upper case. File should consist of several lines.\n"); 
	      writer.flush();
	      writer.close();

	      //Creates a FileReader Object
	      FileReader fr = new FileReader(file); 
	      char [] a = new char[500];
	      fr.read(a); // reads the content to the array
	      writer = new FileWriter(file2);
	      for(char c : a)
	      {
	    	  strPrint +=c; //prints the characters one by one  	  
	      }
	      fr.close(); 

	      writer.write(strPrint.toUpperCase()); 
	      writer.flush();
	      writer.close();

System.out.println("Files stored in your TEMP directory :"+strPath+"\\Hello2.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public  String recursive(String input,int i){
	    String strlclOut="";
        if(input.charAt(i-1) != input.charAt(i)){
        	strlclOut = strlclOut +input.charAt(i);
        }
        return strlclOut;
	}
	public  void indexof(){
				String strsen= "There was a woman name:rose: and a man name:john: and their friend name:stella: and...";
				int index = strsen.indexOf(":");
				boolean  blnflag = true;
				int index2 = 0;
				while (index >= 0) {
					if(blnflag)
					{
				    index2 = strsen.indexOf(":", index+1);
				    System.out.println(strsen.substring(index+1,index2));
				    index = index2;
				    blnflag = false;
					}
					else 
						{blnflag = true;
						index = strsen.indexOf(":", index+1);			
						}
				}
		}
	public  void removeDuplicate(){
        String strInput="abbbcdd";
		System.out.println("Entered String : "+strInput);
        String strOutput="";
        for (int i=0; i<strInput.length() ; i++){
            if(i==0){
            	strOutput = ""+strInput.charAt(i);
            }else{
            	strOutput += recursive(strInput, i);              	 
            }           
        }
        System.out.println(strOutput);
    }
	
	public  void employee(){
	
		 arrNames = new String[]{"Sunil", "Lee", "Mark", "Arnold"};
		 arrdoj = new String[]{"2013-09-30","2013-07-06","2013-12-01","2013-11-01"};
		 empId = 8;
		 salInc = 25000;
	}
	
    
	public  void employeeList(){   
		employee();		
		ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();
		for(int i = 0; i < arrNames.length; i++) {

				try {
					listOfEmployees.add(new Employee(arrNames[i],100000,empId, dateFormatter.parse(arrdoj[i]) ));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		Collections.sort(listOfEmployees, new PersonDOJComparator());// Line 2
        System.out.println("List Sorted By Date of Joining");
        displayPersons(listOfEmployees);


	}
	
	 private  void displayPersons(ArrayList<Employee> emp){
	        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        System.out.println("----------------------------------------------------------");
        	System.out.println(" DOJ   |  Salary  |  Name\n");
	        for(Employee emps:emp){
	            System.out.print(dateFormat.format(emps.doj));
	            System.out.print(" "+emps.salary+" ");
	        	System.out.println(emps.name);
	        }
	        System.out.println("----------------------------------------------------------");
	    }
	 
	public class PersonDOJComparator implements Comparator<Employee> {
		 
	    public int compare(Employee on, Employee tw) {
	        return on.doj.compareTo(tw.doj);
	    }
	 
	 
	}
	
	public  void employeeHM(){      		
		employee();
        HashMap<Integer,Employee> EmployeeMap=new HashMap<Integer,Employee> ();
        
		for(int i = 0; i < arrNames.length; i++) {
			try {
				EmployeeMap.put(i, new Employee(arrNames[i],100000,empId, dateFormatter.parse(arrdoj[i]) ));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empId++;
		}

        			Iterator<Integer> EmployeeIter=EmployeeMap.keySet().iterator();
        			while(EmployeeIter.hasNext())
        	        {
        				Employee EmployeeObj=EmployeeMap.get(EmployeeIter.next());
        				if(EmployeeObj.empId < 11)
        				{
        					EmployeeObj.setSal(salInc);
        				}
        				System.out.println("Emp ID : "+EmployeeObj.empId+" Emp Name : "+EmployeeObj.name+" Salary : "+EmployeeObj.salary+" Date of Joi : "+EmployeeObj.doj);
        	        }
	}
	public static class Employee {
		 String name;
		 int salary;
		 int empId;
		 Date doj;
		 public Employee(String name, int salary, int empId,Date doj) {
		  this.name = name;
		  this.salary = salary;
		  this.empId = empId;
		  this.doj = doj;
		 }
		 

		 public String getSal() {
		  return name;
		 }
		 public void setSal(int salary) {
		  this.salary += salary;
		 }

	}
	
	

}

