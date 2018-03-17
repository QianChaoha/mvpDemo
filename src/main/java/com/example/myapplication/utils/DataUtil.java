package com.example.myapplication.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqian on 2018/3/11.
 */

public class DataUtil {
    public List getData(int i){
        List list=new ArrayList();
        for (int j = 0; j < i; j++) {
            list.add(j+"");
        }
        return list;
    }
}
