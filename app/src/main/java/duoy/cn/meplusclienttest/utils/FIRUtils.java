package duoy.cn.meplusclienttest.utils;

import android.content.Context;
import android.util.Log;

import com.marvinlabs.intents.MediaIntents;

import cn.trinea.android.common.util.PackageUtils;
import duoy.cn.meplusclienttest.Constants;
import duoy.cn.meplusclienttest.model.FirVersion;
import im.fir.sdk.FIR;
import im.fir.sdk.VersionCheckCallback;

/**
 * Created by Dream on 2016/3/4.
 */
public class FIRUtils {
    public static void checkForUpdateInFIR(final Context context) {//必须是static，否则不能直接调用
        FIR.checkForUpdateInFIR(Constants.FIR_TOKEN, new VersionCheckCallback() {
            @Override
            public void onSuccess(String versionJson) {
                //super.onSuccess(s);

                Log.i("fir", "check from fir.im success! " + "\n" + versionJson);
                //获取firVersion
                final FirVersion version = JsonUtils.readValue(versionJson,FirVersion.class);
                final int versionCode = PackageUtils.getAppVersionCode(context);
                if (versionCode < version.version){//如果有高版本则更新
                    context.startActivity(MediaIntents.newOpenWebBrowserIntent(version.update_url));
                }
                   /*{"name":"MePlusClient","version":"1","changelog":"First release","updated_at":1456829748,"versionShort":"1.0","build":"1","installUrl":"http://download.fir.im/v2/app/install/56d57525748aac6cae000037?download_token=8122f240c21a2f3fef1481c112e666f6","install_url":"http://download.fir.im/v2/app/install/56d57525748aac6cae000037?download_token=8122f240c21a2f3fef1481c112e666f6","direct_install_url":"http://download.fir.im/v2/app/install/56d57525748aac6cae000037?download_token=8122f240c21a2f3fef1481c112e666f6","update_url":"http://fir.im/meplusclien","binary":{"fsize":1416518}}
                    FirVersion version = JsonUtils.readValue(versionJson, FirVersion.class);
                    Log.i("fir", version.toString());*/
            }

            @Override
            public void onFail(Exception exception) {
                //super.onFail(e);

                Log.i("fir", "check fir.im fail! " + "\n" + exception.getMessage());
            }

            @Override
            public void onStart() {
                //super.onStart();//需要重写，所以要去除super

                //Toast.makeText(getApplicationContext(), "正在获取", Toast.LENGTH_SHORT).show();
                Log.i("fir", "check fir.im start!"+"\n");
            }

            @Override
            public void onFinish() {
                //super.onFinish();

                //Toast.makeText(getApplicationContext(), "获取完成", Toast.LENGTH_SHORT).show();
                Log.i("fir", "check fir.im finish !"+"\n");
            }
        });
    }
}
