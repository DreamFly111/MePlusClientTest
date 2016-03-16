package duoy.cn.meplusclienttest.activity;

import android.os.Bundle;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.trinea.android.common.util.ToastUtils;
import duoy.cn.meplusclienttest.Constants;
import duoy.cn.meplusclienttest.R;
import duoy.cn.meplusclienttest.event.ScannerEvent;
import duoy.cn.meplusclienttest.fragments.SimpleScannerFragment;

/**
 * Created by Dream on 2016/3/7.
 */
public class ScannerActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        replaceContainer(R.id.frame_layout,SimpleScannerFragment.newInstance());//替换fragment
    }

    @Subscribe(threadMode = ThreadMode.MAIN)//PubNub
    public void onScannerEvent(ScannerEvent event){
        if(!Constants.sRelease){//执行提示
            final String content = event.getContent();
            ToastUtils.show(this,content);
        }
        SimpleScannerFragment scannerFragment = (SimpleScannerFragment)findFragmentById(R.id.frame_layout);
        scannerFragment.resumeScanner();
    }
}
