package interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by Administrator on 2015/3/6.
 */
public class LoginStateCheck implements Interceptor {
    @Override
    public void intercept(ActionInvocation ai) {
    }
}
