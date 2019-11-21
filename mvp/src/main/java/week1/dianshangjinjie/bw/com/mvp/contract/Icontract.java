package week1.dianshangjinjie.bw.com.mvp.contract;

import week1.dianshangjinjie.bw.com.mvp.base.BasePresetner;

/**
 * 作者：Han98
 * 创建时间：2019/11/13
 * 描述：TODO
 * 最近修改：2019/11/13 13:51 modify by liujc
 */
public interface Icontract {

    //v层
    public interface Iview{
        void getView();
    }
    //p层
    public abstract  class Ipresenter extends BasePresetner {
        public abstract void getPresenter();
    }



    //m层
    public interface Imodel{
        void getModel();
    }
}
