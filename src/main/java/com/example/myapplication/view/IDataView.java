package com.example.myapplication.view;

import java.util.List;

/**
 * Created by cqian on 2018/3/11.
 */

public interface IDataView {
    /**
     * 显示数据
     * @param data
     */
    void showData(List<String> data);

    /**
     * 显示加载进度条
     */
    void showLoadding();
}
