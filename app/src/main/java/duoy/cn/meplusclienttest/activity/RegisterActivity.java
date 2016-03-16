package duoy.cn.meplusclienttest.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.avos.avoscloud.AVException;

import com.avos.avoscloud.SignUpCallback;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import duoy.cn.meplusclienttest.R;
import duoy.cn.meplusclienttest.event.Event;
import duoy.cn.meplusclienttest.event.SignUpEvent;
import duoy.cn.meplusclienttest.fragments.SimpleScannerFragment;
import duoy.cn.meplusclienttest.model.User;
import duoy.cn.meplusclienttest.utils.IntentUtils;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity implements Validator.ValidationListener{//需要重写方法
    @Bind(R.id.root)
    ViewGroup mRoot;

    @NotEmpty
    @Bind(R.id.phone_edit)
    EditText mPhone_edit;

    @Email
    @Bind(R.id.email_edit)
    EditText mEmail_edit;

    @Password
    @Bind(R.id.password_edit)
    EditText mPwd_edit;

    @ConfirmPassword
    @Bind(R.id.confirm_edit)
    EditText mConfirm_edit;

    private Validator mValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

        //replaceContainer(R.id.frame_layout, SimpleScannerFragment.newInstance());

        /*原始的自动注册*/
       /* User user = new User();
        user.setUsername("hjiang" + SystemClock.currentThreadTimeMillis());
        user.setPassword("f32@ds*@&dsa");
        user.setEmail("hang" + SystemClock.currentThreadTimeMillis() + "@leancloud.rocks");
        // 其他属性可以像其他AVObject对象一样使用put方法添加
        user.put("phone", "186-1234-0000");

        user.signUpInBackground(new SignUpCallback() {
            public void done(AVException e) {
                if (e == null) {
                    // successfully
                    finish();
                } else {
                    // failed
                }
            }
        });*/
    }

    @OnClick(R.id.register_button)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.register_button:
                mValidator.validate();//重写继承的validator
                break;
            default:
                break;
        }
    }
    @Override
    public void onValidationSucceeded() {
        doRegister();
    }

    private void doRegister() {
        //获取输入框信息
        final String userName = mPhone_edit.getText().toString();
        final String passWord = mPwd_edit.getText().toString();
        final String emai = mEmail_edit.getText().toString();

        //给user设置,user继承的AVUser
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);
        user.setEmail(emai);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if(e==null){//无异常，则正常post
                    EventBus.getDefault().post(new SignUpEvent(Event.STATUS_OK));
                    startActivity(IntentUtils.generateIntent(RegisterActivity.this,MainActivity.class));
                    finish();
                }else{
                    Snackbar.make(mRoot,e.toString(),Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors){
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if(view instanceof EditText){
                ((EditText) view).setError(message);
            }else{
                Snackbar.make(mRoot,message,Snackbar.LENGTH_LONG).show();
            }
        }
    }
}
