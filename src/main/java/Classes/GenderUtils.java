package Classes;
import ru.vsu.lab.entities.enums.*;

public class GenderUtils {

	public static Gender StringToGender(String genderStr)
	{
	   if(genderStr.toLowerCase()=="male")
		   return Gender.MALE;
	   if(genderStr.toLowerCase()=="female")
		   return Gender.FEMALE;
	   else return Gender.FEMALE;

	}
}
