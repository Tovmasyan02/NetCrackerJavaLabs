package Classes;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

public class Jaxb {
                      
	private static Logger logger = LoggerFactory.getLogger(Jaxb.class);
	
	public static void convertObjectToXml(Object arg,String filePath) {
		logger.debug("Convert Object to Xml");
        try {       	
            JAXBContext context = JAXBContext.newInstance(arg.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(arg, new File(filePath));
            
        } catch (JAXBException e) {
        	logger.warn(e.getMessage());
            e.printStackTrace();
        }
    }
    
    
	// универсальный вариант
    public static  Object fromXmlToObject(String filePath,Class<?> clazz) {
    	logger.debug("Convert Xml to Object");
        try {       	
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller un = jaxbContext.createUnmarshaller(); 
            return un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
        	logger.warn(e.getMessage());
            e.printStackTrace();
        }
        return null;
    } 
    

	private static Repository<Person> fromXmlToRepository(String filePath) {
    	logger.debug("Convert Xml to Repository");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
 
            return (Repository<Person>) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
        	logger.warn(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
 

}
