package controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/3/6.
 */
public class AdminController extends Controller {

    /**
     * 跳转登录页
     */
    public void index() {
        render("admin.jsp");
    }

    /**
     * 执行登录信息检查
     */
    public void login() {
        //获取表单参数
        User formUser = getModel(User.class);
        String remindUser = getPara("remind");//checkbox被选，返回on，否则为null

        List<Record> userList = Db.find("SELECT * FROM user WHERE username=?", formUser.get("username"));
        if (userList != null && userList.size() > 0) {
            //存在该用户,继续判断密码是否正确
            String psw = userList.get(0).get("password");
            if (formUser.get("password").equals(psw)) {
                //登录成功,跳转到主页
                setSessionAttr("login_user", userList.get(0));
                forwardAction("/");
            } else {
                //密码不正确，返回登录页
                setAttr("loginInfo", "密码错误！");
                index();
                return;
            }
        } else {
            //用户不存在,返回登录页
            setAttr("loginInfo", "用户不存在！");
            index();
            return;
        }

    }

    /**
     * 退出，清除session
     */
    public void loginOut() {
        setSessionAttr("login_user", null);
        //返回首页
        forwardAction("/");
    }

    /**
     * 注册用户
     */
    public void register() {
        User register_user = getModel(User.class,"reg");
        register_user.set("registDate", new Date());
        boolean flag = register_user.save();
        if (!flag) {
            renderText("注册失败，请稍后重试。。。");
        }
        index();
    }

    /**
     * 检查用户名是否存在
     */
    public void checkUserName() {
        String username = getPara("username");
        List<Record> records = Db.find("SELECT * FROM user WHERE username=?", username);
        if (records != null && records.size() > 0) {
            //用户名已存在
            //setAttr("checkInfo", "该用户名已经被注册");
            renderJson("checkInfo", "该用户名已经被注册");
        }else {
            renderJson("checkInfo", "");
        }
    }

}
