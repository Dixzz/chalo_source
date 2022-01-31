package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.products.ProductSelectionActivity;
import java.util.List;

/* renamed from: si0  reason: default package */
/* compiled from: AlertsViewAdapter */
public class si0 extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3215a;
    public final List<re1> b;

    /* renamed from: si0$a */
    /* compiled from: AlertsViewAdapter */
    public class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final na1 f3216a;
        public String b;

        /* renamed from: si0$a$a  reason: collision with other inner class name */
        /* compiled from: AlertsViewAdapter */
        public class View$OnClickListenerC0052a implements View.OnClickListener {
            public View$OnClickListenerC0052a(si0 si0) {
            }

            public void onClick(View view) {
                if (a.this.b != null) {
                    Intent intent = new Intent(si0.this.f3215a, ProductSelectionActivity.class);
                    intent.putExtra("src", "deeplink product");
                    intent.putExtra("extraTargetConfigId", a.this.b);
                    intent.addFlags(536870912);
                    si0.this.f3215a.startActivity(intent);
                }
            }
        }

        public a(na1 na1) {
            super(na1);
            this.f3216a = na1;
            na1.setOnClickListener(new View$OnClickListenerC0052a(si0.this));
        }
    }

    public si0(Activity activity, List<re1> list) {
        this.b = list;
        this.f3215a = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.b.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        re1 re1 = this.b.get(i);
        aVar2.f3216a.setAlertInfo(re1);
        aVar2.b = re1.p;
        re1.k = true;
        xt.f3961a.F().a(re1);
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(new na1(this.f3215a));
    }
}
