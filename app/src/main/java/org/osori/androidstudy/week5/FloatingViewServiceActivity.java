package org.osori.androidstudy.week5;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Wanju Kim on 2017-07-16.
 */

public class FloatingViewServiceActivity extends AppCompatActivity {

    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION=2084;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Log.d("T_T", "onCreate is called");
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M&&!Settings.canDrawOverlays(this)){
            Intent intent=new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:"+getPackageName()));
            startActivityForResult(intent,CODE_DRAW_OVER_OTHER_APP_PERMISSION);
        }
        else{
            initializeView();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // from startActivityForResult
        if(requestCode==CODE_DRAW_OVER_OTHER_APP_PERMISSION){
            if(resultCode==RESULT_OK){
                initializeView();
            }
            else{
                Toast.makeText(this,"Permission is denied",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void initializeView(){
        Log.d("T_T", "initializeView is called");
        startService(new Intent(this, FloatingViewService.class));
        finish();
    }
}
