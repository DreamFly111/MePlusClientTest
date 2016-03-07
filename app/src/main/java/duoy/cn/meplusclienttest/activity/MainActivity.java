package duoy.cn.meplusclienttest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import duoy.cn.meplusclienttest.Constants;
import duoy.cn.meplusclienttest.R;
import duoy.cn.meplusclienttest.utils.FIRUtils;
import im.fir.sdk.FIR;
import im.fir.sdk.VersionCheckCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FIRUtils.checkForUpdateInFIR(this);
    }


}
