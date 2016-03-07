package duoy.cn.meplusclienttest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import duoy.cn.meplusclienttest.Constants;
import duoy.cn.meplusclienttest.R;
import duoy.cn.meplusclienttest.fragments.SimpleScannerFragment;
import duoy.cn.meplusclienttest.utils.FIRUtils;
import duoy.cn.meplusclienttest.utils.IntentUtils;
import io.agora.sample.agora.EntryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);//注入

        FIRUtils.checkForUpdateInFIR(this);
    }

    @OnClick({R.id.btnPNTest,R.id.btnAgoraTest,R.id.btnRQTest})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnPNTest:
                startActivity(IntentUtils.generateIntent(this,PNTestActivity.class));
                break;
            case R.id.btnAgoraTest:
                startActivity(IntentUtils.generateIntent(this, EntryActivity.class));
                break;
            case R.id.btnRQTest:
                startActivity(IntentUtils.generateIntent(this, ScannerActivity.class));
                break;
            default:
                break;
        }
    }

}
