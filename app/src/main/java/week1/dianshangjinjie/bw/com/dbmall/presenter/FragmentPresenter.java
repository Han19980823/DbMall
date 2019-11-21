package week1.dianshangjinjie.bw.com.dbmall.presenter;

import week1.dianshangjinjie.bw.com.dbmall.apis.ApiService;
import week1.dianshangjinjie.bw.com.dbmall.base.mvp.BasePresenterFragment;
import week1.dianshangjinjie.bw.com.dbmall.contract.usercontract.Icontract;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.CarBean;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.banner.Banener;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.Product;
import week1.dianshangjinjie.bw.com.dbmall.fragment.CarFragment;
import week1.dianshangjinjie.bw.com.dbmall.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.dbmall.model.Model;
import week1.dianshangjinjie.bw.com.dbmall.utils.Utils;

/**
 * 作者：Han98
 * 创建时间：2019/11/13
 * 描述：TODO
 * 最近修改：2019/11/13 20:33 modify by liujc
 */
public class FragmentPresenter extends BasePresenterFragment {
    Model model;

    public FragmentPresenter() {
      model = new Model();
    }

    public void getBanner(){
       model.getBannerX(new Icontract.getBanner11() {
           @Override
           public void getBanner1(Banener banener) {
               HomeFragment fragment = (HomeFragment) v;
               fragment.getBnaner(banener);
           }
       });
    }

    public void getProducts(){
        model.getProduvt(new Icontract.getShop() {
            @Override
            public void getSnagp(Product product) {
                HomeFragment fragment = (HomeFragment) v;
                fragment.getShou(product);

            }
        });
    }


    public void getModel(){
        model.getCar(new Icontract.IModel() {
            @Override
            public void getCars(CarBean carBean) {
                CarFragment fragment = (CarFragment) v;
                fragment.getCars(carBean);
            }
        });
    }
}
