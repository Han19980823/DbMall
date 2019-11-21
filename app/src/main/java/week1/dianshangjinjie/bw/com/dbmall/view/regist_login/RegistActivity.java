package week1.dianshangjinjie.bw.com.dbmall.view.regist_login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.base.BaseActivity;
import week1.dianshangjinjie.bw.com.dbmall.base.BasePresenter;
import week1.dianshangjinjie.bw.com.dbmall.contract.usercontract.Icontract;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.Login;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.UserRegsitBean;
import week1.dianshangjinjie.bw.com.dbmall.presenter.Presenter;

public class RegistActivity extends BaseActivity implements Icontract.Iview {

    @BindView(R.id.shouji)
    EditText shouji;
    @BindView(R.id.mima)
    EditText mima;
    @BindView(R.id.button_register)
    Button button;
    private String pwd;
    private String phone;
    private Presenter presenter;
    @Override
    protected void initView() {
    }


    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        return presenter;

    }

    @Override
    protected void initData() {

    }


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.button_register)
    public  void initOnclick(View view){
        pwd = mima.getText().toString();
        phone = shouji.getText().toString();
        presenter.getUser(phone,pwd);
            Intent intent = new Intent(RegistActivity.this, LonginActivity.class);
            startActivity(intent);
            Login login = new Login();
            login.setName(phone);
            login.setPwd(pwd);
            EventBus.getDefault().postSticky(login);


    }

    @Override
    public void success(UserRegsitBean userRegsitBean) {
        Log.e("aaa", "Regist: "+userRegsitBean.getMessage() );
    }
}
