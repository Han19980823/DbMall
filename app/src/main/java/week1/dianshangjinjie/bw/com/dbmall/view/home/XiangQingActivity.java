package week1.dianshangjinjie.bw.com.dbmall.view.home;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.apis.XiangQingSerVice;
import week1.dianshangjinjie.bw.com.dbmall.base.BaseActivity;
import week1.dianshangjinjie.bw.com.dbmall.base.BasePresenter;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.XQentity;
import week1.dianshangjinjie.bw.com.dbmall.presenter.Presenter;
import week1.dianshangjinjie.bw.com.dbmall.utils.Utils;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class XiangQingActivity extends BaseActivity {


    private WebView web_view;
    private XQentity.ResultBean result;
    @Override
    protected void initData() {
        web_view.getSettings().setJavaScriptEnabled(true);
        Utils.getInstance().inService(XiangQingSerVice.class)
                .xiangqing(6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XQentity>() {



                    @Override
                    public void accept(XQentity xQentity) throws Exception {
                        result = xQentity.getResult();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        if (result!=null){
            String details = result.getDetails();
            web_view.loadData(details,"text/html,utf-8",null);
        }
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        return presenter;
    }

    @Override
    protected void initView() {
        web_view = findViewById(R.id.web_view);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_xiang_qing;
    }
}
