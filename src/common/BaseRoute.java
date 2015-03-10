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
        //获取自动扫描的路径
        String scannerDir = getProperties("config.properties");
        //获取扫描包后的类名
        String[] ctrlName = autoBindRoutes.scanAllCtrl(scannerDir);
        for (String name : ctrlName) {
            //解析自动注册的Controller，并注册访问路径
            String[] names = name.split("\\.");
            String addressName = names[names.length-2];
            //访问路径为类名去除后面的Controller为访问改Controller的根路径
            //例如：AdminController类的访问路径为/admin
            addressName = addressName.substring(0,addressName.length()-10).toLowerCase();

            add("/" + addressName, getClassByName(name), "/");
        }

    }

    /**
     * 读取配置文件中自动注册路由的扫描路径
     * @param s
     * @return
     */
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

    /**
     * 返回扫描包下的Controller的Class对象
     * @param name
     * @return
     */
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
}
