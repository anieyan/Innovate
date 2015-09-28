package innovate;



import java.util.Arrays;
import java.util.Scanner;

public class shops {
	 int min1 = 105;
	 int min2 =105;
	 int fr=1,fc=1,sc = 1,loop1=0;
	 int flag = 1, switchFlagB = 4, switchFlagA = 4;
	 int y=0, z=0, sameFlag = 0;
	 
	 public void purchase(int data[][], int optimal[])
	 {
 
		 		  
		   for(int i=0; i <data.length; i ++ )
		    {
			   
			   for(int j=0; j <data[0].length; j ++ )
			    {
				   if (data[i][j] < min1 && i == loop1)        // Find min  for 1st shop
				    {
					    min1 = data[i][j];
				        fr = i;
				        fc = j;
				    }
				   else 
				    {
					   if (data[i][j] < min2 && i != loop1)   // Find min  for next shop
					   {
					    min2 = data[i][j];
					    sc = j;
					   }
				    }
				   if(data[0].length == j+1  && i != loop1)   // If items are over for next shops
				   {
					   if(fc == sc)							  // If min for adjacent shop for the same item
					   {
						   min1=  findOptimal(i,fr,fc,min1,min2,data,optimal);
						   min2 =105;
						   flag = 0;
					   }
					   else
					   {
						   if(i == loop1+1)
						   {
						   optimal[i-1] = min1;
						   optimal[i] = min2;
						   }
						   else optimal[i] = min2;
					       switchFlagB = fc;	
						   fr = i;
					       fc = sc;
					       min1 = min2;
					       min2 = 105;
				   
					   }
				   }
				   else if(data.length == 1  && i == loop1)optimal[i] = min1;
			    }
		    }
		   System.out.println(Arrays.toString(optimal));
	 }
		   
	  public int findOptimal(int rec, int i, int j, int min1, int min2, int data[][], int optimal[])
	   {
		  int temp1 = 105, temp2 = 105;
		  for (int k=rec-1; k<rec+1; k++)
		  {
			  for(int l=0; l <data[0].length; l ++ )
			    {
				  if(k==rec-1)
				  {
				   if (data[k][l] == min1 && j != l && switchFlagB !=l)  // To check if the min1, has same equal min in the same shop.
				    {
					    optimal[i] = min1;						// Rate for  1
					    optimal[i+1] = min2;				    // Rate for  2
					    fr = i+1;								// set the row id for next shop
					    fc = l;								    // set the col id for next shop
					    return min1;
				    }
				   else if (data[k][l] < temp1 && data[k][l] > min1 && switchFlagA !=l && switchFlagB !=l)  // To get second min in the same shop.
				   {
					   temp1 = data[k][l];
					   switchFlagA = l;
				   }
				  }
				   
				  else
				  {
					   if (data[k][l] == min2 && j != l)			// To check if the min2, has same equal min in the same shop.
					    {
						    optimal[i] = min1;			   			// Rate for  1
						    optimal[i+1] = min2;					// Rate for  2
						    fr = i+1;								// set the row id for next shop
						    fc = l;								    // set the col id for next shop
						    switchFlagB = sc;
						    return min2;
					    }
					   else if (data[k][l] < temp2 && data[k][l] > min2)  // To get second min in the same shop.
					   {
						   temp2 = data[k][l];
						   y = i+1;								// set the row id for next shop
						   z = l;							    // set the col id for next shop
						   
					   } 
				  }
				   
			    }
		  }
		  if((min1 + temp2 < min2 + temp1) || min1 + temp2 == min2 + temp1 && sameFlag == 0)
		  {
			    if(min1 + temp2 == min2 + temp1)
				{
				  sameFlag = 1;
				}
			    optimal[i] = min1;						// Optimal Rate for  1
			    optimal[i+1] = temp2;					// Optimal Rate for  2
			    fc = z;
			    fr = y;
			    switchFlagA = j;
			    min1 = temp2;
		  }
		  else
		  {
			    if(min1 + temp2 == min2 + temp1)
				{
				    sameFlag = 0;
				}
			    optimal[i] = temp1;						// Optimal Rate for  1
			    optimal[i+1] = min2;					// Optimal Rate for  2
			    min1 = min2;
			    fr = y;
			    fc = sc;

		  }
		  return min1;
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
	   public int check(boolean lcl_num,int in,String str_input, int maxi)
	   {
		   Scanner sca_input = new Scanner(System.in);
		  	  while (lcl_num == false) { 	  
		  		lcl_num =isInt(str_input.trim(),lcl_num);
			  		if(lcl_num)
			  		{
			  			in = Integer.parseInt(str_input.trim());

			  		}if(in < 1 || in > maxi || !lcl_num) 
			  		{
				  		System.out.println("Wrong input!");
				  		str_input = sca_input.nextLine();
				  		lcl_num = false;
			  		}
			  	  }
		  	  return in;
	   }
	   public int bestRates(int rate, int fData[])
	   {
		   rate = 0;
		      for(int i=0; i <fData.length; i ++ )
		      {
					   rate += fData[i];
		      }
		   return rate;
	   }
	public static void main(String[] args) {
		
		Scanner sca_input = new Scanner(System.in);
		String[] pieces = null;
		shops ss =new shops();
		boolean bln_num = false;
		System.out.println("Enter the number of Testcases!");	
		String str_input = sca_input.nextLine();
		int testCases = 1, ten = 10;
		testCases = ss.check(bln_num,testCases,str_input,ten);
		
		bln_num = false;
		System.out.println("Enter the number of Shops!");
		str_input = sca_input.nextLine();
		int input = 1, ohf = 105;
		input = ss.check(bln_num,input,str_input,ohf);

		
		String rates = "";
		int optimal[] = new int[input];
		int data[][] = new int[input][3];
			
	      for(int k=0; k <testCases; k ++ )
	      {
		System.out.println("Enter Rates!");
		int finalRate = input * 105;
	      for(int i=0; i <data.length; i ++ )
	      {
		    	  rates = sca_input.nextLine();
		    	  pieces = rates.split("\\s+");
		    	  	    	  
		    	  while (pieces.length != 3) { 	   
	    	    	
		    	          System.out.println("Wrong inputs!");
				    	  rates = sca_input.nextLine();
				    	  pieces = rates.split("\\s+");
		    	  }
		    	        
				  for(int j=0; j <pieces.length; j ++ )
				  {
					  
					  bln_num = ss.isInt(pieces[j],bln_num );
					  if(bln_num && Integer.parseInt(pieces[j]) > 0 && Integer.parseInt(pieces[j]) < 105){
			    	  data[i][j]=Integer.parseInt(pieces[j]);
					  }
					  else{
						  i--;
						  System.out.println("Wrong!");
						  break;
					  }
			      }
	      }
		    System.out.println("Output!");			  
			ss.purchase(data,optimal);
			finalRate = ss.bestRates(finalRate,optimal);
			System.out.println("Cost :" + finalRate);	
//		    if(ss.sameFlag ==1) // If the rates are equal in the next to shop, do a swap.
//			  {
//		   	    ss.min1 = 105;
//			    ss.min2 =105;
//		    	ss.switchFlagA = 4;
//		    	ss.purchase(data,optimal);
//		    	ss.sameFlag = 0;
//			  }
	      }
	}
	
}
