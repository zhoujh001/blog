package common;

import com.jfinal.config.Routes;
import utils.AutoBindRoutes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Administrator on 2015/3/9.
 */
public class BaseRoute extends Routes {
    @Override
    public void config() {
        AutoBindRoutes autoBindRoutes = new AutoBindRoutes();
        String scannerDir = getProperties("config.properties");
        String[] ctrlName = autoBindRoutes.scanAllCtrl(scannerDir);
        for (String name : ctrlName) {
            String[] names = name.split("\\.");
            String addressName = names[names.length-2];
            addressName = addressName.substring(0,addressName.length()-10).toLowerCase();
            add("/" + addressName, getClassByName(name), "/");
        }

    }

    private String getProperties(String s) {
        Properties properties = new Properties();
        try {
            properties.load(BaseRoute.class.getResourceAsStream("route.properties"));
            String property = properties.getProperty("scannerDir");
            return property;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Class getClassByName(String name) {
        name = name.substring(0,name.indexOf(".class"));    //去除类的全路径后的.class
        Class clazz;
        try {
            clazz = Class.forName(name);
            return clazz;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new BaseRoute().config();
    }
}
