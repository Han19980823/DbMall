package week1.dianshangjinjie.bw.com.dbmall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.home.Product;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 13:43 modify by liujc
 */
public class PzshProAdapter extends RecyclerView.Adapter<PzshProAdapter.Rxxp> {
    Context context;
    List<Product.ResultBean.PzshBean.CommodityListBeanX> commodityList2;

    public PzshProAdapter(Context context,  List<Product.ResultBean.PzshBean.CommodityListBeanX> commodityList2) {
        this.context = context;
        this.commodityList2 = commodityList2;
    }

    @NonNull
    @Override
    public Rxxp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pzsh, null);
        return new Rxxp(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Rxxp holder, int position) {
        holder.text_name.setText(commodityList2.get(position).getCommodityName());
        Glide.with(context).load(commodityList2.get(position).getMasterPic()).into(holder.img_view);
    }


    @Override
    public int getItemCount() {
        return commodityList2.size();
    }

    class Rxxp extends RecyclerView.ViewHolder{

       ImageView img_view;
      TextView text_name;

        public Rxxp(@NonNull View itemView) {
            super(itemView);
            img_view = itemView.findViewById(R.id.img_view);
            text_name = itemView.findViewById(R.id.text_name);
        }
    }
}
