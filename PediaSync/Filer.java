package PediaSync;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filer
{
	public void createFile(String id, String password, String first_name, String last_name, String date_of_birth, String username) 
	{
		try 
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_UserInfo.txt"));
			
			writer.write(id + "\n" + password + "\n" + first_name + "\n" + last_name + "\n" + date_of_birth);
			
			writer.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	public String authenticate(String username, int flag) 
	{
		try 
		{
			String result = null;
			
			BufferedReader reader = new BufferedReader(new FileReader(username + "_UserInfo.txt"));
			
			if(flag == 0) 
			{
				result = reader.readLine();
			}
			if(flag == 1) 
			{	
				reader.readLine();
				
				result = reader.readLine();
			}
			reader.close();
			
			return result;
		}
		catch(IOException e) 
		{
			
			return "";
		}
	}
	public void writeFile(String username, ArrayList<String> list) 
	{
		try 
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_UserInfo.txt"));
			
			for(int i = 0; i < list.size(); i++) 
			{
				writer.write(list.get(i) + "\n");
			}
			//writer.write("\n" + contact + "\n" + emergency_contact + "\n" + vitals + "\n" + health_concerns + "\n" + immunization + "\n" + history);
			
			writer.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	/*public void doctorWriteFile(String username, String prescription) 
	{
		try 
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_UserInfo.txt", true));
			
			writer.write("\n" + prescription);
			
			writer.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}*/
	public int checkUsername(String username) 
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(username + "_UserInfo.txt"));

			reader.close();

			return 1;
		}
		catch(IOException e) 
		{
			return 0;
		}
	}
	public ArrayList<String> readFile(String username, int flag) 
	{   
		try
		{
			ArrayList<String> list = null;
			
			BufferedReader reader = new BufferedReader(new FileReader(username + "_UserInfo.txt"));
			
			String line;
			
			list = new ArrayList<String>();
			
			int bound = 5;
			
			if(flag == 1) 
			{
				int i = 0;
				
				while(i < 5) 
				{
					reader.readLine();
					
					i++;
				}
				bound = 7; 
			}
			if(flag == 2) 
			{
				bound = 11;
			}
			int j = 0;
			
			while((line = reader.readLine()) != null && j < bound)
			{
				list.add(line);
				
				j++;
            }
            reader.close();
            
            return list;
        }
		catch(IOException e) 
		{
			e.printStackTrace();
			
			return null;
        }
    }

	// This method reads in data in the messaging portal format to be displayed to the user
	public ArrayList<String> readMessagingFile(String username) {
		ArrayList<String> patientMessageHistory = new ArrayList<>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(username + "_PatientMessageHistory.txt"));


			String line;
			while((line = reader.readLine()) != null) {
				patientMessageHistory.add(line);
			}
			reader.close();

		} catch(IOException e) {

			System.out.println("File not found");

		}

		return patientMessageHistory;
	}


	// This method saves messaging data to the system to be read later.
	public void writeMessagingFile(String username, String message) {
		String fileName = username + "_PatientMessageHistory.txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(message);
			writer.newLine();
			writer.close();


		} catch (IOException e) {
			System.out.println("Failed to write file");
		}
	}

}
