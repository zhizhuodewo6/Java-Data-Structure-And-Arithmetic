package com.tool.wpn.quicksort;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by XiJie on 2017/7/27.
 */

public class OneActivity extends Activity{
    private final String TAG="OneActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }

    public void close(View view){
        finish();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level){
            case TRIM_MEMORY_RUNNING_MODERATE:
                Log.i(TAG,"TRIM_MEMORY_RUNNING_MODERATE执行...");
                break;
            case TRIM_MEMORY_RUNNING_LOW:
                Log.i(TAG,"TRIM_MEMORY_RUNNING_LOW执行...");
                break;
            case TRIM_MEMORY_RUNNING_CRITICAL:
                Log.i(TAG,"TRIM_MEMORY_RUNNING_CRITICAL执行...");
                break;
            case TRIM_MEMORY_BACKGROUND:
                Log.i(TAG,"TRIM_MEMORY_BACKGROUND执行...");
                break;
            case TRIM_MEMORY_MODERATE:
                Log.i(TAG,"TRIM_MEMORY_MODERATE执行...");
                break;
            case TRIM_MEMORY_COMPLETE:
                Log.i(TAG,"TRIM_MEMORY_COMPLETE执行...");
                break;
            case TRIM_MEMORY_UI_HIDDEN:
                Log.i(TAG,"TRIM_MEMORY_UI_HIDDEN执行...");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop执行...");
    }
}
