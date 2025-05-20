package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to file operations
 * @author Kavya L
 *
 */

public class FileUtility {
		/**
		 * This method will read data from property file and return the value
		 * to caller
		 * @param key
		 * @return
		 * @throws IOException
		 */
		
		public String readDataFromPropertyfile(String key) throws IOException  {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
			}

	} 


