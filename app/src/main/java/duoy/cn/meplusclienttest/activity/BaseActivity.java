package duoy.cn.meplusclienttest.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void replaceContainer(int containerViewId, android.support.v4.app.Fragment fragment){

        // 获取fragmentManager
        final FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        //替换
        transaction.replace(containerViewId,fragment);
        //提交
        transaction.commitAllowingStateLoss();
    }
    public Fragment findFragmentById(int containerViewId){
        //获取fragmentManager
        final FragmentManager fragmentManager = getSupportFragmentManager();
        return fragmentManager.findFragmentById(containerViewId);
    }
}
