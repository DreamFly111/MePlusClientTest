package duoy.cn.meplusclienttest.app;

/**
 * Created by Dream on 2016/3/3.
 */
public class MePlusApplication extends ModelApplication {//单例模式

    private static MePlusApplication instance;//私有化对象

    public static MePlusApplication getInstance(){return instance;}//对外提供get方法
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
