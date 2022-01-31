package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.zophop.R;

/* renamed from: hb1  reason: default package */
/* compiled from: MapCenterMarker */
public class hb1 extends LinearLayout {
    public final ImageView f;

    public hb1(Context context) {
        super(context);
        this.f = (ImageView) LayoutInflater.from(context).inflate(R.layout.map_center_marker, (ViewGroup) this, true).findViewById(R.id.center_marker);
    }

    public void setMarkerVisibility(boolean z) {
        this.f.setVisibility(z ? 0 : 8);
    }
}
