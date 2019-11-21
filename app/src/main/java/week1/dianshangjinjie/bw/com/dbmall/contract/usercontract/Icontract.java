package week1.dianshangjinjie.bw.com.dbmall.contract.usercontract;

import android.graphics.drawable.Icon;

import com.xuezj.cardbanner.CardBanner;

import week1.dianshangjinjie.bw.com.dbmall.enemty.user.CarBean;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.SouSuo;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.banner.Banener;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.Product;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.XQentity;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.LoginBean;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.UserRegsitBean;


public interface Icontract {

    interface getUser {
        void getRegist(UserRegsitBean regsit);

        void getLogin(LoginBean login);

        void errors(String er);
    }

    interface getModel {
        void getUser(String phone, String pwd);
    }


    interface callBack {
        void getUser(String phone, String pwd, Icontract.getUser getHome);

        void getBannerX( Icontract.getBanner11 getHome);

        void getProduvt(Icontract.getShop getShop);
        void getXiangQing(Icontract.getPing getPing);
    }
    interface  getPing{
        void getData(XQentity xQentity);
    }
    interface getShop{
        void getSnagp(Product product);
    }

    interface getBanner11 {
        void getBanner1(Banener banener);
    }

    interface Iview {
        void success(UserRegsitBean userRegsitBean);
    }

    interface IHomeBanne{
        void getBnaner(Banener banener);
        void  getShou(Product product);

    }

    interface IModel{
        void getCars(CarBean carBean);
    }

    interface Icar{
        void getCars(CarBean carBean);
    }

}
