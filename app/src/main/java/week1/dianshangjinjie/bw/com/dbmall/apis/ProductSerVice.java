package week1.dianshangjinjie.bw.com.dbmall.apis;

import io.reactivex.Observable;
import retrofit2.http.GET;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.Product;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 13:36 modify by liujc
 */
public interface ProductSerVice {
    @GET("small/commodity/v1/commodityList")
    Observable<Product> service();
}
