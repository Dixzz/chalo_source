package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.AutoCabInfo;
import com.google.firebase.appindexing.Indexable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: vi0  reason: default package */
/* compiled from: CabTypePagerAdapter */
public class vi0 extends ro implements xf1 {
    public final Context c;
    public List<AutoCabInfo> d = new ArrayList();

    public vi0(Context context) {
        this.c = context;
    }

    @Override // defpackage.xf1
    public int a(int i, boolean z) {
        return 0;
    }

    @Override // defpackage.ro
    public void b(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // defpackage.ro
    public int d() {
        return this.d.size();
    }

    @Override // defpackage.ro
    public CharSequence e(int i) {
        return this.d.get(i).getName();
    }

    @Override // defpackage.ro
    public Object f(ViewGroup viewGroup, int i) {
        AutoCabInfo autoCabInfo = this.d.get(i);
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.c).inflate(R.layout.cab_info_layout, viewGroup, false);
        String H = ui1.H();
        int lowerFareAmount = autoCabInfo.getLowerFareAmount();
        int upperFareAmount = autoCabInfo.getUpperFareAmount();
        if (lowerFareAmount <= 0 || upperFareAmount <= 0) {
            viewGroup2.findViewById(R.id.price_container).setVisibility(8);
        } else {
            ((TextView) viewGroup2.findViewById(R.id.price_info)).setText(H + lowerFareAmount + " - " + H + upperFareAmount);
        }
        ui1.H0((TextView) viewGroup2.findViewById(R.id.eta_info), ii1.d((long) (autoCabInfo.getEta() * 60 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), this.c), this.c, 2);
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    @Override // defpackage.ro
    public boolean g(View view, Object obj) {
        return view == obj;
    }
}
