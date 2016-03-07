package duoy.cn.meplusclienttest.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import cn.trinea.android.common.util.ToastUtils;

/**
 * Created by Dream on 2016/3/7.
 */
public class ScannerActivity extends BaseActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ToastUtils.show(this,"ScannerActivity");
    }
}
