package utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import Constants.Constants;

public class Configreader {
	private Properties prop;
	public Properties init_prop() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE);
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }
}
