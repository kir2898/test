import java.io.*;
import java.util.*;

/**
 * IOFile allows support for file io
 * @author Matthew Forsyth, Rachel Kmetz, John Kirschner
 */
public class IOFile {

	private String inputFilePathAndName = null;
	private String outputFilePathAndName=null;
	
	private File fileIn = null, fileOut = null;
	
	private BufferedReader bufReadIn = null;
	private BufferedWriter bufWritOut = null;
	
	private FileReader frIn = null;
	private FileWriter fwOut = null;
	
	/*public static boolean FileExists(String pName){
		
		if(pName != null){
			File f = new File(pName);
			
		}
	}*/
	
	public boolean InputFileExists(){
		if(fileIn !=null)
			return fileIn.exists();
		else 
			return false;
	}
	
	public boolean OutputFileExists(){
		if(fileOut !=null)
			return fileOut.exists();
		else 
			return false;
	}
	
	public String InputFileNameFromPath(){
		if(fileIn!=null)
			return fileIn.getName();
		else
			return null;
	}
	
	public String OutputFileNameFromPath(){
		if(fileOut!=null)
			return fileOut.getName();
		else
			return null;
	}
	
	public String GetInputFileExtension(){
		String s = InputFileNameFromPath();
		if (s!= null){
			return s.substring(s.lastIndexOf('.'), s.length());
		}
		else 
			return null;
	}
	
	public String GetOutputFileExtension(){
		String s = OutputFileNameFromPath();
		if (s!=null){
			
		return s.substring(s.lastIndexOf('.'), s.length());
		}
		else 
			return null;
	}
		
		
	
	/**
	 * 
	 * @return A string. Returns null if the object is not initialized or if there is an IOException
	 */
	public String ReadLine(){
		if(bufReadIn != null){
			
			try{
				return bufReadIn.readLine();	
			}
			catch(IOException ioe){
				System.out.println("IOException error in IOFile.ReadLine");
				return null;
			}
			
		}
		else
			return null;
	}


	public boolean CloseInputFile(){
		boolean ret = true; 
		try{
			
			if (frIn != null){
				
				frIn.close(); 
				frIn = null;
				fileIn = null;
				bufReadIn = null;
			}
			else 
				ret = false; 
		}
		catch(IOException ioe){
			System.out.println("IOException error in IOFile.CloseInputFile");
			ret = false;
		}
		 
		return ret;
	}

	
/**
 * 	if the output file already defined return false. 
 * @param pNewName: Name if the Backed Up copy. 
 * @return
 */
	public boolean BackupOutputFile(String pNewName, File pOriginalFile){ 
		boolean ret = true; 
		
		String originalName=null;
		
		if (pOriginalFile !=null && pNewName != null && fileOut == null){
			
			originalName = pOriginalFile.getName();
		
			if (pOriginalFile.renameTo(new File(pNewName))){ //rename the original file to pNewName
			
				try{
					fileOut = new File(originalName); 
				}		//create a new file with the original name
				catch(NullPointerException npe){
					System.out.println ("IOException error in IOFile.BackupOutputFile");
					ret=false;
				}
			}
		}
			
		else {
			ret=false; 
		}
		return ret;
	} 

public boolean DeleteFile(File pFile){
	
	try{
		if(pFile != null){
			pFile.delete();
			return true;
		}
		else
			return false;
	}

	catch(SecurityException se){
		System.out.println ("IOException error in IOFile.DeleteFile");
		return false;	
	}	
			
}





	public boolean SetNames(String[] pNames){
		boolean ret = true;
		
		if (pNames != null && pNames.length >= 2){
			inputFilePathAndName = pNames[0];
			outputFilePathAndName = pNames[1];
			
			//Set up the input file, filereader, and buffered reader
			if(inputFilePathAndName != null){
				fileIn = new File(inputFilePathAndName);
				
				try {
					frIn = new FileReader(fileIn);
					bufReadIn = new BufferedReader(frIn);
					
				} catch (FileNotFoundException fnfe) {
					System.out.println("FileNotFoundException in IOFile.SetNames");
					ret = false;
				}
				
			}
			else 
				ret = false;
			
			//Set up the output file, filewriter
				if(outputFilePathAndName != null){
					fileOut = new File(outputFilePathAndName);
					
					try {
						fwOut = new FileWriter(fileOut);
					} 
					catch (IOException ioe) {
						System.out.println("Exception in IOFile.SetNames");
						ret = false;
					}
				}
				else 
					ret = false;
				
		}
		return ret;
	}



//rename file

}