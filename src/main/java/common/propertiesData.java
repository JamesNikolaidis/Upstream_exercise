package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesData {

    private Properties properties=null;
    private static propertiesData data =null;


    private propertiesData(){
        loadPropertiesFile("data.properties");
    }

    public static propertiesData getPropertiesData(){
        if(data==null){
            data =new propertiesData();
        }
        return data;
    }

    private void loadPropertiesFile(String propertyFile){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
        this.properties = new Properties();
        try {
            this.properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLoginUsername(){
        return this.properties.getProperty("login.username");
    }

    public String getLoginPassword(){
        return this.properties.getProperty("login.password");
    }

}
