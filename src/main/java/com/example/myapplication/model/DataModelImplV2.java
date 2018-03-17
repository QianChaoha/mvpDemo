package com.example.myapplication.model;

import com.example.myapplication.utils.DataUtil;

import java.util.List;

/**
 * Created by cqian on 2018/3/11.
 * 从网络加载数据
 */

public class DataModelImplV2 implements DataModel {
    @Override
    public void loadData(OnDataLoadListener listener) {
        DataUtil dataUtil=new DataUtil();
        List data = dataUtil.getData(20);

        //回调监听
        listener.onComplete(data);
    }
}
