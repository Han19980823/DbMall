package week1.dianshangjinjie.bw.com.dbmall.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.apis.Api;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.Product;
import week1.dianshangjinjie.bw.com.dbmall.view.App;
import week1.dianshangjinjie.bw.com.dbmall.view.home.XiangQingActivity;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 13:43 modify by liujc
 */
public class HomeProAdapter extends RecyclerView.Adapter<HomeProAdapter.Rxxp> {
    Context context;
    List<Product.ResultBean.RxxpBean.CommodityListBean> commodityList;

    public HomeProAdapter(Context context, List<Product.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public Rxxp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shou, null);
        return new Rxxp(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Rxxp holder, int position) {
        holder.text_name.setText(commodityList.get(position).getCommodityName());
        Glide.with(context).load(commodityList.get(position).getMasterPic()).into(holder.img_view);
        holder.layout_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangQingActivity.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    class Rxxp extends RecyclerView.ViewHolder{

       ImageView img_view;
      TextView text_name;
      LinearLayout layout_id;

        public Rxxp(@NonNull View itemView) {
            super(itemView);
            img_view = itemView.findViewById(R.id.img_view);
            text_name = itemView.findViewById(R.id.text_name);

            layout_id = itemView.findViewById(R.id.layout_id);
        }
    }
}
