package duoy.cn.meplusclienttest.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVUser;

/**
 * Created by Dream on 2016/3/4.
 */
@AVClassName("User")
public class User extends AVUser{
    public static final Creator CREATOR = AVObjectCreator.instance;//CREATOR必须为大写字母，否则User报错
    public String getBithday(){
        return getString("birthday");
    }
    public void setBirthday(String birthday){
        put("birthday",birthday);
    }
}
