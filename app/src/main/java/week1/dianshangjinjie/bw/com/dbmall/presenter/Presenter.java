package week1.dianshangjinjie.bw.com.dbmall.presenter;

import week1.dianshangjinjie.bw.com.dbmall.base.BasePresenter;
import week1.dianshangjinjie.bw.com.dbmall.contract.usercontract.Icontract;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.SouSuo;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.banner.Banener;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.LoginBean;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.UserRegsitBean;
import week1.dianshangjinjie.bw.com.dbmall.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.dbmall.model.Model;
import week1.dianshangjinjie.bw.com.dbmall.view.regist_login.LonginActivity;
import week1.dianshangjinjie.bw.com.dbmall.view.regist_login.RegistActivity;


public class Presenter extends BasePresenter implements Icontract.getModel {
    Model model;

    public Presenter() {
        model = new Model();

    }


    @Override
    public void getUser(String phone, String pwd) {
        model.getUser(phone, pwd, new Icontract.getUser() {
            @Override
            public void getRegist(UserRegsitBean regsit) {
                RegistActivity activity = (RegistActivity) v;
                activity.success(regsit);
            }

            @Override
            public void getLogin(LoginBean login) {
                LonginActivity activity = (LonginActivity) v;
                activity.getData(login);
            }

            @Override
            public void errors(String er) {

            }
        });
    }




}

