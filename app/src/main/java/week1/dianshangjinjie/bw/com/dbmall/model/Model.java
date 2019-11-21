package week1.dianshangjinjie.bw.com.dbmall.model;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.dbmall.apis.CarService;
import week1.dianshangjinjie.bw.com.dbmall.apis.ProductSerVice;
import week1.dianshangjinjie.bw.com.dbmall.apis.XiangQingSerVice;
import week1.dianshangjinjie.bw.com.dbmall.contract.usercontract.Icontract;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.CarBean;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.SouSuo;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.banner.Banener;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.Product;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.XQentity;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.LoginBean;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.UserRegsitBean;
import week1.dianshangjinjie.bw.com.dbmall.apis.ApiService;
import week1.dianshangjinjie.bw.com.dbmall.utils.Utils;
import week1.dianshangjinjie.bw.com.dbmall.view.App;


public  class Model implements Icontract.callBack{


    @Override
    public void getUser(String phone, String pwd, Icontract.getUser getHome) {
        Utils.getInstance().inService(ApiService.class)
                .service(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserRegsitBean>() {
                    @Override
                    public void accept(UserRegsitBean userRegsitBean) throws Exception {
                        if (getHome != null) {
                            getHome.getRegist(userRegsitBean);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getHome.errors("网络有异常");
                    }
                });
        Utils.getInstance().inService(ApiService.class)
                .login(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean LoginBean) throws Exception {
                        if (getHome != null) {
                            getHome.getLogin(LoginBean);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getHome.errors("网络有异常");
                    }
                });
    }

    @Override
    public void getBannerX(Icontract.getBanner11 getHome) {
        Utils.getInstance().inService(ApiService.class).banner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Banener>() {
                    @Override
                    public void accept(Banener banener) throws Exception {
                        getHome.getBanner1(banener);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }

    @Override
    public void getProduvt(Icontract.getShop getShop) {
        Utils.getInstance().inService(ProductSerVice.class)
                .service()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Product>() {
                    @Override
                    public void accept(Product product) throws Exception {
                        getShop.getSnagp(product);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void getXiangQing(Icontract.getPing getPing) {

    }

    public void getCar(Icontract.IModel iModel){
        Utils.getInstance().inService(CarService.class)
                .car(10155,"157429737109610155")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarBean>() {
                    @Override
                    public void accept(CarBean carBean) throws Exception {
                        iModel.getCars(carBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
