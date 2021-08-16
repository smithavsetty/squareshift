package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertieReader {
	static Properties p = new Properties();

	static {

		InputStream in;
		try {
			in = new FileInputStream(
					System.getProperty("user.dir") + "\\ObjectRepo\\PROP\\WebObjectRepository.properties");
			p.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {
		return p.getProperty(key);
	}
}
