package controller;

import com.jfinal.core.Controller;
import model.User;

/**
 * Created by Administrator on 2015/3/4.
 */
public class BlogController extends Controller {

    public void index() {
        User login_user = getModel(User.class);
        setSessionAttr("login_user", login_user);
        render("index.jsp");
    }
}
