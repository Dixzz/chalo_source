package retrofit2;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.ci6;
import defpackage.di6;
import defpackage.fi6;
import defpackage.gi6;
import defpackage.ji6;
import defpackage.yh6;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final di6 baseUrl;
    @Nullable
    private mi6 body;
    @Nullable
    private fi6 contentType;
    @Nullable
    private yh6.a formBuilder;
    private final boolean hasBody;
    private final ci6.a headersBuilder;
    private final String method;
    @Nullable
    private gi6.a multipartBuilder;
    @Nullable
    private String relativeUrl;
    private final ji6.a requestBuilder = new ji6.a();
    @Nullable
    private di6.a urlBuilder;

    public static class ContentTypeOverridingRequestBody extends mi6 {
        private final fi6 contentType;
        private final mi6 delegate;

        public ContentTypeOverridingRequestBody(mi6 mi6, fi6 fi6) {
            this.delegate = mi6;
            this.contentType = fi6;
        }

        @Override // defpackage.mi6
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // defpackage.mi6
        public fi6 contentType() {
            return this.contentType;
        }

        @Override // defpackage.mi6
        public void writeTo(xm6 xm6) throws IOException {
            this.delegate.writeTo(xm6);
        }
    }

    public RequestBuilder(String str, di6 di6, @Nullable String str2, @Nullable ci6 ci6, @Nullable fi6 fi6, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = di6;
        this.relativeUrl = str2;
        this.contentType = fi6;
        this.hasBody = z;
        if (ci6 != null) {
            this.headersBuilder = ci6.e();
        } else {
            this.headersBuilder = new ci6.a();
        }
        if (z2) {
            this.formBuilder = new yh6.a();
        } else if (z3) {
            gi6.a aVar = new gi6.a();
            this.multipartBuilder = aVar;
            aVar.c(gi6.g);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                vm6 vm6 = new vm6();
                vm6.T(str, 0, i);
                canonicalizeForPath(vm6, str, i, length, z);
                return vm6.o();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    public void addFormField(String str, String str2, boolean z) {
        di6.b bVar = di6.l;
        if (z) {
            yh6.a aVar = this.formBuilder;
            Objects.requireNonNull(aVar);
            n86.f(str, "name");
            n86.f(str2, FirebaseAnalytics.Param.VALUE);
            aVar.f4049a.add(di6.b.a(bVar, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, aVar.c, 83));
            aVar.b.add(di6.b.a(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, aVar.c, 83));
            return;
        }
        yh6.a aVar2 = this.formBuilder;
        Objects.requireNonNull(aVar2);
        n86.f(str, "name");
        n86.f(str2, FirebaseAnalytics.Param.VALUE);
        aVar2.f4049a.add(di6.b.a(bVar, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, aVar2.c, 91));
        aVar2.b.add(di6.b.a(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, aVar2.c, 91));
    }

    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                fi6.a aVar = fi6.f;
                this.contentType = fi6.a.a(str2);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(hj1.S("Malformed content type: ", str2), e);
            }
        } else {
            this.headersBuilder.a(str, str2);
        }
    }

    public void addHeaders(ci6 ci6) {
        ci6.a aVar = this.headersBuilder;
        Objects.requireNonNull(aVar);
        n86.f(ci6, "headers");
        int size = ci6.size();
        for (int i = 0; i < size; i++) {
            aVar.c(ci6.d(i), ci6.n(i));
        }
    }

    public void addPart(ci6 ci6, mi6 mi6) {
        gi6.a aVar = this.multipartBuilder;
        Objects.requireNonNull(aVar);
        n86.f(mi6, ProductPromotionsObject.KEY_BODY);
        n86.f(mi6, ProductPromotionsObject.KEY_BODY);
        boolean z = false;
        if ((ci6 != null ? ci6.b("Content-Type") : null) == null) {
            if ((ci6 != null ? ci6.b("Content-Length") : null) == null) {
                z = true;
            }
            if (z) {
                aVar.a(new gi6.c(ci6, mi6, null));
                return;
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
    }

    public void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl != null) {
            String canonicalizeForPath = canonicalizeForPath(str2, z);
            String str3 = this.relativeUrl;
            String replace = str3.replace("{" + str + "}", canonicalizeForPath);
            if (!PATH_TRAVERSAL.matcher(replace).matches()) {
                this.relativeUrl = replace;
                return;
            }
            throw new IllegalArgumentException(hj1.S("@Path parameters shouldn't perform path traversal ('.' or '..'): ", str2));
        }
        throw new AssertionError();
    }

    public void addQueryParam(String str, @Nullable String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            di6.a g = this.baseUrl.g(str3);
            this.urlBuilder = g;
            if (g != null) {
                this.relativeUrl = null;
            } else {
                StringBuilder i0 = hj1.i0("Malformed URL. Base: ");
                i0.append(this.baseUrl);
                i0.append(", Relative: ");
                i0.append(this.relativeUrl);
                throw new IllegalArgumentException(i0.toString());
            }
        }
        if (z) {
            this.urlBuilder.a(str, str2);
        } else {
            this.urlBuilder.b(str, str2);
        }
    }

    public <T> void addTag(Class<T> cls, @Nullable T t) {
        this.requestBuilder.h(cls, t);
    }

    public ji6.a get() {
        di6 di6;
        di6.a aVar = this.urlBuilder;
        if (aVar != null) {
            di6 = aVar.c();
        } else {
            di6 di62 = this.baseUrl;
            String str = this.relativeUrl;
            Objects.requireNonNull(di62);
            n86.f(str, "link");
            di6.a g = di62.g(str);
            di6 = g != null ? g.c() : null;
            if (di6 == null) {
                StringBuilder i0 = hj1.i0("Malformed URL. Base: ");
                i0.append(this.baseUrl);
                i0.append(", Relative: ");
                i0.append(this.relativeUrl);
                throw new IllegalArgumentException(i0.toString());
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            yh6.a aVar2 = this.formBuilder;
            if (aVar2 != null) {
                contentTypeOverridingRequestBody = new yh6(aVar2.f4049a, aVar2.b);
            } else {
                gi6.a aVar3 = this.multipartBuilder;
                if (aVar3 != null) {
                    contentTypeOverridingRequestBody = aVar3.b();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = mi6.create((fi6) null, new byte[0]);
                }
            }
        }
        fi6 fi6 = this.contentType;
        if (fi6 != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, fi6);
            } else {
                this.headersBuilder.a("Content-Type", fi6.f1129a);
            }
        }
        ji6.a aVar4 = this.requestBuilder;
        aVar4.j(di6);
        aVar4.e(this.headersBuilder.d());
        aVar4.f(this.method, contentTypeOverridingRequestBody);
        return aVar4;
    }

    public void setBody(mi6 mi6) {
        this.body = mi6;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    private static void canonicalizeForPath(vm6 vm6, String str, int i, int i2, boolean z) {
        vm6 vm62 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (vm62 == null) {
                        vm62 = new vm6();
                    }
                    vm62.V(codePointAt);
                    while (!vm62.R()) {
                        int readByte = vm62.readByte() & 255;
                        vm6.A(37);
                        char[] cArr = HEX_DIGITS;
                        vm6.A(cArr[(readByte >> 4) & 15]);
                        vm6.A(cArr[readByte & 15]);
                    }
                } else {
                    vm6.V(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public void addPart(gi6.c cVar) {
        this.multipartBuilder.a(cVar);
    }
}
