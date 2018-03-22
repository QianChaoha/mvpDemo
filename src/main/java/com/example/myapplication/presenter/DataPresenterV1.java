package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.DataModel;
import com.example.myapplication.model.DataModelImplV1;
import com.example.myapplication.view.IDataView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by cqian on 2018/3/11.
 */

public class DataPresenterV1<T extends IDataView> extends BasePresenter<T> {
    //presenter要持有view和model


    //view
    //IDataView mDataView;

    //model
    DataModel mDataModel = new DataModelImplV1();


    /**
     * 使用attachView()方法绑定view，可不需要此构造方法
     * @param mDataView
     */
    //@Deprecated
    //public DataPresenterV1(T mDataView) {
        //this.mDataView = mDataView;
        //使用弱引用包裹view层引用。问题:每次都是内存不够时才会被垃圾回收器回收
        //解决办法:使用attachView和detachView手动解绑
        //mViewRef=new WeakReference<T>(mDataView);


    //}

    /**
     * bind model和view
     */
    public void bind() {
        if (mViewRef.get()!=null){
            mViewRef.get().showLoadding();
            if (mDataModel != null) {
                //model加载数据，加载数据结束后让view显示数据
                mDataModel.loadData(new DataModel.OnDataLoadListener() {
                    @Override
                    public void onComplete(List<String> data) {
                        mViewRef.get().showData(data);
                    }
                });
            }
        }

    }
}
