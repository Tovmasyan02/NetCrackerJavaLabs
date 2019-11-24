package Classes;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.repository.*;
import ru.vsu.lab.entities.*;
import com.opencsv.*;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Stream;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
public class PersonRepositoryIO {

	/**
	 * ������ ��� ������ �� CSV ����� ������� Repository, ��������� � ����������.

	 * 	
	 *  */
	
	

	@SuppressWarnings("deprecation")
	public static IPersonRepository readAllDataFromCSV(String path) 
	{ 
		
		PersonRepository rep=new PersonRepository();
		try
		{
			FileReader filereader = new FileReader(path); 
			ArrayList<IDivision> divisions=new ArrayList<IDivision>();
			CSVReader reader = new CSVReader(filereader, ';');
			try { 
				List<String[]> allData = reader.readAll();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
				for(int i=1;i<allData.size();i++)
				{	
					IDivision newDivision=null;
					for(IDivision division:divisions)
					{

						if(division.getName().equals(allData.get(i)[4]))
						{
							newDivision=division;
							break;
						}
					}
					
					if(newDivision==null)
					{
						newDivision=new Division(i,allData.get(i)[4]);
						divisions.add(newDivision);
					}

					Person newPerson=new Person(
							Integer.parseInt(allData.get(i)[0]),
							allData.get(i)[1],
							GenderUtils.StringToGender(allData.get(i)[2]),
							LocalDate.parse(allData.get(i)[3], dtf),
							Integer.parseInt(allData.get(i)[5]),
							newDivision
									);

					rep.add(newPerson);	

				}
				System.out.println(divisions.size());
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
