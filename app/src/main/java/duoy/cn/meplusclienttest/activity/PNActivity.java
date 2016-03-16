package duoy.cn.meplusclienttest.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import duoy.cn.meplusclienttest.R;
import duoy.cn.meplusclienttest.event.PNEvent;

public class PNActivity extends PNTestActivity {
    @Bind(R.id.textText)
    TextView textView;
    @Bind(R.id.editText)
    EditText editText;

    @OnClick(R.id.button)
    public void onClick(View view){
        final String message = editText.getText().toString();
        publish(message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pn);

        ButterKnife.bind(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)//prepare subscribe
    public void onPnEvent(PNEvent pnEvent){
        String message = pnEvent.getMessage().toString();
        textView.setText(message);
    }
}
