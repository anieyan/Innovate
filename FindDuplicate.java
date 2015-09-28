package innovate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FindDuplicate {

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
	   public int check(boolean lcl_num,int in,String str_input)
	   {
		   Scanner sca_input = new Scanner(System.in);
		  	  while (lcl_num == false) { 	  
		  		lcl_num =isInt(str_input.trim(),lcl_num);
			  		if(lcl_num)
			  		{
			  			in = Integer.parseInt(str_input.trim());

			  		}if(!lcl_num) 
			  		{
				  		System.out.println("Wrong input!");
				  		str_input = sca_input.nextLine();
				  		lcl_num = false;
			  		}
			  	  }
		  	  return in;
	   }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindDuplicate fD = new FindDuplicate();
	      Scanner sca_input = new Scanner(System.in);
	      boolean bln_num = false;
		  ArrayList<String> lst_names = new ArrayList<String>();
	      
	      System.out.println("Enter the number");

	      String str_input = sca_input.nextLine();
	      int input =0;
	      input=  fD.check(bln_num,input,str_input);
	      
	      String str_names = null;
	      System.out.println("Enter names :");
	      for(int i=1; i <=input; i ++ )
	      {
	    	 str_names = sca_input.nextLine();
	    	 lst_names.add(str_names);
	      }
	      
	    Object[] obj_all = lst_names.toArray();
	      for (Object obj_tmp : obj_all) {
	        if (lst_names.indexOf(obj_tmp) != lst_names.lastIndexOf(obj_tmp)) {
	        	lst_names.remove(lst_names.lastIndexOf(obj_tmp));
	         }
	      }
	     Collections.sort(lst_names);

	     System.out.println("Output");
	      for(int i=0; i <lst_names.size() ; i ++ )
	      {
	 	     System.out.println(lst_names.get(i));
	      }

	}

}
