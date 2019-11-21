package week1.dianshangjinjie.bw.com.dbmall.view.regist_login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.base.BaseActivity;
import week1.dianshangjinjie.bw.com.dbmall.base.BasePresenter;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.Login;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.LoginBean;
import week1.dianshangjinjie.bw.com.dbmall.presenter.Presenter;
import week1.dianshangjinjie.bw.com.dbmall.view.HomeActivity;

public class LonginActivity extends BaseActivity {


    @BindView(R.id.shouji)
    EditText shouji;
    @BindView(R.id.mima)
    EditText mima;
    @BindView(R.id.button_deng)
    Button btn_deng;
    @BindView(R.id.jizhumima)
    TextView jizhumima;
    @BindView(R.id.kuaisu)
    TextView kuaisu;
    private Presenter presenter;
    private String name;
    private String pwd;

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        return presenter;
    }

    @Override
    protected void initView() {

    }

    //接收eventBus传值
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onData(Login login) {
        Log.d("aaa", "" + login.getName());
        name = login.getName();
        pwd = login.getPwd();
        shouji.setText(name);
        mima.setText(pwd);

    }

    @OnClick(R.id.kuaisu)
    public void tiao(View view){
        Intent intent = new Intent(LonginActivity.this,RegistActivity.class);
        startActivity(intent);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_longin;
    }

    //点击登录跳转首页
    @OnClick(R.id.button_deng)
    public void btn_deng(View view) {
        presenter.getUser(name,pwd);
        Intent intent = new Intent(LonginActivity.this,HomeActivity.class);
        startActivity(intent);
    }




    public void getData(LoginBean loginBean){

        Log.e("aaa", "getData: "+loginBean.getMessage() );
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        // 移除粘性事件
//        EventBus.getDefault().removeStickyEvent(login);
    }

}
