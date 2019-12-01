package Classes;
import java.lang.reflect.*;
import java.util.ArrayList;

import Annotations.InjectAnnotation;

public class Inject{
	
	public static <T> T InjectMethod (T object) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class<?> cl= object.getClass();
		Field[] allFields=cl.getDeclaredFields();
		ArrayList<Field> trueFields=new ArrayList<Field>();
		for(Field field : allFields)
	    {
			
			if(field.isAnnotationPresent(InjectAnnotation.class))
			{
				field.setAccessible(true);
				trueFields.add(field);
				System.out.println("+1 true field");
			}
		}
		
          String className="Classes.RepositoryBybbleSort";    
  		  Class<?> clazz = Class.forName(className);
          Constructor<?> ctor = clazz.getConstructor();
          Field field0=trueFields.get(0);
          field0.set(object, ctor.newInstance());
          return object;
	}
}
