package pediasync;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filer
{
	// Method that creates a file with the patient's basic information.
	public void createFile(String first_name, String last_name, String date_of_birth, String username, String password) 
	{
		try 
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter("[filepath here]\\" + username + "_PatientInfo.txt"));
			
			writer.write(password + "\n" + first_name + "\n" + last_name + "\n" + date_of_birth);
			
			writer.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	/*public ArrayList<String> readFile(String id, int flag) 
	{
		try 
		{
			ArrayList<String> list = null;
			
			if(flag == 0) 
			{
				BufferedReader reader_one = new BufferedReader(new FileReader("[filepath here]\\" + id + "_PatientInfo.txt"));
				
				String line;
				
				int count = 0;
				
				list = new ArrayList<String>();
				
				while((line = reader_one.readLine()) != null && count <= 2) 
				{
					list.add(line);
					
					count++;
				}
				reader_one.close();
			}
			else if(flag == 1) 
			{
				BufferedReader reader_two = new BufferedReader(new FileReader("[filepath here]\\" + id + "CTResults.txt"));
				
				String line;
				
				list = new ArrayList<String>();
				
				while((line = reader_two.readLine()) != null) 
				{
					list.add(line);
				}
				reader_two.close();
			}
			return list;
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			
			return null;
		}
	}*/
}
