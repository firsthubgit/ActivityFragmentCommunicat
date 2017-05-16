package com.activityfragmentcomm.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.activityfragmentcomm.R;
import com.activityfragmentcomm.fragments.BaseFragment;
import com.activityfragmentcomm.fragments.MainFragment;
import com.activityfragmentcomm.fragments.SecondFragment;
import com.activityfragmentcomm.function.Functions;

public class MainActivity extends BaseActivity {
    private Functions mFunctions = new Functions();
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setFunctionsForFragment(String fragmentTAG) {
        mFragmentManager = getSupportFragmentManager();
        if("fragment_main".equals(fragmentTAG)){
            BaseFragment mainFragment = (BaseFragment)mFragmentManager.findFragmentByTag(fragmentTAG);
            mainFragment.setFunctions(mFunctions);
            mFunctions.addFunction(new Functions.FunctionWithParamAndResult<String,
                    String>(MainFragment.FUNCTION_WPAR) {
                @Override
                public String function(String str) {
                    Toast.makeText(MainActivity.this,
                            "收到MainFragment参数:" + str,
                            Toast.LENGTH_SHORT).show();
                    return "Activty处理参数:" + str;
                }
            });
        } else if("fragment_second".equals(fragmentTAG)){
            BaseFragment secondFragment = (BaseFragment)mFragmentManager.findFragmentByTag(fragmentTAG);
            secondFragment.setFunctions(mFunctions);
            mFunctions.addFunction(new Functions.FunctionWithParamAndResult<String,
                    String>(SecondFragment.FUNCTION_WPAR) {
                @Override
                public String function(String str) {
                    Toast.makeText(MainActivity.this,
                            "收到SecondFragment参数:" + str,
                            Toast.LENGTH_SHORT).show();
                    return "Activty处理参数:" + str;
                }
            });
        }
    }
}
