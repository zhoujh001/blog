package model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by Administrator on 2015/3/6.
 */
public class User extends Model<User> {
    public static User userdao = new User();
}
