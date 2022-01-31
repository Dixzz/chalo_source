package defpackage;

import server.zophop.gpsIntegration.LiveDataHandler;
import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.models.CheckOutType;
import server.zophop.models.Point;

/* renamed from: no6  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class no6 implements Runnable {
    public final /* synthetic */ LiveDataHandler f;
    public final /* synthetic */ VehicleCheckinInfo g;
    public final /* synthetic */ String h;
    public final /* synthetic */ VehicleGPSInfo i;
    public final /* synthetic */ Point j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ CheckOutType m;
    public final /* synthetic */ String n;

    public /* synthetic */ no6(LiveDataHandler liveDataHandler, VehicleCheckinInfo vehicleCheckinInfo, String str, VehicleGPSInfo vehicleGPSInfo, Point point, String str2, String str3, CheckOutType checkOutType, String str4) {
        this.f = liveDataHandler;
        this.g = vehicleCheckinInfo;
        this.h = str;
        this.i = vehicleGPSInfo;
        this.j = point;
        this.k = str2;
        this.l = str3;
        this.m = checkOutType;
        this.n = str4;
    }

    public final void run() {
        this.f.a(this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
    }
}
