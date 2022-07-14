package utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //1-Properties objesi olusturacagiz
    private static Properties properties;
    //2-Bu classin amaci configration.properties dosyasini okumak
    // ve aradaki key ikililerini kullanarak istegimiz key e ait value bize getirmek
    static {
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //3-test classlarindan configReader classina
    // ulasip yukaridaki islemleri yapmamizi saglayacak bir method
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
