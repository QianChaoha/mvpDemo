package com.example.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.adapter.MyAdpter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.presenter.DataPresenterV1;
import com.example.myapplication.utils.DataUtil;
import com.example.myapplication.view.IDataView;

import java.util.List;

//1.因为MVP中Activity代表了View,所以需要实现View的接口
public class MainActivity extends BaseActivity<IDataView,DataPresenterV1<IDataView>> implements IDataView {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataUtil dataUtil = new DataUtil();
        listView = (ListView) findViewById(R.id.listView);


        //2.MVP中View和Presenter之间需要互相引用
        //让中间者去加载数据
//        new DataPresenterV1(this).bind();


        //presenterV1=new DataPresenterV1();
        //presenterV1.attachView(this);

        presenter.bind();
    }

    @Override
    public void showData(List<String> data) {
        listView.setAdapter(new MyAdpter(data, this));
    }

    @Override
    public void showLoadding() {
        showToast("正在拼命加载数据中...");
    }
    @SuppressLint("WrongConstant")
    public void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        presenterV1.detachView();
//    }

    @Override
    public DataPresenterV1<IDataView> createPresenter() {
        return new DataPresenterV1();
    }
}
