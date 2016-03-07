package duoy.cn.meplusclienttest.activity;

import android.os.Bundle;

import duoy.cn.meplusclienttest.R;
import duoy.cn.meplusclienttest.fragments.SimpleScannerFragment;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        replaceContainer(R.id.frame_layout, SimpleScannerFragment.newInstance());
    }

}
