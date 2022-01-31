package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;

public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    @Keep
    public static void enqueue(ih6 ih6, jh6 jh6) {
        Timer timer = new Timer();
        ih6.L(new InstrumentOkHttpEnqueueCallback(jh6, TransportManager.getInstance(), timer, timer.getMicros()));
    }

    @Keep
    public static ni6 execute(ih6 ih6) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(TransportManager.getInstance());
        Timer timer = new Timer();
        long micros = timer.getMicros();
        try {
            ni6 execute = ih6.execute();
            sendNetworkMetric(execute, builder, micros, timer.getDurationMicros());
            return execute;
        } catch (IOException e) {
            ji6 request = ih6.request();
            if (request != null) {
                di6 di6 = request.b;
                if (di6 != null) {
                    builder.setUrl(di6.k().toString());
                }
                String str = request.c;
                if (str != null) {
                    builder.setHttpMethod(str);
                }
            }
            builder.setRequestStartTimeMicros(micros);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e;
        }
    }

    public static void sendNetworkMetric(ni6 ni6, NetworkRequestMetricBuilder networkRequestMetricBuilder, long j, long j2) throws IOException {
        ji6 ji6 = ni6.g;
        if (ji6 != null) {
            networkRequestMetricBuilder.setUrl(ji6.b.k().toString());
            networkRequestMetricBuilder.setHttpMethod(ji6.c);
            mi6 mi6 = ji6.e;
            if (mi6 != null) {
                long contentLength = mi6.contentLength();
                if (contentLength != -1) {
                    networkRequestMetricBuilder.setRequestPayloadBytes(contentLength);
                }
            }
            oi6 oi6 = ni6.m;
            if (oi6 != null) {
                long contentLength2 = oi6.contentLength();
                if (contentLength2 != -1) {
                    networkRequestMetricBuilder.setResponsePayloadBytes(contentLength2);
                }
                fi6 contentType = oi6.contentType();
                if (contentType != null) {
                    networkRequestMetricBuilder.setResponseContentType(contentType.f1129a);
                }
            }
            networkRequestMetricBuilder.setHttpResponseCode(ni6.j);
            networkRequestMetricBuilder.setRequestStartTimeMicros(j);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(j2);
            networkRequestMetricBuilder.build();
        }
    }
}
