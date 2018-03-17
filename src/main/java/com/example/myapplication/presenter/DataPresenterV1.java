package com.example.myapplication.presenter;

import com.example.myapplication.model.DataModel;
import com.example.myapplication.model.DataModelImplV1;
import com.example.myapplication.view.IDataView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by cqian on 2018/3/11.
 */

public class DataPresenterV1<T extends IDataView> {
    //presenter要持有view和model


    //view
    //IDataView mDataView;

    //model
    DataModel mDataModel = new DataModelImplV1();

    //将view层引用加到弱引用中去，防止内存溢出
    protected WeakReference<T> mViewRef;

    public DataPresenterV1(T mDataView) {
        //this.mDataView = mDataView;
        mViewRef=new WeakReference<T>(mDataView);
    }

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
