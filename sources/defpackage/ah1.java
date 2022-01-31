package defpackage;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import defpackage.a32;
import defpackage.qg1;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: ah1  reason: default package */
/* compiled from: LocationEnableHelper */
public class ah1 {

    /* renamed from: a  reason: collision with root package name */
    public ve f164a;
    public boolean b;
    public a32 c;
    public boolean d = false;
    public a32.b e;
    public a32.c f;
    public b32 g;

    public ah1(ve veVar, a32 a32) {
        this.f164a = veVar;
        this.c = a32;
    }

    public final void a(String str) {
        ArrayList arrayList = new ArrayList();
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.l1(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        locationRequest.m1(100);
        arrayList.add(locationRequest);
        an3 an3 = h34.f;
        a32 a32 = this.c;
        LocationSettingsRequest locationSettingsRequest = new LocationSettingsRequest(arrayList, true, false, null);
        Objects.requireNonNull(an3);
        l32 i = a32.i(new bn3(a32, locationSettingsRequest));
        this.g = i;
        i.b(new zg1(this, str));
    }

    public void b(String str) {
        if (this.c.n()) {
            a(str);
            return;
        }
        a32.b bVar = this.e;
        if (bVar != null) {
            this.c.s(bVar);
        }
        a32.c cVar = this.f;
        if (cVar != null) {
            this.c.t(cVar);
        }
        b32 b32 = this.g;
        if (b32 != null) {
            b32.a();
        }
        yg1 yg1 = new yg1(this, str);
        this.e = yg1;
        this.c.q(yg1);
        xg1 xg1 = new xg1(this);
        this.f = xg1;
        this.c.r(xg1);
    }

    public void onEvent(qg1.a aVar) {
        int ordinal = aVar.f2942a.ordinal();
        if (ordinal == 0) {
            this.f164a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            Fragment findFragmentByTag = this.f164a.getFragmentManager().findFragmentByTag(qg1.f);
            if (findFragmentByTag != null) {
                ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
            }
            this.b = false;
        } else if (ordinal == 1) {
            Fragment findFragmentByTag2 = this.f164a.getFragmentManager().findFragmentByTag(qg1.f);
            if (findFragmentByTag2 != null) {
                ((DialogFragment) findFragmentByTag2).dismissAllowingStateLoss();
            }
            this.b = false;
        } else if (ordinal == 2) {
            this.b = false;
        }
    }
}
