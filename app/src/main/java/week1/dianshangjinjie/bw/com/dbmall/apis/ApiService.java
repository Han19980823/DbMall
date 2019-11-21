package week1.dianshangjinjie.bw.com.dbmall.apis;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.SouSuo;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.banner.Banener;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.LoginBean;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.user.UserRegsitBean;


public interface ApiService {
    //注册
    @POST("small/user/v1/register")
    @FormUrlEncoded
    Observable<UserRegsitBean> service(@Field("phone") String phone,@Field("pwd") String pwd);
    //登录
    @POST("small/user/v1/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("phone") String phone,@Field("pwd") String pwd);
    @GET("small/commodity/v1/bannerShow")
    Observable<Banener> banner();
    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<SouSuo> sousuo(@Field("keyword") String name,@Field("page") int page,@Field("count") int count);

}
