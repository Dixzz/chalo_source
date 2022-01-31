package defpackage;

import android.os.Bundle;
import android.os.Looper;
import com.urbanairship.json.JsonValue;
import defpackage.gm5;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: em5  reason: default package */
/* compiled from: ActionsScheduleDelegate */
public class em5 implements nn5<vn5> {

    /* renamed from: a  reason: collision with root package name */
    public final vk5 f995a;
    public final Map<String, vn5> b = new HashMap();

    /* renamed from: em5$a */
    /* compiled from: ActionsScheduleDelegate */
    public static class a implements pk5 {

        /* renamed from: a  reason: collision with root package name */
        public final gm5.a f996a;
        public int b;

        public a(gm5.a aVar, int i) {
            this.f996a = aVar;
            this.b = i;
        }

        @Override // defpackage.pk5
        public void a(ok5 ok5, rk5 rk5) {
            int i = this.b - 1;
            this.b = i;
            if (i == 0) {
                this.f996a.a();
            }
        }
    }

    public em5() {
        vk5 vk5 = new vk5();
        this.f995a = vk5;
    }

    @Override // defpackage.nn5
    public void a(ln5<? extends mn5> ln5) {
    }

    @Override // defpackage.nn5
    public void b(ln5<? extends mn5> ln5) {
    }

    @Override // defpackage.nn5
    public int c(ln5<? extends mn5> ln5) {
        return this.b.containsKey(ln5.f2243a) ? 1 : -1;
    }

    @Override // defpackage.nn5
    public void d(ln5<? extends mn5> ln5) {
    }

    @Override // defpackage.nn5
    public void e(ln5<? extends mn5> ln5, gm5.a aVar) {
        vn5 vn5 = this.b.get(ln5.f2243a);
        if (vn5 == null) {
            aVar.a();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("com.urbanairship.ACTION_SCHEDULE_ID", ln5.f2243a);
        a aVar2 = new a(aVar, vn5.f.size());
        for (Map.Entry<String, JsonValue> entry : vn5.f.e()) {
            Objects.requireNonNull(this.f995a);
            tk5 a2 = tk5.a(entry.getKey());
            a2.d(entry.getValue());
            a2.f = 6;
            a2.d = bundle;
            a2.c(Looper.getMainLooper(), aVar2);
        }
    }

    @Override // defpackage.nn5
    public void f(ln5<? extends mn5> ln5) {
        this.b.remove(ln5.f2243a);
    }
}
