package com.google.firebase.crashlytics.internal.network;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.di6;
import defpackage.fi6;
import defpackage.gi6;
import defpackage.hi6;
import defpackage.ji6;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import server.zophop.Constants;

public class HttpRequest {
    private static final hi6 CLIENT;
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private gi6.a bodyBuilder = null;
    private final Map<String, String> headers;
    private final HttpMethod method;
    private final Map<String, String> queryParams;
    private final String url;

    static {
        hi6.a b = new hi6().b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        n86.f(timeUnit, "unit");
        byte[] bArr = vi6.f3652a;
        n86.f("timeout", "name");
        long millis = timeUnit.toMillis(Constants.THRESHOLD_TIMESTAMP);
        boolean z = true;
        if (millis <= ((long) Integer.MAX_VALUE)) {
            if (millis == 0) {
                z = false;
            }
            if (z) {
                b.x = (int) millis;
                CLIENT = new hi6(b);
                return;
            }
            throw new IllegalArgumentException("timeout too small.".toString());
        }
        throw new IllegalArgumentException("timeout too large.".toString());
    }

    public HttpRequest(HttpMethod httpMethod, String str, Map<String, String> map) {
        this.method = httpMethod;
        this.url = str;
        this.queryParams = map;
        this.headers = new HashMap();
    }

    private ji6 build() {
        ji6.a c = new ji6.a().c(new hh6(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null, null));
        di6.a f = di6.h(this.url).f();
        for (Map.Entry<String, String> entry : this.queryParams.entrySet()) {
            f.a(entry.getKey(), entry.getValue());
        }
        c.j(f.c());
        for (Map.Entry<String, String> entry2 : this.headers.entrySet()) {
            c.d(entry2.getKey(), entry2.getValue());
        }
        gi6.a aVar = this.bodyBuilder;
        c.f(this.method.name(), aVar == null ? null : aVar.b());
        return c.b();
    }

    private gi6.a getOrCreateBodyBuilder() {
        if (this.bodyBuilder == null) {
            gi6.a aVar = new gi6.a();
            aVar.c(gi6.g);
            this.bodyBuilder = aVar;
        }
        return this.bodyBuilder;
    }

    public HttpResponse execute() throws IOException {
        return HttpResponse.create(((nj6) CLIENT.a(build())).execute());
    }

    public HttpRequest header(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public String method() {
        return this.method.name();
    }

    public HttpRequest part(String str, String str2, String str3, File file) {
        fi6.a aVar = fi6.f;
        mi6 create = mi6.create(fi6.a.b(str3), file);
        gi6.a orCreateBodyBuilder = getOrCreateBodyBuilder();
        Objects.requireNonNull(orCreateBodyBuilder);
        n86.f(str, "name");
        n86.f(create, ProductPromotionsObject.KEY_BODY);
        orCreateBodyBuilder.a(gi6.c.b(str, str2, create));
        this.bodyBuilder = orCreateBodyBuilder;
        return this;
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public HttpRequest part(String str, String str2) {
        gi6.a orCreateBodyBuilder = getOrCreateBodyBuilder();
        Objects.requireNonNull(orCreateBodyBuilder);
        n86.f(str, "name");
        n86.f(str2, FirebaseAnalytics.Param.VALUE);
        n86.f(str, "name");
        n86.f(str2, FirebaseAnalytics.Param.VALUE);
        orCreateBodyBuilder.a(gi6.c.b(str, null, mi6.Companion.a(str2, null)));
        this.bodyBuilder = orCreateBodyBuilder;
        return this;
    }
}
