package ok.feiyu.ecollect.page.tenantList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ok.feiyu.ecollect.R;
import ok.feiyu.ecollect.network.bean.TenantInfoBean;

public class TenantListAdapter extends RecyclerView.Adapter<TenantListAdapter.MyViewHolder> {

    private List<TenantInfoBean.DataBean> mTenantList;

    TenantListAdapter(List<TenantInfoBean.DataBean> tenantList) {
        mTenantList = tenantList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tenant_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TenantInfoBean.DataBean tenant = mTenantList.get(position);
        holder.tenantName.setText(tenant.getTenantName());
    }

    @Override
    public int getItemCount() {
        if(mTenantList==null)
            return 0;
        return mTenantList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tenantName;
        public MyViewHolder(View view) {
            super(view);
            tenantName = view.findViewById(R.id.tenant_item_text);
        }
    }
}