package week1.dianshangjinjie.bw.com.dbmall.base.mvp;

/**
 * 作者：Han98
 * 创建时间：2019/11/13
 * 描述：TODO
 * 最近修改：2019/11/13 13:43 modify by liujc
 */
public class BasePresenterFragment<V extends BaseFragmet> {
    public V v;

    public void attach(V v){
        this.v = v;
    }
    public void Unattach(){
        if ( v !=null){
            v = null;

        }
    }

}
