package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import app.zophop.models.TransitMode;
import com.google.gson.Gson;
import java.util.List;

/* renamed from: bf0  reason: default package */
/* compiled from: PickFilterableItemActivity */
public abstract class bf0<T> extends ee0 implements di1<T> {
    public static final /* synthetic */ int t = 0;
    public TransitMode s;

    /* renamed from: bf0$a */
    /* compiled from: PickFilterableItemActivity */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Gson gson = new Gson();
            bf0 bf0 = bf0.this;
            int i2 = bf0.t;
            String json = gson.toJson(bf0.k.getAdapter().getItem(i));
            Intent intent = new Intent();
            intent.putExtra("result_picked", json);
            bf0.this.setResult(-1, intent);
            bf0.this.finish();
        }
    }

    @Override // defpackage.vf1, defpackage.tf1
    public void e(Bundle bundle) {
        t0(getIntent());
        this.s = TransitMode.getTransitMode(getIntent().getStringExtra("mode"));
        super.e(bundle);
        if (xt.f3961a.A().j()) {
            this.o.setVisibility(8);
        }
        p0();
    }

    @Override // defpackage.vf1
    public ListAdapter i0() {
        return null;
    }

    @Override // defpackage.vf1
    public AdapterView.OnItemClickListener j0() {
        return new a();
    }

    @Override // defpackage.vf1
    public void l0(boolean z) {
        if (xt.f3961a.A().j()) {
            this.o.setVisibility(8);
        } else {
            super.l0(z);
        }
    }

    /* renamed from: r0 */
    public ij0 h0() {
        return new ij0(this, s0(), this, this.s, new de0(this));
    }

    public abstract List<T> s0();

    public abstract void t0(Intent intent);
}
