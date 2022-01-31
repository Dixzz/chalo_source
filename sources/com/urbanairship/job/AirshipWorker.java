package com.urbanairship.job;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import defpackage.st5;
import java.util.concurrent.Executor;

public class AirshipWorker extends ListenableWorker {

    public class a {

        /* renamed from: com.urbanairship.job.AirshipWorker$a$a  reason: collision with other inner class name */
        public class C0016a implements st5.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ x2 f734a;

            public C0016a(a aVar, x2 x2Var) {
                this.f734a = x2Var;
            }

            public void a(st5 st5, int i) {
                if (i == 0) {
                    this.f734a.a(new ListenableWorker.a.c());
                } else if (i == 1) {
                    this.f734a.a(new ListenableWorker.a.b());
                }
            }
        }

        public a() {
        }

        public Object a(x2<ListenableWorker.a> x2Var) throws Exception {
            try {
                rt5 R = hd3.R(AirshipWorker.this.g.b);
                Executor executor = st5.h;
                st5.b bVar = new st5.b(R);
                bVar.b = new C0016a(this, x2Var);
                st5 st5 = new st5(bVar, null);
                yj5.h("Running job: %s", R);
                st5.h.execute(st5);
                return R;
            } catch (xt5 unused) {
                yj5.c("AirshipWorker: Failed to parse jobInfo.", new Object[0]);
                return Boolean.valueOf(x2Var.a(new ListenableWorker.a.C0002a()));
            }
        }
    }

    public AirshipWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public gy4<ListenableWorker.a> d() {
        a aVar = new a();
        x2<ListenableWorker.a> x2Var = new x2<>();
        z2<T> z2Var = new z2<>(x2Var);
        x2Var.b = z2Var;
        x2Var.f3872a = a.class;
        try {
            Object a2 = aVar.a(x2Var);
            if (a2 != null) {
                x2Var.f3872a = a2;
            }
        } catch (Exception e) {
            z2Var.g.j(e);
        }
        return z2Var;
    }
}
