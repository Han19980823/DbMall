package week1.dianshangjinjie.bw.com.dbmall.view;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

import retrofit2.http.GET;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.adapter.FragmentAdapter;
import week1.dianshangjinjie.bw.com.dbmall.base.BaseActivity;
import week1.dianshangjinjie.bw.com.dbmall.base.BasePresenter;
import week1.dianshangjinjie.bw.com.dbmall.fragment.CarFragment;
import week1.dianshangjinjie.bw.com.dbmall.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.dbmall.fragment.MyFragment;
import week1.dianshangjinjie.bw.com.dbmall.fragment.QuanFragment;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    private List<String> slist = new ArrayList<String>();
    private List<Fragment> flist = new ArrayList<>();

    @Override
    protected void initData() {
        slist.add("首页");
        slist.add("我的");
        slist.add("圈子");
        slist.add("购物车");
        flist.add(new HomeFragment());
        flist.add(new MyFragment());
        flist.add(new QuanFragment());
        flist.add(new CarFragment());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),slist,flist));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

}
