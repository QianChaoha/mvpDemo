package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cqian on 2018/3/11.
 */

public class MyAdpter extends BaseAdapter {
    private List<String> arr;
    private Context context;

    public MyAdpter(List<String> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView=new TextView(context);
        textView.setText(arr.get(i));
        textView.setPadding(30,10,10,10);
        return textView;
    }
}
