package duoy.cn.meplusclienttest.app;

import android.app.Application;

import im.fir.sdk.FIR;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FIR.init(this);
    }
}
