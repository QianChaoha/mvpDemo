package com.example.myapplication.model;

import java.util.List;

/**
 * Created by cqian on 2018/3/11.
 * model:业务逻辑层,这里demo的业务逻辑就是从网络中获取数据并加载数据
 */

public interface DataModel {
    void loadData(OnDataLoadListener listener);

    /**
     * 加载完成的监听
     */
    interface OnDataLoadListener{
        void onComplete(List<String> data);
    }
}
