import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* DEVELOPER : PIYUSH SHARMA
 * DATE : 22 MAY 2020
 * LOCATION : NEW DELHI
 */

public class PiyushSharma_2019316_FinalAssignment 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***************************** WELCOME TO THE  CACHE IMPLEMENTATION *****************************");
		System.out.println();
		System.out.println("***************************** MAPPING TECHNIQUES *****************************");
		System.out.println();
		System.out.println("*********** 1. DIRECT MAPPING***************");
		System.out.println("*********** 2. FULLY ASSOCIATIVE MAPPING***************");
		System.out.println("*********** 3. K- WAY SET ASSOCIATIVE MAPPING***************");
		System.out.println();
		System.out.println("*********** PLEASE SELECT ONE OPTION ( 1 / 2 / 3 ) ***************");
		int choice = sc.nextInt();
		System.out.println();System.out.println();System.out.println();System.out.println();
		
		switch ( choice ) 
		{
			case 1 : direct();
					 break;
			case 2 : fully();
					 break;
			case 3 : kway();
					 break;
			default : System.out.println("ERROR: PLEASE ENTER VALID INPUT FOR MAPPING TECHNIQUE");
					  System.exit(1);					
		}
		
		System.out.println();
		System.out.println("***************************** ALL OPERATIONS PERFORMED SUCCESSFULLY *****************************");
		System.out.println();
		System.out.println("***************************** THANK YOU FOR USING THE CACHE IMPLEMENTATION *****************************");
		System.out.println();
		
		sc.close();
		
	}
	
	public static void direct() throws IOException
	{
		
				Scanner sc = new Scanner(System.in);
				
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				
				System.out.println("***************************** WELCOME TO THE DIRECT CACHE IMPLEMENTATION *****************************");
				System.out.println();
				System.out.println("***************************** ENTER INPUTS STARTS *****************************");
				System.out.println();
				System.out.println("Enter the size of main memory in Bytes ( in power of 2 )");
				int n = sc.nextInt();
				System.out.println("Enter the number of lines of Cache ( in power of 2 )");
				int cl = sc.nextInt();
				System.out.println("Enter the size of each line of Cache in Bytes ( in power of 2 )");
				int b = sc.nextInt();
				System.out.println();
				System.out.println("***************************** ENTER INPUTS ENDS *****************************");
				
				checkForErrors(cl, b, n);
				displayMemory(n, cl, b);
				
				String[][] cache = new String[cl][b/2];
				
				CacheMemory(cache, cl, b);
				
				int bitsOfPA = (int) (Math.log(n/2) /  Math.log(2) ) + 1;
			//	System.out.println(bitsOfPA);
				int bitsOfLines = (int) (Math.log(cl) /  Math.log(2) ) + 1;
			//	System.out.println(bitsOfLines);
				int bitsOfWords = (int) (Math.log(b/2) /  Math.log(2) );
			//	System.out.println(bitsOfWords);
				
				int NoOfBlocks = n/b;
				int BlocksInEachLine = NoOfBlocks / cl;
				int bitsOfBlocksInEachLine = (int) (Math.log(BlocksInEachLine/2) /  Math.log(2)) + 1;
				
				System.out.println("Enter the no. of operations you want to perform");
				int t = sc.nextInt();
				int checkTest = t;
				
				int cacheHit = 0;
				int cacheMiss = 0;
				
				while ( t > 0 ) 
				{		
					System.out.println("***************************** OPERATION STARTS *****************************");
					
					System.out.println();
					System.out.println("Please Enter the Physical Address of " + bitsOfPA + " bits");
					if ( t == checkTest )
						sc.nextLine();
					String paArray = sc.nextLine();

					
					int intOfPA = Integer.parseInt(paArray);
					int decimalNum = getDecimal(intOfPA);
					int BlockForThisPA = (decimalNum / (b/2))/2 ;
					int LineNoForThisBlock = BlockForThisPA % cl;
								
					int wordNum  = (decimalNum/2) % (b/2);
					
					System.out.println();
					System.out.println("The given Physical Address provides these bits :");
					System.out.println("Tag  = " + bitsOfBlocksInEachLine +  "   " + "Line Number  = " + bitsOfLines + "   " + "Block Offset = " + bitsOfWords);
					System.out.println("In the Cache Memory");
					
					showTagsBO(paArray, bitsOfBlocksInEachLine, bitsOfLines, bitsOfWords);
					
					System.out.println();
					System.out.println("The given physical address corresponds to the " + decimalNum/2 + " of the main memory");
					System.out.println("This block number "+ BlockForThisPA + " of the main memory is to be added in the line number " + LineNoForThisBlock + " of the cache memory");
					
					if ( cache[LineNoForThisBlock][wordNum] == null ) {
						System.out.println();
						System.out.println("***** CACHE MISS ***** because this block is not available in the Cache Memory");
						cacheMiss++;
						
						System.out.println();
						System.out.println("Do you want to write some information in this word ? (Yes/No)");
						String ans = br.readLine();
						
						if ( ans.equals("Yes") || ans.equals("yes")) {
							System.out.println();
							System.out.println("Input valid 2 Byte = 16 bit information for this particular word ");
							cache[LineNoForThisBlock][wordNum] = br.readLine();
							System.out.println();
							System.out.println("***** DATA SUCCESSFULLY WRITTEN *****");
						}
						else if ( ans.equals("No") || ans.equals("no")) {
							System.out.println();
							System.out.println("***** NO DATA HAS BEEN WRITTEN *****");
						}
						else {
							System.out.println();
							System.out.println("Invalid Input Entered: Writting Step Aborted");
						}
						
						System.out.println();
						System.out.println("The value stored in Cache Memory for the given Physcial Address is " + cache[LineNoForThisBlock][wordNum]);
						System.out.println();
				
					}
					
					else if ( cache[LineNoForThisBlock][wordNum] != null ) {
						System.out.println();
						System.out.println("***** CACHE HIT ***** this word is already available in the Cache Memory");
						cacheHit++;
						System.out.println(" ");
						System.out.println("This word contains a 16 bit information = " + cache[LineNoForThisBlock][wordNum] );
						
						System.out.println();
						System.out.println("Do you want to overwrite this existing information in the word ? (Yes/No)");
						
						String ans = br.readLine();
						if ( ans.equals("Yes")) {
							System.out.println();
							System.out.println("Input valid 2 Byte = 16 bit address for this particular word ");
							cache[LineNoForThisBlock][wordNum] = br.readLine();
							System.out.println();
							System.out.println("***** DATA SUCCESSFULLY OVERWRITTEN *****");
						}
						else if ( ans.equals("No")) {
							System.out.println();
							System.out.println("***** NO DATA HAS BEEN OVERWRITTEN *****");
						}
						else {
							System.out.println();
							System.out.println("Invalid Input Entered: Overwritting Step Aborted");
						}
						
						System.out.println();
						System.out.println("The value stored in Cache Memory for this PA is " + cache[LineNoForThisBlock][wordNum]);
					}
					
					CacheMemory(cache, cl, b);
					System.out.println("***************************** OPERATION ENDS *****************************");
					System.out.println();
					t--;
				}		
				
				System.out.println("**************** ALL OPERATIONS HAVE BEEN SUCCESSFULLY PERFORMED ****************");
				System.out.println();
				System.out.println("*********************** THE FINAL CACHE MEMORY ***********************");
				CacheMemory(cache, cl, b);

				cacheInfo(cacheHit, cacheMiss);
			
				System.out.println("************************** THANK YOU FOR USING TO THE DIRECT CACHE IMPLEMENTATION **************************");
				
				br.close();
				isr.close();
				sc.close();	
				
	}
			
			public static void cacheInfo( int cacheHit, int cacheMiss ) 
			{
				System.out.println();
				System.out.println("TOTAL NO. OF CACHE HIT = " + cacheHit);
				System.out.println("TOTAL NO. OF CACHE MISS = " + cacheMiss);
				double ratio =  ( (double)cacheHit / (cacheHit + cacheMiss)) ;
				System.out.println("CACHE HIT RATIO  = " + ratio );
				System.out.println();
			}
			
			public static void showTagsBO(String paArray, int bitsOfBlocksInEachLine, int bitsOfLines, int bitsOfWords) 
			{	
				int i = 0;
				
				System.out.println();
				System.out.print("TAG : ");
				for ( i = 0; i < bitsOfBlocksInEachLine; i++ ) {
					System.out.print(paArray.charAt(i));
				}
				
				System.out.println();
				System.out.print("LINE NUMBER : ");
				for ( i = bitsOfBlocksInEachLine; i < bitsOfBlocksInEachLine + bitsOfLines; i++ ) {
					System.out.print(paArray.charAt(i));
				}
				
				System.out.println();
				System.out.print("BLOCK OFFSET : ");
				for ( i = bitsOfBlocksInEachLine + bitsOfLines; i < bitsOfBlocksInEachLine + bitsOfLines + bitsOfWords; i++ ) {
					System.out.print(paArray.charAt(i));
				}		
				
				System.out.println();
			}

			public static int getDecimal(int binary)
			{  
			    int decimal = 0;  
			    int n = 0;  
			    while(true){  
			      if(binary == 0){  
			        break;  
			      } else {  
			          int temp = binary%10;  
			          decimal += temp*Math.pow(2, n);  
			          binary = binary/10;  
			          n++;  
			       }  
			    }  
			    return decimal;  
			}  

			public static void checkForErrors(int cl, int b, int n)
			{
				if ( cl * b >= n ) {
					System.out.println();
					System.out.println("ERROR: MAIN MEMORY SIZE MUST BE LARGER THAN CACHE SIZE");
					System.exit(1);
				}
				
				if ( n % 2 != 0 ) {
					System.out.println();
					System.out.println("ERROR: MAIN MEMORY MUST BE IN POWER OF 2");
					System.exit(1);
				}
				
				if ( cl % 2 != 0  ) {
					System.out.println();
					System.out.println("ERROR: NUMBER OF CACHE LINES MUST BE IN POWER OF 2");
					System.exit(1);
				}
				
				if ( b % 2 != 0 ) {
					System.out.println();
					System.out.println("ERROR: BLOCK SIZE MUST BE IN POWER OF 2");
					System.exit(1);
				}
				
				isPowerOfTwo(n);
				isPowerOfTwo(cl);
				isPowerOfTwo(b);
				
			}
			
			public static void isPowerOfTwo(int n) 
			{ 
			    if ( (int) (Math.ceil((Math.log(n) / Math.log(2)))) !=  (int) (Math.floor(((Math.log(n) / Math.log(2)))))) {
			    	System.out.println("ERROR: INPUT " + n + " MUST BE A POWER OF 2");
			    	System.exit(1);
			    }
			} 
			
			public static void displayMemory(int n, int cl, int b) 
			{
				System.out.println();
				System.out.println("***************************** DISPLAY INFORMATION STARTS *****************************");
				System.out.println();
			
				System.out.println("MAIN MEMORY");
				System.out.println("Size is " + n + " Bytes");
				System.out.println("No. of blocks are " + n/b);
				System.out.println("No. of total words is " + n/2);
				System.out.println("Size of each block is " + b + " Bytes");
				System.out.println("No. of words in each block are " + b/2);
				System.out.println("Size of each word is " + "2 Bytes");
				
				System.out.println();
				System.out.println("CACHE MEMORY");
				System.out.println("Size is " + cl * b + " Bytes");
				System.out.println("No. of blocks are " + cl + " Bytes");
				System.out.println("No. of total words is " + cl * b / 2);
				System.out.println("Size of each block is " + b + " Bytes");
				System.out.println("No. of words in each block are " + b/2);
				System.out.println("Size of each word is " + "2 Bytes");
			
				System.out.println();
				System.out.println("***************************** DISPLAY INFORMATION ENDS *****************************");
				
			}
			
			public static void CacheMemory(String[][] cache, int cl, int b) 
			{
				System.out.println();
				System.out.println("***************************** CACHE MEMORY START *****************************");
				System.out.println();
				
				for ( int i = 0; i < cl; i++) {
					for ( int j = 0; j < b/2; j++) {
						System.out.print(cache[i][j] + " ");
					}
					System.out.println("");
				}
				System.out.println();
				System.out.println("***************************** CACHE MEMORY ENDS *****************************");		
				System.out.println();
			}
	
	public static void fully() throws IOException
	{
				Scanner sc = new Scanner(System.in);
				
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				
				System.out.println("***************************** WELCOME TO THE FULLY ASSOCIATIVE CACHE IMPLEMENTATION *****************************");
				System.out.println();
				System.out.println("***************************** ENTER INPUTS STARTS *****************************");
				System.out.println();
				System.out.println("Enter the size of main memory in Bytes ( in power of 2 )");
				int n = sc.nextInt();
				System.out.println("Enter the number of lines of Cache ( in power of 2 )");
				int cl = sc.nextInt();
				System.out.println("Enter the size of each line of Cache in Bytes ( in power of 2 )");
				int b = sc.nextInt();
				System.out.println();
				System.out.println("***************************** ENTER INPUTS ENDS *****************************");
				
				
				checkForErrorsF(cl, b, n);
				displayMemoryF(n, cl, b);
				
				String[][] cache = new String[cl][b/2];
				
				CacheMemoryF(cache, cl, b);
				
				int bitsOfPA = (int) (Math.log(n/2) /  Math.log(2) ) ;
			//	System.out.println("bits needed for the address = " + bitsOfPA);
				int bitsOfLines = (int) (Math.log(cl) /  Math.log(2) ) ;
			//	System.out.println("bits needed for the lines in cache = " + bitsOfLines);
				int bitsOfWords = (int) (Math.log(b/2) /  Math.log(2) );
			//	System.out.println("bits needed for the words in one block = " + bitsOfWords);
				
				int NoOfBlocks = n/b;
				int BlocksInEachLine = NoOfBlocks / cl;
				int bitsOfBlocksInEachLine = (int) (Math.log(BlocksInEachLine/2) /  Math.log(2)) + 1;
				
				System.out.println("Enter the no. of operations you want to perform");
				int t = sc.nextInt();
				int checkTest = t;
				
				int cacheHit = 0;
				int cacheMiss = 0;
				int indexAdd = 0;
				
				String[] tagArr = new String[cl];
				
				while ( t > 0 ) 
				{		
					indexAdd = indexAdd % cl;
					
					System.out.println("***************************** OPERATION STARTS *****************************");
					
					System.out.println();
					System.out.println("Please Enter the Physical Address of " + bitsOfPA + " bits");
					if ( t == checkTest ) {
						sc.nextLine();
					}
					String paArray = sc.nextLine();
					int intOfPA = Integer.parseInt(paArray);
					
					
				//	System.out.println(bitsOfPA);
				//	System.out.println(paArray.length());
				//	System.out.println((int) (Math.log(intOfPA) /  Math.log(2) ));
					
					if ( bitsOfPA != paArray.length()) {
						System.out.println("ERROR: BITS OF PHYSICAL ADDRESS NOT VALID");
						System.exit(-1);
					}
					int decimalNum = getDecimalF(intOfPA);
					int BlockForThisPA = (decimalNum / (b/2)) ;
					int totalTagDigits = bitsOfBlocksInEachLine + bitsOfLines;
					
					System.out.println();
					System.out.println("The given Physical Address provides these bits :");
					System.out.println("Tag = " + totalTagDigits  + "   " + "Block Offset = " + bitsOfWords);
					System.out.println("In the Cache Memory");
					
					showTagsBOF(paArray, bitsOfBlocksInEachLine, bitsOfLines, bitsOfWords);
					
					System.out.println();
					System.out.println("The given physical address corresponds to the " + decimalNum + " of the main memory");
					System.out.println("This block number "+ BlockForThisPA + " of the main memory is to be added in the line number " + indexAdd + " of the cache memory");
					
					int flag = 0;
							
					for ( int i = 0; i < tagArr.length; i++) {
						if ( paArray.equals(tagArr[i])) {
							//HIT
							System.out.println();
							System.out.println("***** CACHE HIT *****");
							System.out.println(" This word is already available in the Cache Memory");
							cacheHit++;
							System.out.println(" ");
							System.out.println("This word contains a 16 bit information = " + cache[indexAdd][bitsOfWords] );
							
							System.out.println();
							System.out.println("Do you want to overwrite this existing information in the word ? (Y/N)");
							
							String ans = br.readLine();
							if ( ans.equals("Y") || ans.equals("y")) {
								System.out.println();
								System.out.println("Input valid 2 Byte = 16 bit address for this particular word ");
								cache[indexAdd][bitsOfWords] = br.readLine();
								System.out.println();
								System.out.println("***** DATA SUCCESSFULLY OVERWRITTEN *****");
							}
							else if ( ans.equals("N") || ans.equals("n")) {
								System.out.println();
								System.out.println("***** NO DATA HAS BEEN OVERWRITTEN *****");
							}
							else {
								System.out.println();
								System.out.println("ERROR : INVALID RESPONSE : OVERWRITING STEP ABORTED");
								cache[indexAdd][bitsOfWords] = "Word" + decimalNum;
							}
							
							System.out.println();
							System.out.println("The value stored in Cache Memory for this PA is " + cache[indexAdd][bitsOfWords]);
							
							flag = 1;
							break;
						}
					}
						
					if ( flag == 0 ) 
					{
						//MISS
						System.out.println();
						System.out.println("***** CACHE MISS *****");
						System.out.println(" This block is not available in the Cache Memory");
						cacheMiss++;
							
						System.out.println();
						System.out.println("Do you want to write some information in this word ? (Y/N)");
						String ans = br.readLine();
							
						if ( ans.equals("Y") || ans.equals("y")) {
							System.out.println();
							System.out.println("Input valid 2 Byte = 16 bit information for this particular word ");
							cache[indexAdd][bitsOfWords] = br.readLine();
							System.out.println();
							System.out.println("***** DATA SUCCESSFULLY WRITTEN *****");
							}
						
						else if ( ans.equals("N") || ans.equals("n")) {
							System.out.println();
							System.out.println("***** NO DATA HAS BEEN WRITTEN *****");
						}
						
						else {
							System.out.println();
							System.out.println("ERROR : INVALID RESPONSE : OVERWRITING STEP ABORTED");
							cache[indexAdd][bitsOfWords] = "Word" + decimalNum;
						}
							
						System.out.println();
						System.out.println("The value stored in Cache Memory for the given Physcial Address is " + cache[indexAdd][bitsOfWords]);
						System.out.println();
							
						
					}
				
					CacheMemoryF(cache, cl, b);
					System.out.println("***************************** OPERATION ENDS *****************************");
					System.out.println();
						
					tagArr[indexAdd] = paArray;
				
					if ( flag == 0)
						indexAdd++;
			
					t--;
				}		
				
				System.out.println("**************** ALL OPERATIONS HAVE BEEN SUCCESSFULLY PERFORMED ****************");
				System.out.println();
				System.out.println("*********************** THE FINAL CACHE MEMORY ***********************");
				CacheMemoryF(cache, cl, b);

				cacheInfoF(cacheHit, cacheMiss);
			
				System.out.println("************************** THANK YOU FOR USING TO THE FULLY ASSOCIATIVE CACHE IMPLEMENTATION **************************");
				
				br.close();
				isr.close();
				sc.close();		 
			}
			
			public static void cacheInfoF( int cacheHit, int cacheMiss ) 
			{
				System.out.println();
				System.out.println("TOTAL NO. OF CACHE HIT = " + cacheHit);
				System.out.println("TOTAL NO. OF CACHE MISS = " + cacheMiss);
				double ratio =  ( (double)cacheHit / (cacheHit + cacheMiss)) ;
				System.out.println("CACHE HIT RATIO  = " + ratio );
				System.out.println();
			}
			
			public static void showTagsBOF(String paArray, int bitsOfBlocksInEachLine, int bitsOfLines, int bitsOfWords) 
			{	
				int i = 0;
				
				System.out.println();
				System.out.print("TAG : ");
				for ( i = 0; i < bitsOfBlocksInEachLine + bitsOfLines; i++ ) {
					System.out.print(paArray.charAt(i));
				}
				
				System.out.println();
				System.out.print("BLOCK OFFSET : ");
				for ( i = bitsOfBlocksInEachLine + bitsOfLines; i < bitsOfBlocksInEachLine + bitsOfLines + bitsOfWords; i++ ) {
					System.out.print(paArray.charAt(i));
				}		
				
				System.out.println();
			}

			public static int getDecimalF(int binary)
			{  
			    int decimal = 0;  
			    int n = 0; 
			    
			    while( true ) 
			    {  
			      if(binary == 0) {
			    	  break;  
			      } 
			      else {
			    	  int temp = binary % 10;  
			          decimal += temp * Math.pow(2, n);  
			          binary = binary / 10;  
			          n++;  
			      }  
			    }  
			    return decimal;  
			}  

			public static void checkForErrorsF(int cl, int b, int n)
			{
				if ( cl * b >= n ) {
					System.out.println();
					System.out.println("ERROR: MAIN MEMORY SIZE MUST BE LARGER THAN CACHE SIZE");
					System.exit(1);
				}
				
				if ( n % 2 != 0 ) {
					System.out.println();
					System.out.println("ERROR: MAIN MEMORY MUST BE IN POWER OF 2");
					System.exit(1);
				}
				
				if ( cl % 2 != 0  ) {
					System.out.println();
					System.out.println("ERROR: NUMBER OF CACHE LINES MUST BE IN POWER OF 2");
					System.exit(1);
				}
				
				if ( b % 2 != 0 ) {
					System.out.println();
					System.out.println("ERROR: BLOCK SIZE MUST BE IN POWER OF 2");
					System.exit(1);
				}
				
				isPowerOfTwoF(n);
				isPowerOfTwoF(cl);
				isPowerOfTwoF(b);
				
			}
			
			public static void isPowerOfTwoF(int n) 
			{ 
			    if ( (int) (Math.ceil((Math.log(n) / Math.log(2)))) !=  (int) (Math.floor(((Math.log(n) / Math.log(2)))))) {
			    	System.out.println("ERROR: INPUT " + n + " MUST BE A POWER OF 2");
			    	System.exit(1);
			    }
			} 
			
			public static void displayMemoryF(int n, int cl, int b) 
			{
				System.out.println();
				System.out.println("***************************** DISPLAY INFORMATION STARTS *****************************");
				System.out.println();
			
				System.out.println("MAIN MEMORY");
				System.out.println("Size is " + n + " Bytes");
				System.out.println("No. of blocks are " + n/b);
				System.out.println("No. of total words is " + n/2);
				System.out.println("Size of each block is " + b + " Bytes");
				System.out.println("No. of words in each block are " + b/2);
				System.out.println("Size of each word is " + "2 Bytes");
				
				System.out.println();
				System.out.println("CACHE MEMORY");
				System.out.println("Size is " + cl * b + " Bytes");
				System.out.println("No. of blocks are " + cl + " Bytes");
				System.out.println("No. of total words is " + cl * b / 2);
				System.out.println("Size of each block is " + b + " Bytes");
				System.out.println("No. of words in each block are " + b/2);
				System.out.println("Size of each word is " + "2 Bytes");
			
				System.out.println();
				System.out.println("***************************** DISPLAY INFORMATION ENDS *****************************");
				
			}
			
			public static void CacheMemoryF(String[][] cache, int cl, int b) 
			{
				System.out.println();
				System.out.println("***************************** CACHE MEMORY START *****************************");
				System.out.println();
				
				for ( int i = 0; i < cl; i++) {
					for ( int j = 0; j < b/2; j++) {
						System.out.print(cache[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
				System.out.println("***************************** CACHE MEMORY ENDS *****************************");		
				System.out.println();
			}
	
public static void kway() throws IOException
	{
				Scanner sc = new Scanner(System.in);
				
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				
				System.out.println("***************************** WELCOME TO THE K- WAY ASSOCIATIVE CACHE IMPLEMENTATION *****************************");
				System.out.println();
				System.out.println("***************************** ENTER INPUTS STARTS *****************************");
				System.out.println();
				System.out.println("Enter the size of main memory in Bytes ( in power of 2 )");
				int n = sc.nextInt();
				System.out.println("Enter the number of lines of Cache ( in power of 2 )");
				int cl = sc.nextInt();
				System.out.println("Enter the size of each line of Cache in Bytes ( in power of 2 )");
				int b = sc.nextInt();
				System.out.println("Enter the value of K in K- Way Mapping ( in power of 2 )");
				int k = sc.nextInt();
				System.out.println();
				System.out.println("***************************** ENTER INPUTS ENDS *****************************");
				
				
				checkForErrorsK(cl, b, n, k);
				displayMemoryK(n, cl, b, k);
				
				String[][] cache = new String[cl][b/2];
				
				CacheMemoryK(cache, cl, b);
				
				int bitsOfPA = (int) (Math.log(n/2) /  Math.log(2) ) ;
			//	System.out.println("bits needed for the address = " + bitsOfPA);
				int bitsOfWords = (int) (Math.log(b/2) /  Math.log(2) );
			//	System.out.println("bits needed for the words in one block = " + bitsOfWords);
				
				int NoOfBlocks = n/b;
				int NoOfSet = cl/k;
				int bitsOfSet = (int) (Math.log(NoOfSet) /  Math.log(2) ) ;
				int BlocksInEachLine = NoOfBlocks / NoOfSet;
			//	System.out.println(" Blocks In Each Line = " + BlocksInEachLine);
				int bitsOfBlocksInEachLine = (int) (Math.log(BlocksInEachLine) /  Math.log(2)) ;
			//	System.out.println(" bits Of Blocks In Each Line = " + bitsOfBlocksInEachLine);
			//	System.out.println();
				
				System.out.println("Enter the no. of operations you want to perform");
				int t = sc.nextInt();
				int checkTest = t;
				
				int cacheHit = 0;
				int cacheMiss = 0;
				int indexAdd = 0;
				
				int[] valuePresent = new int[cl];			
				int[] noInsideSet  = new int[NoOfSet];
				
				
				String[] tagArr = new String[cl];
				
				while ( t > 0 ) 
				{		
					int count = 0;
					indexAdd = indexAdd % NoOfSet;
					
					System.out.println("***************************** OPERATION STARTS *****************************");
					
					System.out.println();
					System.out.println("Please Enter the Physical Address of " + bitsOfPA + " bits");
					if ( t == checkTest ) {
						sc.nextLine();
					}
					String paArray = sc.nextLine();
					int intOfPA = Integer.parseInt(paArray);
					
				//	System.out.println(bitsOfPA);
				//	System.out.println((int) (Math.log(intOfPA) /  Math.log(2) ));
					
					if ( bitsOfPA != paArray.length()) {
						System.out.println("ERROR: BITS OF PHYSICAL ADDRESS NOT VALID");
						System.exit(-1);
					}
					int decimalNum = getDecimalK(intOfPA);
					int BlockForThisPA = (decimalNum / (b/2)) ;
					int whichSet = BlockForThisPA % NoOfSet;
					int noOfLinesInEachSet = cl / NoOfSet;
					
					System.out.println();
					System.out.println("The given Physical Address provides these bits :");
					System.out.println("Tag = " + bitsOfBlocksInEachLine  + "   " + "Set No. = " + bitsOfSet + "   " +  "Block Offset = " + bitsOfWords);
					System.out.println("In the Cache Memory");
					
					showTagsBOK(paArray, bitsOfBlocksInEachLine, bitsOfSet, bitsOfWords);
					
					System.out.println();
					System.out.println("The given physical address corresponds to the " + decimalNum + " of the main memory");
					System.out.println("This block number "+ BlockForThisPA + " of the main memory is to be added in the set number " + whichSet + " of the cache memory");
					
					
					int flag = 0;
							
					for ( int i = 0; i < tagArr.length; i++) {
						if ( paArray.equals(tagArr[i])) {
							//HIT
							System.out.println();
							System.out.println("***** CACHE HIT *****");
							System.out.println(" This word is already available in the Cache Memory");
							cacheHit++;
							System.out.println(" ");
							System.out.println("This word contains a 16 bit information = " + cache[whichSet * noOfLinesInEachSet][bitsOfWords] );
							
							System.out.println();
							System.out.println("Do you want to overwrite this existing information in the word ? (Y/N)");
							
							String ans = br.readLine();
							if ( ans.equals("Y") || ans.equals("y")) {
								System.out.println();
								System.out.println("Input valid 2 Byte = 16 bit address for this particular word ");
								cache[whichSet * noOfLinesInEachSet + noInsideSet[whichSet]][bitsOfWords] = br.readLine();
								System.out.println();
								System.out.println("***** DATA SUCCESSFULLY OVERWRITTEN *****");
							}
							else if ( ans.equals("N") || ans.equals("n")) {
								System.out.println();
								System.out.println("***** NO DATA HAS BEEN OVERWRITTEN *****");
							}
							else {
								System.out.println();
								System.out.println("ERROR : INVALID RESPONSE : OVERWRITING STEP ABORTED");
								cache[whichSet * noOfLinesInEachSet + noInsideSet[whichSet]][bitsOfWords] = "Word" + decimalNum;
							}
							
							System.out.println();
							System.out.println("The value stored in Cache Memory for this PA is " + cache[whichSet * noOfLinesInEachSet ][bitsOfWords]);
							
							flag = 1;
							break;
						}
					}
						
					if ( flag == 0 ) 
					{
						//MISS
						System.out.println();
						System.out.println("***** CACHE MISS *****");
						System.out.println(" This block is not available in the Cache Memory");
						cacheMiss++;
							
						System.out.println();
						System.out.println("Do you want to write some information in this word ? (Y/N)");
						String ans = br.readLine();
							
						if ( ans.equals("Y") || ans.equals("y")) {
							System.out.println();
							System.out.println("Input valid 2 Byte = 16 bit information for this particular word ");
							System.out.println();
							
							if ( noInsideSet[whichSet] > 0) {
								System.out.println();
								System.out.println("A Block is already present in this set");
								System.out.println("Hence, adding block to the next empty line in set");
								
								if ( noInsideSet[whichSet] < noOfLinesInEachSet) {
									cache[whichSet * noOfLinesInEachSet + noInsideSet[whichSet]][bitsOfWords] = br.readLine();
									System.out.println();
									System.out.println("***** DATA SUCCESSFULLY WRITTEN *****");
									noInsideSet[whichSet] = noInsideSet[whichSet] + ++count;
								}
								else {
									System.out.println("THE SET IS FULL");
									System.out.println("TIME FOR REPLACEMENT");
									cache[whichSet * noOfLinesInEachSet ][bitsOfWords] = br.readLine();
									System.out.println();
									System.out.println("***** DATA SUCCESSFULLY WRITTEN *****");
								}
							}
							
							else {
								cache[whichSet * noOfLinesInEachSet][bitsOfWords] = br.readLine();	
								valuePresent[whichSet * noOfLinesInEachSet] = 1;
								System.out.println();
								System.out.println("ELSE STATEMENT");
								System.out.println("***** DATA SUCCESSFULLY WRITTEN *****");
								noInsideSet[whichSet] = noInsideSet[whichSet] + ++count;
							}
						}
						
						else if ( ans.equals("N") || ans.equals("n")) {
							System.out.println();
							System.out.println("***** NO DATA HAS BEEN WRITTEN *****");
						}
						
						else {
							System.out.println();
							System.out.println("ERROR : INVALID RESPONSE : OVERWRITING STEP ABORTED");
							cache[whichSet * noOfLinesInEachSet][bitsOfWords] = "Word" + decimalNum;
							valuePresent[whichSet * noOfLinesInEachSet] = 1;
							noInsideSet[whichSet] = noInsideSet[whichSet] + ++count;
						}
							
						System.out.println();
						System.out.println("The value stored in Cache Memory for the given Physcial Address is " + cache[whichSet * noOfLinesInEachSet ][bitsOfWords]);
						System.out.println();
							
						
					}
				
					CacheMemoryK(cache, cl, b);
					System.out.println("***************************** OPERATION ENDS *****************************");
					System.out.println();
					
					tagArr[indexAdd] = paArray;
				
					if ( flag == 0)
						indexAdd++;
			
			//		for ( int i =0; i< NoOfSet; i++ ) {
			//			System.out.print(noInsideSet[i] + "  ");
			//		}
					t--;
				}		
				
				System.out.println("**************** ALL OPERATIONS HAVE BEEN SUCCESSFULLY PERFORMED ****************");
				System.out.println();
				System.out.println("*********************** THE FINAL CACHE MEMORY ***********************");
				CacheMemoryK(cache, cl, b);

				cacheInfoK(cacheHit, cacheMiss);
			
				System.out.println("************************** THANK YOU FOR USING TO THE K WAY SET CACHE IMPLEMENTATION **************************");
				
				br.close();
				isr.close();
				sc.close();		 
			}
			
			public static void cacheInfoK( int cacheHit, int cacheMiss ) 
			{
				System.out.println();
				System.out.println("TOTAL NO. OF CACHE HIT = " + cacheHit);
				System.out.println("TOTAL NO. OF CACHE MISS = " + cacheMiss);
				double ratio =  ( (double)cacheHit / (cacheHit + cacheMiss)) ;
				System.out.println("CACHE HIT RATIO  = " + ratio );
				System.out.println();
			}
			
			public static void showTagsBOK(String paArray, int bitsOfBlocksInEachLine, int bitsOfSet, int bitsOfWords) 
			{	
				int i = 0;
				
				System.out.println();
				System.out.print("TAG : ");
				for ( i = 0; i < bitsOfBlocksInEachLine; i++ ) {
					System.out.print(paArray.charAt(i));
				}
				
				System.out.println();
				System.out.print("SET NO. : ");
				for ( i = bitsOfBlocksInEachLine; i < bitsOfBlocksInEachLine + bitsOfSet; i++ ) {
					System.out.print(paArray.charAt(i));
				}
				
				System.out.println();
				System.out.print("BLOCK OFFSET : ");
				for ( i = bitsOfBlocksInEachLine + bitsOfSet; i < bitsOfBlocksInEachLine + bitsOfSet + bitsOfWords; i++ ) {
					System.out.print(paArray.charAt(i));
				}		
				
				System.out.println();
			}

			public static int getDecimalK(int binary)
			{  
			    int decimal = 0;  
			    int n = 0; 
			    
			    while( true ) 
			    {  
			      if(binary == 0) {
			    	  break;  
			      } 
			      else {
			    	  int temp = binary % 10;  
			          decimal += temp * Math.pow(2, n);  
			          binary = binary / 10;  
			          n++;  
			      }  
			    }  
			    return decimal;  
			}  

			public static void checkForErrorsK(int cl, int b, int n, int k)
			{
				if ( cl * b >= n ) {
					System.out.println();
					System.out.println("ERROR: MAIN MEMORY SIZE MUST BE LARGER THAN CACHE SIZE");
					System.exit(1);
				}
				
				if ( n % 2 != 0 ) {
					System.out.println();
					System.out.println("ERROR: SIZE MAIN MEMORY CAN NOT BE A ODD NUMBER");
					System.exit(1);
				}
				
				if ( cl % 2 != 0  ) {
					System.out.println();
					System.out.println("ERROR: NUMBER OF CACHE LINES CAN NOT BE A ODD NUMBER ");
					System.exit(1);
				}
				
				if ( b % 2 != 0 ) {
					System.out.println();
					System.out.println("ERROR: SIZE OF INDIVIDUAL BLOCK CAN NOT BE A ODD NUMBER");
					System.exit(1);
				}
				
				if ( k % 2 != 0 ) {
					System.out.println();
					System.out.println("ERROR: VALUE OF 'K' CAN NOT BE A ODD NUMBER");
					System.exit(1);
				}
				
				isPowerOfTwoK(n);
				isPowerOfTwoK(cl);
				isPowerOfTwoK(b);
				isPowerOfTwoK(k);
				
			}
			
			public static void isPowerOfTwoK(int n) 
			{ 
			    if ( (int) (Math.ceil((Math.log(n) / Math.log(2)))) !=  (int) (Math.floor(((Math.log(n) / Math.log(2)))))) {
			    	System.out.println("ERROR: INPUT " + n + " MUST BE A POWER OF 2");
			    	System.exit(1);
			    }
			} 
			
			public static void displayMemoryK(int n, int cl, int b, int k) 
			{
				System.out.println();
				System.out.println("***************************** DISPLAY INFORMATION STARTS *****************************");
				System.out.println();
			
				System.out.println("MAIN MEMORY");
				System.out.println("Size is " + n + " Bytes");
				System.out.println("No. of blocks are " + n/b);
				System.out.println("No. of total words is " + n/2);
				System.out.println("Size of each block is " + b + " Bytes");
				System.out.println("No. of words in each block are " + b/2);
				System.out.println("Size of each word is " + "2 Bytes");
				
				System.out.println();
				System.out.println("CACHE MEMORY");
				System.out.println("Size is " + cl * b + " Bytes");
				System.out.println("No. of lines are " + cl + " Bytes");
				System.out.println("No. of total words is " + cl * b / 2);
				System.out.println("Size of each line is " + b + " Bytes");
				System.out.println("No. of words in each line are " + b/2);
				System.out.println("Size of each word is " + "2 Bytes");
				
				System.out.println("No. of sets = " + cl/k);
			
				System.out.println();
				System.out.println("***************************** DISPLAY INFORMATION ENDS *****************************");
				
			}
			
			public static void CacheMemoryK(String[][] cache, int cl, int b) 
			{
				System.out.println();
				System.out.println("***************************** CACHE MEMORY START *****************************");
				System.out.println();
				
				for ( int i = 0; i < cl; i++) {
					for ( int j = 0; j < b/2; j++) {
						System.out.print(cache[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
				System.out.println("***************************** CACHE MEMORY ENDS *****************************");		
				System.out.println();
			}
}		