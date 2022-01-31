package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: op5  reason: default package */
/* compiled from: AttributeEditor */
public abstract class op5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f2721a = new ArrayList();
    public final hy5 b;

    /* renamed from: op5$a */
    /* compiled from: AttributeEditor */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2722a;
        public Object b;

        public a(op5 op5, String str, Object obj) {
            this.f2722a = str;
            this.b = obj;
        }

        public qp5 a(long j) {
            Object obj = this.b;
            if (obj == null) {
                return new qp5("remove", this.f2722a, null, ly5.a(j));
            }
            String str = this.f2722a;
            JsonValue x = JsonValue.x(obj);
            if (!x.l()) {
                Object obj2 = x.f;
                if (!(obj2 instanceof yt5) && !(obj2 instanceof zt5) && !(obj2 instanceof Boolean)) {
                    return new qp5("set", str, x, ly5.a(j));
                }
            }
            throw new IllegalArgumentException(hj1.R("Invalid attribute value: ", x));
        }
    }

    public op5(hy5 hy5) {
        this.b = hy5;
    }

    public void a() {
        if (this.f2721a.size() != 0) {
            Objects.requireNonNull(this.b);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (a aVar : this.f2721a) {
                try {
                    arrayList.add(aVar.a(currentTimeMillis));
                } catch (IllegalArgumentException e) {
                    yj5.e(e, "Invalid attribute mutation.", new Object[0]);
                }
            }
            c(arrayList);
        }
    }

    public final boolean b(String str) {
        if (hd3.G1(str)) {
            yj5.c("Attribute fields cannot be empty.", new Object[0]);
            return true;
        } else if (((long) str.length()) <= 1024) {
            return false;
        } else {
            yj5.c("Attribute field inputs cannot be greater than %s characters in length", 1024L);
            return true;
        }
    }

    public abstract void c(List<qp5> list);

    public op5 d(String str, String str2) {
        if (!b(str) && !b(str2)) {
            this.f2721a.add(new a(this, str, str2));
        }
        return this;
    }
}
