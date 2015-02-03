import java.io.*;
import java.util.*;

/**
 * @author Matthew Forsyth, Rachel Kmetz, John Kirschner 
 */
public class Filecpmax {

	
	
	
	public static void main(String[] args) {
		IOFile f = new IOFile();
		
		//ensure the user enters input and output file names
		switch(args.length)
		{
			case 0: //must prompt for both file names
			case 1: //must prompt for output file
			case 2: //no action
			default: //do nothing
			
		}
		
		
		//validate the names
	
		//Set up the IOFile object
		
		
		//read a line from the IOFile
		//split the line
		
		//foreach token
			//if number then sum
			//else if word then 
				//if word already in list then increment count
				//else add word to list
		
		//format output?
		
		//write output to output file
		
		
	}
	
	public String PromptForOutputFile(){
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
		String UserInput = null;
		
		while(UserInput == null){
			System.out.println("Please enter an output file name, or press enter to quit:");
			try {
				UserInput = kbd.readLine();
				
			} catch (IOException e) {
				e.printStackTrace();
				UserInput = null;
			}
		}
		
		if(UserInput != null){
			if(UserInput == "")//they want to quit
			{
				asldkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdkdk
			}
		}
		
		return UserInput;
	}

	
	
	
}//end class
