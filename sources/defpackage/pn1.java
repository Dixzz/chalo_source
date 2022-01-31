package defpackage;

import defpackage.fn1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: pn1  reason: default package */
/* compiled from: LoadPath */
public class pn1<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final v7<List<Exception>> f2832a;
    public final List<? extends fn1<Data, ResourceType, Transcode>> b;
    public final String c;

    public pn1(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<fn1<Data, ResourceType, Transcode>> list, v7<List<Exception>> v7Var) {
        this.f2832a = v7Var;
        if (!list.isEmpty()) {
            this.b = list;
            StringBuilder i0 = hj1.i0("Failed LoadPath{");
            i0.append(cls.getSimpleName());
            i0.append("->");
            i0.append(cls2.getSimpleName());
            i0.append("->");
            i0.append(cls3.getSimpleName());
            i0.append("}");
            this.c = i0.toString();
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public rn1<Transcode> a(lm1<Data> lm1, fm1 fm1, int i, int i2, fn1.a<ResourceType> aVar) throws nn1 {
        List<Exception> b2 = this.f2832a.b();
        try {
            int size = this.b.size();
            rn1<Transcode> rn1 = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    rn1 = ((fn1) this.b.get(i3)).a(lm1, i, i2, fm1, aVar);
                } catch (nn1 e) {
                    b2.add(e);
                }
                if (rn1 != null) {
                    break;
                }
            }
            if (rn1 != null) {
                return rn1;
            }
            throw new nn1(this.c, new ArrayList(b2));
        } finally {
            this.f2832a.a(b2);
        }
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("LoadPath{decodePaths=");
        List<? extends fn1<Data, ResourceType, Transcode>> list = this.b;
        i0.append(Arrays.toString(list.toArray(new fn1[list.size()])));
        i0.append('}');
        return i0.toString();
    }
}
