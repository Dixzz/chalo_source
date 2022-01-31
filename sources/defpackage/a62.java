package defpackage;

import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import defpackage.x22;

/* renamed from: a62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class a62<T> implements ti4<T> {
    public final o32 f;
    public final int g;
    public final j32<?> h;
    public final long i;

    /* JADX WARN: Incorrect args count in method signature: (Lo32;ILj32<*>;JLjava/lang/String;Ljava/lang/String;)V */
    public a62(o32 o32, int i2, j32 j32, long j) {
        this.f = o32;
        this.g = i2;
        this.h = j32;
        this.i = j;
    }

    public static ConnectionTelemetryConfiguration a(p52<?> p52, w72<?> w72, int i2) {
        ConnectionTelemetryConfiguration telemetryConfiguration = w72.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.g) {
            return null;
        }
        int[] iArr = telemetryConfiguration.i;
        if (iArr == null) {
            int[] iArr2 = telemetryConfiguration.k;
            if (iArr2 != null && gj1.r(iArr2, i2)) {
                return null;
            }
        } else if (!gj1.r(iArr, i2)) {
            return null;
        }
        if (p52.q < telemetryConfiguration.j) {
            return telemetryConfiguration;
        }
        return null;
    }

    @Override // defpackage.ti4
    public final void onComplete(yi4<T> yi4) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j;
        long j2;
        int i7;
        int i8;
        if (this.f.g()) {
            RootTelemetryConfiguration rootTelemetryConfiguration = i82.a().f1489a;
            if (rootTelemetryConfiguration == null || rootTelemetryConfiguration.g) {
                p52<?> p52 = this.f.j.get(this.h);
                if (p52 != null) {
                    x22.f fVar = p52.g;
                    if (fVar instanceof w72) {
                        w72 w72 = (w72) fVar;
                        boolean z = true;
                        boolean z2 = this.i > 0;
                        int gCoreServiceId = w72.getGCoreServiceId();
                        if (rootTelemetryConfiguration != null) {
                            z2 &= rootTelemetryConfiguration.h;
                            int i9 = rootTelemetryConfiguration.i;
                            int i10 = rootTelemetryConfiguration.j;
                            i4 = rootTelemetryConfiguration.f;
                            if (w72.hasConnectionInfo() && !w72.isConnecting()) {
                                ConnectionTelemetryConfiguration a2 = a(p52, w72, this.g);
                                if (a2 != null) {
                                    if (!a2.h || this.i <= 0) {
                                        z = false;
                                    }
                                    i10 = a2.j;
                                    z2 = z;
                                } else {
                                    return;
                                }
                            }
                            i3 = i9;
                            i2 = i10;
                        } else {
                            i4 = 0;
                            i3 = 5000;
                            i2 = 100;
                        }
                        o32 o32 = this.f;
                        if (yi4.q()) {
                            i6 = 0;
                            i5 = 0;
                        } else {
                            if (yi4.o()) {
                                i7 = 100;
                            } else {
                                Exception l = yi4.l();
                                if (l instanceof y22) {
                                    Status status = ((y22) l).f;
                                    int i11 = status.g;
                                    ConnectionResult connectionResult = status.j;
                                    if (connectionResult == null) {
                                        i8 = -1;
                                    } else {
                                        i8 = connectionResult.g;
                                    }
                                    i5 = i8;
                                    i6 = i11;
                                } else {
                                    i7 = 101;
                                }
                            }
                            i6 = i7;
                            i5 = -1;
                        }
                        if (z2) {
                            long j3 = this.i;
                            j = System.currentTimeMillis();
                            j2 = j3;
                        } else {
                            j2 = 0;
                            j = 0;
                        }
                        MethodInvocation methodInvocation = new MethodInvocation(this.g, i6, i5, j2, j, null, null, gCoreServiceId);
                        long j4 = (long) i3;
                        Handler handler = o32.n;
                        handler.sendMessage(handler.obtainMessage(18, new b62(methodInvocation, i4, j4, i2)));
                    }
                }
            }
        }
    }
}
