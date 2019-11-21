package week1.dianshangjinjie.bw.com.mvp.base;

/**
 * 作者：Han98
 * 创建时间：2019/11/13
 * 描述：TODO
 * 最近修改：2019/11/13 14:19 modify by liujc
 */
public class BasePresetner<V extends BaseActivity> {

    public V v;

    public void attach(V v){
        if ( v !=null){
          this.v = v;
        }
    }
    public void Unattach(){
        if ( v !=null){
            v = null;
        }
    }
}
