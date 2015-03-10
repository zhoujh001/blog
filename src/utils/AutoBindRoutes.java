package utils;

import java.io.File;
import java.net.URL;

/**
 * Created by Administrator on 2015/3/9.
 * 自动扫描controller包中的所有路径，并注册到jfinal中
 */
public class AutoBindRoutes {
    static URL ctrlPath = AutoBindRoutes.class.getResource("/");

    /**
     * 扫描指定文件夹下的类，分析出Controller.class和访问路径，并自动注册到路由中
     *
     * @param ctrlDirName
     * @return
     */
    public String[] scanAllCtrl(String ctrlDirName) {
        //保存参数值
        String oldCtrlDirNmae = ctrlDirName;
        //按路由的指定格式解析
        ctrlDirName = ctrlPath + "/" + ctrlDirName;  //controller文件夹的路径
        ctrlDirName = ctrlDirName.substring(6, ctrlDirName.length());
        File file = new File(ctrlDirName);
        String[] ctrlClassName;
        if (file.isDirectory()) {
            String[] list = file.list();
            ctrlClassName = new String[list.length];
            int i = 0;
            for (String fileName : list) {
                ctrlClassName[i] = oldCtrlDirNmae + "." + fileName;
                i++;
            }
        } else {
            throw (new RuntimeException("Controller Package is Error."));
        }

        return ctrlClassName;
    }

    public static void main(String[] args) {
        new AutoBindRoutes().scanAllCtrl("controller");
    }
}
