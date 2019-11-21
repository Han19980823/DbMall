package week1.dianshangjinjie.bw.com.dbmall.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.adapter.CarAdapter;
import week1.dianshangjinjie.bw.com.dbmall.base.mvp.BaseFragmet;
import week1.dianshangjinjie.bw.com.dbmall.base.mvp.BasePresenterFragment;
import week1.dianshangjinjie.bw.com.dbmall.contract.usercontract.Icontract;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.CarBean;
import week1.dianshangjinjie.bw.com.dbmall.presenter.FragmentPresenter;

/**
 * 作者：Han98
 * 创建时间：2019/11/20
 * 描述：TODO
 * 最近修改：2019/11/20 08:53 modify by liujc
 */
public class CarFragment extends BaseFragmet implements Icontract.Icar {
    @BindView(R.id.recy_layout)
    RecyclerView recy_layout;



    @Override
    protected void initDataResult() {

    }

    @Override
    protected BasePresenterFragment Ipresenter() {
        FragmentPresenter presenter = new FragmentPresenter();
        presenter.getModel();
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.car_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void getCars(CarBean carBean) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_layout.setLayoutManager(manager);
        Toast.makeText(getContext(), carBean.getMessage(), Toast.LENGTH_SHORT).show();

        List<CarBean.ResultBean> result = carBean.getResult();

        recy_layout.setAdapter(new CarAdapter(getContext(),result));

    }
}
