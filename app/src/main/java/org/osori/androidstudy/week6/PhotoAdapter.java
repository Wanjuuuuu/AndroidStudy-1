package org.osori.androidstudy.week6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.osori.androidstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wanju Kim on 2017-07-23.
 */

/* 데이터와 아이템에 대한 view생성
*  아이템의 데이터와 뷰간의 처리 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private static final String TAG=PhotoAdapter.class.getSimpleName();

    private Context mContext;
    private LayoutInflater mInflater;

    private List<Photo> photoList=new ArrayList<>(); // scanner에서 가져오는 그림을 가질 배열
    private PhotoClickListener mClickListener;

    public PhotoAdapter(Context context){
        mContext=context;
        mInflater=LayoutInflater.from(context); // xml을 뷰로 그려줌
    }

    public void setOnItemClickListener(PhotoClickListener listener){
        mClickListener=listener;
    }

    /* ViewHolder 생성 view를 만들어주는 것(image랑 text) */
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.d(TAG,"onCreateViewHolder is called");
        return new PhotoViewHolder(mInflater.inflate(R.layout.item_album,parent,false));
    }

    /* 만들어진 ViewHolder에 데이터를 넣음 */
    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) { // viewholder pool에 놀고 있는 viewholder들이 자동으로 photolist[position]을 사용
//        Log.d(TAG,"onBindViewHolder is called");
        Photo photo=photoList.get(position);
        holder.bind(photo);
    }

    /* 데이터의 갯수 */
    @Override
    public int getItemCount() {
//        Log.d(TAG,"getItemCount is called with count:"+photoList.size());
        return photoList.size();
    }

    public void addPhotoList(List<Photo> photoList){
        this.photoList.addAll(photoList);
    }

    /* 재활용 View에 대한 모든 서브 뷰를 보유 */

    class PhotoViewHolder extends RecyclerView.ViewHolder{
        private ImageView photoImage;
        private TextView photoPath;

        private Photo photo;

        PhotoViewHolder(View itemView){
            super(itemView);
            photoImage=(ImageView)itemView.findViewById(R.id.photo_image); //
            photoPath=(TextView)itemView.findViewById(R.id.photo_path); //

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mClickListener.onClickPhoto(photo);
                }
            });
        }
        private void bind(Photo photo){ // photo를 실제로 그려줌
            this.photo=photo;

            Glide.with(mContext).load(photo.getPath()).into(photoImage);
            photoPath.setText(photo.getPath());
        }
    }

    public interface PhotoClickListener{
        public void onClickPhoto(Photo photo);
    }

}
