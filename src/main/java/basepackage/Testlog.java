package basepackage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Testlog {

	
		 //private static final Logger LOGGER = LogManager.getLogger("myLogger");
	 static Logger LOGGER ;
		    public static void main(String[] args)
		    {
		    	System.setProperty("log4j.configurationFile",  System.getProperty("user.dir")+"\\src\\main\\resources\\configFiles\\log4j2.xml");
		    	LOGGER= LogManager.getLogger("myLogger");
		    	//LOGGER.atLevel(Level.ALL);
		        LOGGER.debug("Debug Message Logged !!!");
		        LOGGER.info("Info Message Logged !!!");
		        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
		    }
	

}
