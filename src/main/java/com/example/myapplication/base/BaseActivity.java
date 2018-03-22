package com.example.myapplication.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.myapplication.view.IDataView;

/**
 * Created by cqian on 2018/3/17.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends Activity {
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public abstract T createPresenter();
}
