package week1.dianshangjinjie.bw.com.dbmall.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

import butterknife.BindView;
import butterknife.OnClick;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.base.mvp.BaseFragmet;
import week1.dianshangjinjie.bw.com.dbmall.base.mvp.BasePresenterFragment;
import week1.dianshangjinjie.bw.com.dbmall.presenter.Presenter;

public class MyFragment extends BaseFragmet {


    private ImageView img_view_btn;
    private RelativeLayout relativeLayout;
    private Button creana;
    private Button canle;
    private Button photo;

    @Override
    protected void initDataResult() {

    }

    @Override
    protected BasePresenterFragment Ipresenter() {

        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.my_layout;
    }

    @Override
    protected void initView(View view) {
        img_view_btn = view.findViewById(R.id.img_view_btn);
        relativeLayout = view.findViewById(R.id.di_layout);
        creana = view.findViewById(R.id.creana);
        photo = view.findViewById(R.id.photo);
        canle = view.findViewById(R.id.canle);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        img_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.VISIBLE);
            }
        });
        creana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
                PictureSelector.create(getActivity()).openCamera(PictureMimeType.ofImage())
                        .maxSelectNum(2)
                        .compress(true)
                        .isCamera(true)
                        .minSelectNum(0)
                        .forResult(PictureConfig.CHOOSE_REQUEST);


            }
         });
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
                PictureSelector.create(getActivity()).openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(2)
                        .compress(true)
                        .isCamera(true)
                        .minSelectNum(0)
                        .forResult(PictureConfig.CHOOSE_REQUEST);


            }
        });
        canle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
            }
        });
    }
}
