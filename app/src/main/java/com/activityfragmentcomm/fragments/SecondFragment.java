package com.activityfragmentcomm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.activityfragmentcomm.R;
import com.activityfragmentcomm.function.NoFunctionException;


public class SecondFragment extends BaseFragment {

    public static final String FUNCTION_WPAR = "SECOND_FUNCTION_WITH_PARAM_AND_RESULT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn1 = (Button) view.findViewById(R.id.button1);
        final TextView tv1 = (TextView) view.findViewById(R.id.textview1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String result = mFunctions.invokeFunction(FUNCTION_WPAR,
                            String.class, "来自SecondFragment参数");
                    tv1.setText(result);
                } catch (NoFunctionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
