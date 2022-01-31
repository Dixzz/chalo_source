package defpackage;

import defpackage.m36;

/* renamed from: s36  reason: default package */
/* compiled from: Socket */
public class s36 implements Runnable {
    public final /* synthetic */ i46[] f;
    public final /* synthetic */ m36.a g;
    public final /* synthetic */ m36.a h;
    public final /* synthetic */ m36.a i;
    public final /* synthetic */ u36 j;
    public final /* synthetic */ m36.a k;
    public final /* synthetic */ m36.a l;

    public s36(u36 u36, i46[] i46Arr, m36.a aVar, m36.a aVar2, m36.a aVar3, u36 u362, m36.a aVar4, m36.a aVar5) {
        this.f = i46Arr;
        this.g = aVar;
        this.h = aVar2;
        this.i = aVar3;
        this.j = u362;
        this.k = aVar4;
        this.l = aVar5;
    }

    public void run() {
        this.f[0].c("open", this.g);
        this.f[0].c("error", this.h);
        this.f[0].c("close", this.i);
        this.j.c("close", this.k);
        this.j.c("upgrading", this.l);
    }
}
