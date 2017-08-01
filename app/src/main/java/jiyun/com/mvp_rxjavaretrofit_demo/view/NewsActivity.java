package jiyun.com.mvp_rxjavaretrofit_demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import jiyun.com.mvp_rxjavaretrofit_demo.R;
import jiyun.com.mvp_rxjavaretrofit_demo.presenter.NewsPresenter;
import jiyun.com.mvp_rxjavaretrofit_demo.presenter.NewsPresenterImpl;


/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/18 9:02
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class NewsActivity extends AppCompatActivity implements NewsView, OnClickListener {
    private NewsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        presenter = new NewsPresenterImpl(this);
        findViewById(R.id.News_But).setOnClickListener(this);
    }

    @Override
    public void TooastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        presenter.News();
    }
}
