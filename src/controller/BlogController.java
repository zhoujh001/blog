package controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import interceptor.LoginStateCheck;
import model.User;

/**
 * Created by Administrator on 2015/3/4.
 */
public class BlogController extends Controller {

    public void index() {
        render("index.jsp");
    }
}
