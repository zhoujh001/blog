package interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import model.User;

/**
 * Created by Administrator on 2015/3/6.
 */
public class LoginStateCheck implements Interceptor {
    @Override
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        Object login_user = controller.getSessionAttr("login_user");
        if (login_user != null && login_user instanceof User) {
            ai.invoke();
        }else{
            controller.forwardAction("/admin");
        }

    }
}
