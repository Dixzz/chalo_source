package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: tj  reason: default package */
/* compiled from: AdapterListUpdateCallback */
public final class tj implements pk {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.e f3363a;

    public tj(RecyclerView.e eVar) {
        this.f3363a = eVar;
    }

    @Override // defpackage.pk
    public void onChanged(int i, int i2, Object obj) {
        this.f3363a.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // defpackage.pk
    public void onInserted(int i, int i2) {
        this.f3363a.notifyItemRangeInserted(i, i2);
    }

    @Override // defpackage.pk
    public void onMoved(int i, int i2) {
        this.f3363a.notifyItemMoved(i, i2);
    }

    @Override // defpackage.pk
    public void onRemoved(int i, int i2) {
        this.f3363a.notifyItemRangeRemoved(i, i2);
    }
}
