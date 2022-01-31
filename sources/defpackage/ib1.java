package defpackage;

import android.content.Context;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import app.zophop.R;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

/* renamed from: ib1  reason: default package */
/* compiled from: MapCircularOverlay */
public class ib1 extends LinearLayout {
    public e44 f;
    public final View g;
    public final Context h;

    public ib1(Context context) {
        super(context);
        this.h = context;
        this.g = LayoutInflater.from(context).inflate(R.layout.home_map_overlay, (ViewGroup) this, true).findViewById(R.id.markerContainerCircle);
    }

    public void a(double d) {
        e44 e44 = this.f;
        if (e44 != null) {
            try {
                VisibleRegion c1 = e44.e().f1339a.c1();
                double m = ui1.m(c1.nearLeft, c1.farLeft);
                double d2 = d / m;
                int i = (int) (d2 * ((double) ((this.f.e().a(c1.nearLeft).y - this.f.e().a(c1.farLeft).y) * 2)));
                this.g.setLayoutParams(new LinearLayout.LayoutParams(i, i));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public void setGoogleMap(e44 e44) {
        this.f = e44;
    }
}
