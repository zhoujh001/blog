package common;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import controller.AdminController;
import controller.BlogController;
import interceptor.LoginStateCheck;
import model.User;

public class Config extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        loadPropertyFile("config.properties");
        me.setDevMode(true);
        me.setViewType(ViewType.JSP);
        me.setBaseViewPath("/WEB-INF/view");
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", BlogController.class);
        me.add("/admin", AdminController.class,"/");
    }

    @Override
    public void configPlugin(Plugins me) {
        // 配置DruidPlugin数据库连接池插件
        DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
        dp.addFilter(new StatFilter());
        WallFilter wall = new WallFilter();
        wall.setDbType("mysql");
        dp.addFilter(wall);
        me.add(dp);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setShowSql(true);
        me.add(arp);
        arp.addMapping("user", User.class);

    }

    @Override
    public void configInterceptor(Interceptors me) {
    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("contextPath"));
    }

    public static void main(String[] args) {
        JFinal.start("web",8088,"/",5);
    }
}
