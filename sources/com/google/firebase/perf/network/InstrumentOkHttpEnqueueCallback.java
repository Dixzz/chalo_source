package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;

public class InstrumentOkHttpEnqueueCallback implements jh6 {
    private final NetworkRequestMetricBuilder mBuilder;
    private final jh6 mCallback;
    private final long mStartTimeMicros;
    private final Timer mTimer;

    public InstrumentOkHttpEnqueueCallback(jh6 jh6, TransportManager transportManager, Timer timer, long j) {
        this.mCallback = jh6;
        this.mBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        this.mStartTimeMicros = j;
        this.mTimer = timer;
    }

    @Override // defpackage.jh6
    public void onFailure(ih6 ih6, IOException iOException) {
        ji6 request = ih6.request();
        if (request != null) {
            di6 di6 = request.b;
            if (di6 != null) {
                this.mBuilder.setUrl(di6.k().toString());
            }
            String str = request.c;
            if (str != null) {
                this.mBuilder.setHttpMethod(str);
            }
        }
        this.mBuilder.setRequestStartTimeMicros(this.mStartTimeMicros);
        this.mBuilder.setTimeToResponseCompletedMicros(this.mTimer.getDurationMicros());
        NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
        this.mCallback.onFailure(ih6, iOException);
    }

    @Override // defpackage.jh6
    public void onResponse(ih6 ih6, ni6 ni6) throws IOException {
        FirebasePerfOkHttpClient.sendNetworkMetric(ni6, this.mBuilder, this.mStartTimeMicros, this.mTimer.getDurationMicros());
        this.mCallback.onResponse(ih6, ni6);
    }
}
