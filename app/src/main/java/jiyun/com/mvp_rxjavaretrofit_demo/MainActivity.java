package jiyun.com.mvp_rxjavaretrofit_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.mvp_rxjavaretrofit_demo.di.DaggerTestCompent;
import jiyun.com.mvp_rxjavaretrofit_demo.di.TestCompent;
import jiyun.com.mvp_rxjavaretrofit_demo.di.TestModule;
import jiyun.com.mvp_rxjavaretrofit_demo.presenter.LoginPreImpl;
import jiyun.com.mvp_rxjavaretrofit_demo.view.LoginView;
import jiyun.com.mvp_rxjavaretrofit_demo.view.NewsActivity;

public class MainActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.edit_name)
    EditText editName;
    @Bind(R.id.edit_pwd)
    EditText editPwd;
    @Bind(R.id.edit_but)
    Button editBut;
    @Inject
    LoginPreImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        TestCompent build = DaggerTestCompent.builder().testModule(new TestModule(this)).build();

        build.injust(this);


    }

    @Override
    public String userName() {
        return editName.getText().toString().trim();
    }

    @Override
    public String pwd() {
        return editPwd.getText().toString().trim();
    }

    @OnClick(R.id.edit_but)
    public void onViewClicked() {
        presenter.Login(userName(), pwd());
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
}
