package ok.feiyu.ecollect.page.tenantList;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ok.feiyu.ecollect.BaseActivity;
import ok.feiyu.ecollect.BasePresenter;
import ok.feiyu.ecollect.R;

interface ITenantList {
    boolean onDataLoadSuccess();
}

public class TenantPickActivity extends BaseActivity implements ITenantList{

    RecyclerView mRecyclerView;
    TenantPickPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_pick);
        initHeader();
        mRecyclerView = findViewById(R.id.list_tenant_RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initHeader() {
        Toolbar header = findViewById(R.id.tenant_list_header);
        header.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadData();
    }

    @Override
    public boolean onDataLoadSuccess() {
        mRecyclerView.setAdapter(new TenantListAdapter(mPresenter.getTenantList()));
        return true;
    }

    @Override
    protected BasePresenter createPresenter() {
        mPresenter = new TenantPickPresenter(new TenantModel((TenantPickPresenter) getPresenter()));
        return mPresenter;
    }
}
