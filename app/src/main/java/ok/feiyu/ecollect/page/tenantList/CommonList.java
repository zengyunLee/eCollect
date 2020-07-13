package ok.feiyu.ecollect.page.tenantList;

public interface CommonList<T> {
    void onItemPick(T bean);
    void loadData();
    void onLoadComplete();
}
