package app.zophop.ui.views;

import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import app.zophop.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Objects;

public class MapCustomMyLocation extends ImageView {
    public e44 f;

    public MapCustomMyLocation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageResource(R.drawable.my_location_homescreen);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        e44 e44 = this.f;
        if (e44 != null) {
            try {
                Objects.requireNonNull(e44);
                try {
                    Location H3 = e44.f924a.H3();
                    if (H3 != null) {
                        this.f.b(hd3.k2(new LatLng(H3.getLatitude(), H3.getLongitude()), 16.0f));
                        return false;
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } catch (Exception e2) {
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMap(e44 e44) {
        this.f = e44;
    }
}
