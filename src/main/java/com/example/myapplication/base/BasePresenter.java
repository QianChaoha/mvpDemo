package com.example.myapplication.base;

import java.lang.ref.WeakReference;

/**
 * Created by cqian on 2018/3/17.
 */

public class BasePresenter<T> {
    //将view层引用加到弱引用中去，防止内存溢出
    protected WeakReference<T> mViewRef;
    //绑定
    public void attachView(T mDataView){
        mViewRef=new WeakReference<T>(mDataView);
    }
    //解绑
    public void detachView(){
        mViewRef.clear();
    }
}
