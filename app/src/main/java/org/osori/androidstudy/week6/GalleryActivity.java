package org.osori.androidstudy.week6;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.osori.androidstudy.R;

import java.util.List;

/**
 * Created by Wanju Kim on 2017-07-23.
 */

public class GalleryActivity extends AppCompatActivity implements PhotoAdapter.PhotoClickListener{
    private static final String TAG=GalleryActivity.class.getSimpleName();

    private RecyclerView photoListView;
    private PhotoAdapter adapter;

    private final int STORAGE_PERMISSION_REQUEST=2017; // 큰 숫자로, reserved code피하려고

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        photoListView=(RecyclerView)findViewById(R.id.photo_list_view); // 불특정 n개의 res들

        adapter=new PhotoAdapter(this);
        adapter.setOnItemClickListener(this);

        /* 아이템의 항목을 배치치 */
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,3); //context를 상속하는 4개의 컴포넌트

        photoListView.setAdapter(adapter); // bind해주는 것
        photoListView.setLayoutManager(layoutManager); // layout설정

        /* 앱 외부 저장장치로의 접근 요구 */
        Log.d(TAG,"permission request is called");
        String[] permissions={Manifest.permission.READ_EXTERNAL_STORAGE}; // WRITE_EXTERNAL_STORAGE
        ActivityCompat.requestPermissions(this,permissions,STORAGE_PERMISSION_REQUEST); // request 순으로 index 결정
    }
    /* 권한체크가 끝났을때 저절로 불러주는 함수 */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case STORAGE_PERMISSION_REQUEST:
                if(grantResults[0]== PermissionChecker.PERMISSION_GRANTED){ // [0]이 read 권한
                    runGalleryScan();
                }
        }
    }

    private void runGalleryScan(){ // main thread(ui thread)에서 돌리지 말고 다른 thread로 execution
        new Thread(new Runnable() {
            @Override
            public void run() { // new thread가 긁어옴
                final List<Photo> photoList=GalleryScanner.photoScan(GalleryScanner.ALL_PHOTO_BUCKET);
                runOnUiThread(new Runnable() { // 그 내용을 이제 다시 main thread에서 그려줘
                    @Override
                    public void run() {
                        adapter.addPhotoList(photoList);
                        adapter.notifyDataSetChanged(); // adapter에 바뀌엇다는 것을 알려줌 => onBind...()를 다시 부름 => 다시 그려줌
                    }
                });
            }
        }).start();
    }

    @Override
    public void onClickPhoto(Photo photo) {
        Toast.makeText(this,photo.getPath(),Toast.LENGTH_SHORT).show();
    }
}
