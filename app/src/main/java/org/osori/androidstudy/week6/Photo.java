package org.osori.androidstudy.week6;

/**
 * Created by Wanju Kim on 2017-07-23.
 */

public class Photo {
    private int bucketId;
    private int photoId;
    private String path;

    public int getBucketId(){
        return bucketId;
    }

    public void setBucketId(int bucketId){
        this.bucketId=bucketId;
    }

    public String getPath(){
        return path;
    }

    public void setPath(String path){
        this.path=path;
    }
}
