package Classes;

import ru.vsu.lab.repository.*;

import com.opencsv.*;
import java.io.FileReader;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
public class PersonRepositoryIO {

	/**
	 * Читает все данные из CSV Файла создает Repository, заполняет и возвращает.

	 * 	
	 *  */
	
	

	@SuppressWarnings("deprecation")

	public static IPersonRepository readAllDataFromCSV(String path) 
	{ 
		PersonRepository rep=new PersonRepository();
		try
		{
			FileReader filereader = new FileReader(path); 
			CSVReader reader = new CSVReader(filereader, ';');
			try { 
				List<String[]> allData = reader.readAll();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
				for(int i=1;i<allData.size()-1;i++)
				{	
					Person newPerson=new Person(
							Integer.parseInt(allData.get(i)[0]),
							allData.get(i)[1],
							GenderUtils.StringToGender(allData.get(i)[2]),
							LocalDate.parse(allData.get(i)[3], dtf),
							allData.get(i)[4],
							Integer.parseInt(allData.get(i)[5])
									);
					rep.add(newPerson);	
				}
			   } 			
			catch (Exception e) { 
				e.printStackTrace(); 
				e.getClass();
			}
			finally
			{
				reader.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return rep;
	} 
	
}
