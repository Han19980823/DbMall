package week1.dianshangjinjie.bw.com.dbmall.apis;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.XQentity;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 09:05 modify by liujc
 */
public interface XiangQingSerVice {

    @GET("small/commodity/v1/findCommodityDetailsById")
    Observable<XQentity> xiangqing(@Query("commodityId") int id);
}
