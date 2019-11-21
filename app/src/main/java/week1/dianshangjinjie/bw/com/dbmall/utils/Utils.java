package week1.dianshangjinjie.bw.com.dbmall.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import week1.dianshangjinjie.bw.com.dbmall.apis.Api;


public class Utils {

    private static  Utils utils;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private Utils(){
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();

        retrofit  = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public static Utils getInstance(){
        if (utils == null){
            synchronized (Utils.class){
                if (utils ==null){
                    utils = new Utils();
                }
            }
        }
        return utils;
    }

    public <T> T inService(Class<T> clz){
        return  retrofit.create(clz);
    }
}
