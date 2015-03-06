package model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by Administrator on 2015/3/4.
 */
public class Blog extends Model<Blog> {
    public static Blog blogDao = new Blog();
}
