package org.osori.androidstudy.week6;

import android.app.Application;
import android.content.Context;

/**
 * Created by Wanju Kim on 2017-07-23.
 */

public class AndroidApplication extends Application {

   //어플리케이션 사이의 컴포넌트들이 공동으로 사용할 수 있기 때문에 공통되게 사용하는 내용을 작성해주면 어디서든 context를 이용한 접근이 가능 합니다.

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext=getApplicationContext();
    }

    public static Context getContext(){
        return applicationContext;
    }
}
