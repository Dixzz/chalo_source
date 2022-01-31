package defpackage;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.fl;
import defpackage.zj;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: yj  reason: default package */
/* compiled from: ConcatAdapter */
public final class yj extends RecyclerView.e<RecyclerView.a0> {

    /* renamed from: a  reason: collision with root package name */
    public final zj f4053a;

    /* renamed from: yj$a */
    /* compiled from: ConcatAdapter */
    public static final class a {
        public static final a b = new a(true, EnumC0068a.NO_STABLE_IDS);

        /* renamed from: a  reason: collision with root package name */
        public final EnumC0068a f4054a;

        /* renamed from: yj$a$a  reason: collision with other inner class name */
        /* compiled from: ConcatAdapter */
        public enum EnumC0068a {
            NO_STABLE_IDS,
            ISOLATED_STABLE_IDS,
            SHARED_STABLE_IDS
        }

        public a(boolean z, EnumC0068a aVar) {
            this.f4054a = aVar;
        }
    }

    @SafeVarargs
    public yj(RecyclerView.e<? extends RecyclerView.a0>... eVarArr) {
        zj zjVar;
        int size;
        qk qkVar;
        a aVar = a.b;
        List asList = Arrays.asList(eVarArr);
        this.f4053a = new zj(this, aVar);
        Iterator it = asList.iterator();
        while (true) {
            boolean z = true;
            int i = 0;
            if (it.hasNext()) {
                RecyclerView.e<RecyclerView.a0> eVar = (RecyclerView.e) it.next();
                zjVar = this.f4053a;
                size = zjVar.e.size();
                if (size < 0 || size > zjVar.e.size()) {
                    StringBuilder i0 = hj1.i0("Index must be between 0 and ");
                    i0.append(zjVar.e.size());
                    i0.append(". Given:");
                    i0.append(size);
                } else {
                    if (zjVar.g == a.EnumC0068a.NO_STABLE_IDS ? false : z) {
                        h.m(eVar.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
                    } else {
                        eVar.hasStableIds();
                    }
                    int size2 = zjVar.e.size();
                    while (true) {
                        if (i >= size2) {
                            i = -1;
                            break;
                        } else if (zjVar.e.get(i).c == eVar) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i == -1) {
                        qkVar = null;
                    } else {
                        qkVar = zjVar.e.get(i);
                    }
                    if (qkVar == null) {
                        qk qkVar2 = new qk(eVar, zjVar, zjVar.b, zjVar.h.a());
                        zjVar.e.add(size, qkVar2);
                        for (WeakReference<RecyclerView> weakReference : zjVar.c) {
                            RecyclerView recyclerView = weakReference.get();
                            if (recyclerView != null) {
                                eVar.onAttachedToRecyclerView(recyclerView);
                            }
                        }
                        if (qkVar2.e > 0) {
                            zjVar.f4179a.notifyItemRangeInserted(zjVar.b(qkVar2), qkVar2.e);
                        }
                        zjVar.a();
                    }
                }
            } else {
                super.setHasStableIds(this.f4053a.g == a.EnumC0068a.NO_STABLE_IDS ? false : z);
                return;
            }
        }
        StringBuilder i02 = hj1.i0("Index must be between 0 and ");
        i02.append(zjVar.e.size());
        i02.append(". Given:");
        i02.append(size);
        throw new IndexOutOfBoundsException(i02.toString());
    }

    public void c(RecyclerView.e.a aVar) {
        super.setStateRestorationPolicy(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int findRelativeAdapterPositionIn(RecyclerView.e<? extends RecyclerView.a0> eVar, RecyclerView.a0 a0Var, int i) {
        zj zjVar = this.f4053a;
        qk qkVar = zjVar.d.get(a0Var);
        if (qkVar == null) {
            return -1;
        }
        int b = i - zjVar.b(qkVar);
        int itemCount = qkVar.c.getItemCount();
        if (b >= 0 && b < itemCount) {
            return qkVar.c.findRelativeAdapterPositionIn(eVar, a0Var, b);
        }
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + b + " which is out of bounds for the adapter with size " + itemCount + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + a0Var + "adapter:" + eVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        int i = 0;
        for (qk qkVar : this.f4053a.e) {
            i += qkVar.e;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long getItemId(int i) {
        zj zjVar = this.f4053a;
        zj.a c = zjVar.c(i);
        qk qkVar = c.f4180a;
        long a2 = qkVar.b.a(qkVar.c.getItemId(c.b));
        zjVar.e(c);
        return a2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemViewType(int i) {
        zj zjVar = this.f4053a;
        zj.a c = zjVar.c(i);
        qk qkVar = c.f4180a;
        int b = qkVar.f2948a.b(qkVar.c.getItemViewType(c.b));
        zjVar.e(c);
        return b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        boolean z;
        zj zjVar = this.f4053a;
        Iterator<WeakReference<RecyclerView>> it = zjVar.c.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().get() == recyclerView) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            zjVar.c.add(new WeakReference<>(recyclerView));
            for (qk qkVar : zjVar.e) {
                qkVar.c.onAttachedToRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        zj zjVar = this.f4053a;
        zj.a c = zjVar.c(i);
        zjVar.d.put(a0Var, c.f4180a);
        qk qkVar = c.f4180a;
        qkVar.c.bindViewHolder(a0Var, c.b);
        zjVar.e(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        qk qkVar = ((fl.a) this.f4053a.b).f1136a.get(i);
        if (qkVar != null) {
            return qkVar.c.onCreateViewHolder(viewGroup, qkVar.f2948a.a(i));
        }
        throw new IllegalArgumentException(hj1.I("Cannot find the wrapper for global view type ", i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        zj zjVar = this.f4053a;
        int size = zjVar.c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            WeakReference<RecyclerView> weakReference = zjVar.c.get(size);
            if (weakReference.get() == null) {
                zjVar.c.remove(size);
            } else if (weakReference.get() == recyclerView) {
                zjVar.c.remove(size);
                break;
            }
        }
        for (qk qkVar : zjVar.e) {
            qkVar.c.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean onFailedToRecycleView(RecyclerView.a0 a0Var) {
        zj zjVar = this.f4053a;
        qk qkVar = zjVar.d.get(a0Var);
        if (qkVar != null) {
            boolean onFailedToRecycleView = qkVar.c.onFailedToRecycleView(a0Var);
            zjVar.d.remove(a0Var);
            return onFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + a0Var + ", seems like it is not bound by this adapter: " + zjVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onViewAttachedToWindow(RecyclerView.a0 a0Var) {
        this.f4053a.d(a0Var).c.onViewAttachedToWindow(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onViewDetachedFromWindow(RecyclerView.a0 a0Var) {
        this.f4053a.d(a0Var).c.onViewDetachedFromWindow(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onViewRecycled(RecyclerView.a0 a0Var) {
        zj zjVar = this.f4053a;
        qk qkVar = zjVar.d.get(a0Var);
        if (qkVar != null) {
            qkVar.c.onViewRecycled(a0Var);
            zjVar.d.remove(a0Var);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + a0Var + ", seems like it is not bound by this adapter: " + zjVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void setStateRestorationPolicy(RecyclerView.e.a aVar) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }
}
