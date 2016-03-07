package duoy.cn.meplusclienttest.app;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.crashlytics.android.Crashlytics;

import duoy.cn.meplusclienttest.Constants;
import duoy.cn.meplusclienttest.model.User;
import im.fir.sdk.FIR;
import io.fabric.sdk.android.Fabric;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FIR.init(this);
        Fabric.with(this, new Crashlytics());//统计崩溃

        AVObject.registerSubclass(User.class);
        AVOSCloud.initialize(this, Constants.AVOS_APP_ID,Constants.AVOS_APP_KEY);
        // AVOSCloud.useAVCloudUS(); // 启用北美节点
        // AVAnalytics.enableCrashReport(this.getApplicationContext(), true);  // 启用崩溃错误统计
        AVOSCloud.setLastModifyEnabled(true);
        AVOSCloud.setDebugLogEnabled(true);
    }
}
