package week1.dianshangjinjie.bw.com.dbmall.apis;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 08:47 modify by liujc
 */
public interface CarService {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CarBean> car(@Header("userId") int uid,@Header("sessionId") String sid);
}
