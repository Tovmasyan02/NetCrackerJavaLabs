package Classes;

import java.lang.reflect.*;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import Annotations.InjectAnnotation;

public class Inject {

	private static Logger logger = LoggerFactory.getLogger(Inject.class);
	
	public static <T> T injectMethod(T object)
	{
		try {
			Class<?> cl = object.getClass();
			Field[] allFields = cl.getDeclaredFields();
			ArrayList<Field> trueFields = new ArrayList<Field>();
			for (Field field : allFields) {
				if (field.isAnnotationPresent(InjectAnnotation.class)) {
					field.setAccessible(true);
					trueFields.add(field);
				}
	
			}
		
			for (Field field0 : trueFields) {
				String className = readFile(field0.getType().getName(), "src\\main\\resources\\InjectFile.txt");
				Class<?> clazz = Class.forName(className);
				Constructor<?> ctor = clazz.getConstructor();
				field0.set(object, ctor.newInstance());
			}
			return object;
			}
		catch(Exception ex)
		{
			logger.warn(ex.getMessage());
			return null;
		}
	}

	private static String readFile(String classPath, String filePath) {
		BufferedReader bf;
		try
		{
			bf = new BufferedReader(new FileReader(filePath));
			String line = "";
			ArrayList<String> allLines = new ArrayList<String>();
			String classPath2 = null;
			while ((line = bf.readLine()) != null) {
				allLines.add(line);
			}
			for (int i = 0; i < allLines.size(); i++) {
				String lineX = allLines.get(i);
				String[] s = lineX.split("-");
				if (s[0].equals(classPath)) {
					classPath2 = s[1];
				}
			}
			bf.close();
			return classPath2;
		}
		catch(Exception ex)
		{
			logger.warn(ex.getMessage());
			return null;
		}
		
	}

}
