package week1.dianshangjinjie.bw.com.dbmall.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.adapter.HomeProAdapter;
import week1.dianshangjinjie.bw.com.dbmall.adapter.MlssProAdapter;
import week1.dianshangjinjie.bw.com.dbmall.adapter.PzshProAdapter;
import week1.dianshangjinjie.bw.com.dbmall.base.BasePresenter;
import week1.dianshangjinjie.bw.com.dbmall.base.mvp.BaseFragmet;
import week1.dianshangjinjie.bw.com.dbmall.base.mvp.BasePresenterFragment;
import week1.dianshangjinjie.bw.com.dbmall.contract.usercontract.Icontract;
import week1.dianshangjinjie.bw.com.dbmall.coustm.MyView;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.banner.Banener;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.Product;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.Login;
import week1.dianshangjinjie.bw.com.dbmall.presenter.FragmentPresenter;
import week1.dianshangjinjie.bw.com.dbmall.presenter.Presenter;
import week1.dianshangjinjie.bw.com.dbmall.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/13
 * 描述：TODO
 * 最近修改：2019/11/13 10:26 modify by liujc
 */
public class HomeFragment extends BaseFragmet implements Icontract.IHomeBanne {


    private XBanner my_banner;
    private FragmentPresenter presenter;
    private RecyclerView recyclerView1,recyclerView2,recyclerView3;

    @Override
    protected void initDataResult() {

    }

    @Override
    protected BasePresenterFragment Ipresenter() {
        presenter= new FragmentPresenter();
        presenter.getBanner();
        presenter.getProducts();
        return presenter;
    }


    @Override
    protected int initLayout() {
        return R.layout.home_layout;
    }

    @Override
    protected void initView(View view) {
        my_banner = view.findViewById(R.id.my_banner);
        recyclerView1 = view.findViewById(R.id.RecyclerView1);
        recyclerView2 = view.findViewById(R.id.RecyclerView2);
        recyclerView3 = view.findViewById(R.id.RecyclerView3);


    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        LinearLayoutManager manager = new LinearLayoutManager(App.context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(manager);

        LinearLayoutManager manager1 = new LinearLayoutManager(App.context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(manager1);


        LinearLayoutManager manager2 = new LinearLayoutManager(App.context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView3.setLayoutManager(manager2);
    }


    @Override
    public void getBnaner(Banener banener) {
        List<String> list = new ArrayList<>();
        List<Banener.ResultBean> result = banener.getResult();
        for (int i = 0; i <result.size() ; i++) {
            list.add(result.get(i).getImageUrl());
        }
        my_banner.setData(result,null);
        my_banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(result.get(position).getImageUrl()).into((ImageView) view);
            }
        });

    }

    @Override
    public void getShou(Product product) {
        Product.ResultBean result = product.getResult();
        List<Product.ResultBean.RxxpBean.CommodityListBean> commodityList = result.getRxxp().getCommodityList();
        recyclerView1.setAdapter(new HomeProAdapter(App.context,commodityList));
        List<Product.ResultBean.MlssBean.CommodityListBeanXX> commodityList1 = result.getMlss().getCommodityList();
        recyclerView2.setAdapter(new MlssProAdapter(App.context,commodityList1));
        List<Product.ResultBean.PzshBean.CommodityListBeanX> commodityList2 = result.getPzsh().getCommodityList();
        recyclerView3.setAdapter(new PzshProAdapter(App.context,commodityList2));
    }

}
