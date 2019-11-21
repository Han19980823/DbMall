package week1.dianshangjinjie.bw.com.dbmall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.dbmall.R;
import week1.dianshangjinjie.bw.com.dbmall.enemty.user.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 09:03 modify by liujc
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.Holder> {
    Context context;
    List<CarBean.ResultBean> result;

    public CarAdapter(Context context, List<CarBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    };

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_itrm
                , parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.text_name.setText(result.get(position).getCategoryName());

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_name)
        TextView text_name;
        @BindView(R.id.recy)
        RecyclerView recyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
