package week1.dianshangjinjie.bw.com.dbmall.base.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import week1.dianshangjinjie.bw.com.dbmall.base.BasePresenter;

/**
 * 作者：Han98
 * 创建时间：2019/11/13
 * 描述：TODO
 * 最近修改：2019/11/13 13:43 modify by liujc
 */
public  abstract class BaseFragmet<P extends BasePresenterFragment> extends Fragment {
    public  P p;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = Ipresenter();
        if (p!=null){
            p.attach(this);
        }

        initDataResult();
    }

    protected abstract void initDataResult();

    protected abstract P Ipresenter();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(initLayout(),container,false);
    }

    protected abstract int initLayout();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);

    }

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解绑
        if (p !=null){
            p.Unattach();
            p=null;
        }
    }

}
