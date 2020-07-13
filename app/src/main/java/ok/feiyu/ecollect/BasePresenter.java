package ok.feiyu.ecollect;

import java.lang.ref.WeakReference;

public class BasePresenter<V> {
    protected WeakReference weakReference;
    /**
     * 将传入的View接口实例，通过弱引用（WeakReference）把Presenter与View进行绑定。
     * @param v  界面更新接口实例
     */
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }

    /**
     *  将Presenter与View进行解绑，并释放内存
     */
    public void detach() {
        if(weakReference!=null) {
            weakReference.clear();
            weakReference = null;
        }
    }
}
