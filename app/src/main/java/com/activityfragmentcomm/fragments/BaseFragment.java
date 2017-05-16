package com.activityfragmentcomm.fragments;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.activityfragmentcomm.activity.BaseActivity;
import com.activityfragmentcomm.function.Functions;

public class BaseFragment extends Fragment{

    protected Functions mFunctions;

    protected BaseActivity mBaseActivity;

    /**
     * activity调用此方法进行设置Functions
     * @param functions
     */
    public void setFunctions(Functions functions){
        this.mFunctions = functions;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("url", BaseFragment.class.getSimpleName());
        if(context instanceof BaseActivity){
            mBaseActivity = (BaseActivity)context;
            mBaseActivity.setFunctionsForFragment(getTag());
        }
    }
}
