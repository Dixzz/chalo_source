package defpackage;

import com.razorpay.AnalyticsConstants;

/* renamed from: rg5  reason: default package */
/* compiled from: RecorderErrorHandler */
public class rg5 {

    /* renamed from: a  reason: collision with root package name */
    public final pg5 f3079a;

    public rg5(pg5 pg5) {
        this.f3079a = pg5;
    }

    public void a(String str, int i) {
        if (str.equals(AnalyticsConstants.INIT)) {
            if (i >= 2) {
                this.f3079a.c("Recorder instance already created");
            }
            if (i == 1) {
                this.f3079a.c("Recorder instance creation in process");
            }
        }
        if (str.equals(AnalyticsConstants.START)) {
            if (i == 0) {
                this.f3079a.c("No Recorder instance found");
            }
            if (i == 1) {
                this.f3079a.c("Recorder instance creation in process");
            }
            if (i == 3) {
                this.f3079a.c("Recorder starting still in progress");
            }
            if (i == 4) {
                this.f3079a.c("Recorder already in progress");
            }
        }
        if (str.equals("stop")) {
            if (i == 0) {
                this.f3079a.c("No Recorder instance found");
            }
            if (i == 1) {
                this.f3079a.c("Recorder instance creation in process");
            }
            if (i == 3) {
                this.f3079a.c("Recorder starting still in progress");
            }
            if (i == 2) {
                this.f3079a.c("Recorder not recording");
            }
        }
        if (str.equals(AnalyticsConstants.DESTROY)) {
            if (i == 0) {
                this.f3079a.c("No Recorder instance found");
            }
            if (i == 1) {
                this.f3079a.c("Recorder instance creation in process");
            }
            if (i == 3) {
                this.f3079a.c("Recorder starting still in progress");
            }
        }
        if (str.equals("rec_in_use")) {
            this.f3079a.c("Recorder already in use");
        }
    }
}
