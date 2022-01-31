package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Incorrect class signature, class is equals to this class: Lcz1<Lcz1;>; */
/* renamed from: cz1  reason: default package */
public class cz1 {

    /* renamed from: a  reason: collision with root package name */
    public final jz1 f769a;
    public final gz1 b;
    public final List<hz1> c = new ArrayList();
    public final ac3 d;
    public boolean e;

    public cz1(ac3 ac3) {
        jz1 d2 = ac3.d();
        cb2 cb2 = ac3.c;
        Objects.requireNonNull(d2, "null reference");
        this.f769a = d2;
        gz1 gz1 = new gz1(this, cb2);
        gz1.i = true;
        this.b = gz1;
        this.d = ac3;
    }
}
