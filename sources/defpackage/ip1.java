package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* renamed from: ip1  reason: default package */
/* compiled from: ModelLoader */
public interface ip1<Model, Data> {

    /* renamed from: ip1$a */
    /* compiled from: ModelLoader */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final dm1 f1550a;
        public final List<dm1> b;
        public final km1<Data> c;

        public a(dm1 dm1, km1<Data> km1) {
            List<dm1> emptyList = Collections.emptyList();
            Objects.requireNonNull(dm1, "Argument must not be null");
            this.f1550a = dm1;
            Objects.requireNonNull(emptyList, "Argument must not be null");
            this.b = emptyList;
            Objects.requireNonNull(km1, "Argument must not be null");
            this.c = km1;
        }
    }

    boolean a(Model model);

    a<Data> b(Model model, int i, int i2, fm1 fm1);
}
