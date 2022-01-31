package defpackage;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import app.zophop.utilities.R;

/* renamed from: uf1  reason: default package */
/* compiled from: BasePickLocationActivity */
public abstract class uf1 extends vf1 {

    /* renamed from: uf1$a */
    /* compiled from: BasePickLocationActivity */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            intent.putExtra("result:picked_location", ((mf1) uf1.this.k.getAdapter().getItem(i)).b());
            uf1.this.setResult(-1, intent);
            uf1.this.finish();
        }
    }

    @Override // defpackage.vf1
    public AdapterView.OnItemClickListener j0() {
        return new a();
    }

    public void onEvent(nd1 nd1) {
        if (!p0()) {
            if (nd1.f2540a.equals(ad1.SUCCESS)) {
                Toast.makeText(this, getString(R.string.favorite_updated_toast), 1).show();
            } else {
                Toast.makeText(this, getString(R.string.favorite_network_error_toast), 1).show();
            }
            q0();
            jz5.b().m(nd1);
        }
    }

    public boolean p0() {
        return getIntent().hasExtra("home_or_work");
    }

    public void q0() {
        this.k.getAdapter();
    }
}
