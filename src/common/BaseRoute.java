package common;

import com.jfinal.config.Routes;
import utils.AutoBindRoutes;

/**
 * Created by Administrator on 2015/3/9.
 */
public class BaseRoute extends Routes {
    @Override
    public void config() {
        AutoBindRoutes autoBindRoutes = new AutoBindRoutes();
        String[] ctrlName = autoBindRoutes.scanAllCtrl("controller");
        for (String name : ctrlName) {
            String[] names = name.split("\\.");
            String addressName = names[names.length-2];
            addressName = addressName.substring(0,addressName.length()-10).toLowerCase();
            add("/" + addressName, getClassByName(name), "/");
        }

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
