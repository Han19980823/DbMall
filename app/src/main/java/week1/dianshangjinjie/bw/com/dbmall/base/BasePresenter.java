package week1.dianshangjinjie.bw.com.dbmall.base;

import android.view.View;

import java.lang.ref.WeakReference;

import androidx.fragment.app.Fragment;
import week1.dianshangjinjie.bw.com.dbmall.base.BaseActivity;


public class BasePresenter<V extends BaseActivity> {

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
