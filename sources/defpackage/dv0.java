package defpackage;

import android.view.View;
import app.zophop.R;
import defpackage.e44;
import java.util.List;

/* renamed from: dv0  reason: default package */
/* compiled from: LineMapFragment */
public class dv0 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ev0 f892a;

    /* renamed from: dv0$a */
    /* compiled from: LineMapFragment */
    public class a implements e44.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e44 f893a;
        public final /* synthetic */ List b;

        public a(e44 e44, List list) {
            this.f893a = e44;
            this.b = list;
        }

        @Override // defpackage.e44.g
        public void a() {
            if (dv0.this.f892a.isAdded()) {
                e44 e44 = this.f893a;
                int dimension = (int) dv0.this.f892a.getResources().getDimension(R.dimen.line_map_padding);
                List list = this.b;
                if (list.size() != 0) {
                    e44.j(new ch1(list, e44, dimension));
                }
            }
        }
    }

    /* renamed from: dv0$b */
    /* compiled from: LineMapFragment */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            ev0 ev0 = dv0.this.f892a;
            int i = ev0.v;
            if (q5.a(ev0.getActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                ev0.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 123);
            }
        }
    }

    public dv0(ev0 ev0) {
        this.f892a = ev0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015d A[LOOP:2: B:30:0x0157->B:32:0x015d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01b8 A[SYNTHETIC, Splitter:B:43:0x01b8] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01bf A[Catch:{ RemoteException -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.g44
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(defpackage.e44 r10) {
        /*
        // Method dump skipped, instructions count: 502
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dv0.a(e44):void");
    }
}
