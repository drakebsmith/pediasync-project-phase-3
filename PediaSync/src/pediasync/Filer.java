package pediasync;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filer
{
	// *REPLACE [filepath here] WITH A FILEPATH OF YOUR CHOICE FOR TESTING. Example: "C:\\Users\\[the name you chose for your OS]\\Desktop\\" (assuming you're on a Windows machine).
	public void createFile(String id, String password, String first_name, String last_name, String date_of_birth, String username) 
	{
		try 
		{	
			//BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\leotr\\OneDrive\\" + username + "_PatientInfo.txt"));
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_UserInfo.txt"));
			
			writer.write(id + "\n" + password + "\n" + first_name + "\n" + last_name + "\n" + date_of_birth);
			
			writer.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	// Still not in-use. Left commented in case we need it
	/*public ArrayList<String> readFile(String username) 
	{
		try 
		{
			ArrayList<String> list = null;
			
			BufferedReader reader = new BufferedReader(new FileReader("[filepath here]\\" + username + "_PatientInfo.txt"));
				
			String line;
				
			int count = 0;
				
			list = new ArrayList<String>();
		
			while((line = reader.readLine()) != null && count <= 2) 
			{
				list.add(line);
				
				count++;
			}
			reader.close();
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
			//e.printStackTrace();
			
			return "";
		}
	}
	public void writeFile(String username, String contact, String emergency_contact, String health_concerns, String immunization, String history, String prescription, String vitals) 
	{
		try 
		{
			//BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\leotr\\OneDrive\\" + username + "_PatientInfo.txt", true));
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_UserInfo.txt", true));
			
			// This commented out line is here just in case we want to include descriptors in the patients' files
			//writer.write("\nContact: " + contact + "\nEmergency Contact: " + emergency_contact + "\nAllergies and Health Concerns: " + health_concerns + "\nImmunization History: " + immunization + "\nPatient History: " + history + "\nPrescription: " + prescription + "\nVitals: " + vitals);
					
			writer.write("\n" + contact + "\n" + emergency_contact + "\n" + health_concerns + "\n" + immunization + "\n" + history + "\n" + prescription + "\n" + vitals);
			
			writer.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
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
			//e.printStackTrace();
			
			return 0;
		}
	}
	
	public ArrayList<String> readFile(String username) 
	{   
		try
		{
			ArrayList<String> list = null;
			
			BufferedReader reader = new BufferedReader(new FileReader(username + "_UserInfo.txt"));
			
			//reader.readLine();
			
			String line;
			
			list = new ArrayList<String>();
            
			while((line = reader.readLine()) != null)
			{
				list.add(line);   
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
	
	
}
