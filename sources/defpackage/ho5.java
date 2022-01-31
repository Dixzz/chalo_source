package defpackage;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/* renamed from: ho5  reason: default package */
/* compiled from: FrequencyLimitManager */
public class ho5 implements Runnable {
    public final /* synthetic */ Collection f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ jo5 h;

    /* renamed from: ho5$a */
    /* compiled from: FrequencyLimitManager */
    public class a implements fo5 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Collection f1404a;

        public a(Collection collection) {
            this.f1404a = collection;
        }

        @Override // defpackage.fo5
        public boolean a() {
            jo5 jo5 = ho5.this.h;
            Collection<ko5> collection = this.f1404a;
            Objects.requireNonNull(jo5);
            boolean z = true;
            if (!collection.isEmpty()) {
                synchronized (jo5.c) {
                    if (jo5.b(collection)) {
                        z = false;
                    } else {
                        HashSet hashSet = new HashSet();
                        for (ko5 ko5 : collection) {
                            hashSet.add(ko5.b);
                        }
                        jo5.c(hashSet);
                    }
                }
            }
            return z;
        }

        @Override // defpackage.fo5
        public boolean b() {
            return ho5.this.h.b(this.f1404a);
        }
    }

    public ho5(jo5 jo5, Collection collection, ck5 ck5) {
        this.h = jo5;
        this.f = collection;
        this.g = ck5;
    }

    public void run() {
        try {
            this.g.d(new a(jo5.a(this.h, this.f)));
        } catch (Exception unused) {
            yj5.c("Failed to fetch constraints.", new Object[0]);
            this.g.d(null);
        }
    }
}
