package week1.dianshangjinjie.bw.com.dbmall.coustm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import week1.dianshangjinjie.bw.com.dbmall.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/13
 * 描述：TODO
 * 最近修改：2019/11/13 10:35 modify by liujc
 */
public class MyView extends LinearLayout {

    public EditText edit_query;
    public Button btn_qurey;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
       View view =  LayoutInflater.from(context).inflate(R.layout.my_view_layout,this);
        edit_query = view.findViewById(R.id.edit_query);
        btn_qurey = view.findViewById(R.id.btn_qurey);
        String name = edit_query.getText().toString();
        btn_qurey.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.getData();
            }
        });
    }

    callBack callBack;
    public void  MyBack(callBack callBack){
        this.callBack = callBack;
    }


    //接口回调
    public  interface callBack{
        void getData(

        );
    }
}
