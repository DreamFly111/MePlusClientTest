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
        final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();//获取fragmentManager
        final FragmentTransaction transaction = fragmentManager.beginTransaction();//开启事务
        transaction.replace(containerViewId ,fragment);
        transaction.commitAllowingStateLoss();
    }

    public Fragment findFragmentById(int containerViewId){
        final FragmentManager fragmentManager = getSupportFragmentManager();
        return fragmentManager.findFragmentById(containerViewId);
    }
}
