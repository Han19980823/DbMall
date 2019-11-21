package week1.dianshangjinjie.bw.com.dbmall.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{
        public  P p;
        public Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        unbinder = ButterKnife.bind(this);
        p=Ipresenter();
        if (p!=null){
            p.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();
    protected abstract P Ipresenter();

    protected abstract void initView();


    protected abstract int initLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p = null;
            unbinder.unbind();
        }
    }
}


