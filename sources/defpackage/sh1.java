package defpackage;

@y66(c = "app.zophop.utils.ExtensionUtils$launchPeriodicAsyncLazily$1", f = "ExtensionUtils.kt", l = {120}, m = "invokeSuspend")
/* renamed from: sh1  reason: default package */
/* compiled from: ExtensionUtils.kt */
public final class sh1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ long h;
    public final /* synthetic */ h76<s56> i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sh1(long j, h76<s56> h76, k66<? super sh1> k66) {
        super(2, k66);
        this.h = j;
        this.i = h76;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        sh1 sh1 = new sh1(this.h, this.i, k66);
        sh1.g = obj;
        return sh1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        sh1 sh1 = new sh1(this.h, this.i, k66);
        sh1.g = mb6;
        return sh1.invokeSuspend(s56.f3190a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    @Override // defpackage.u66
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            p66 r0 = defpackage.p66.COROUTINE_SUSPENDED
            int r1 = r7.f
            r2 = 1
            if (r1 == 0) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            java.lang.Object r1 = r7.g
            mb6 r1 = (defpackage.mb6) r1
            defpackage.hd3.Y2(r8)
            r8 = r7
            goto L_0x003e
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            defpackage.hd3.Y2(r8)
            java.lang.Object r8 = r7.g
            mb6 r8 = (defpackage.mb6) r8
            long r3 = r7.h
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x004a
            r1 = r8
            r8 = r7
        L_0x002b:
            boolean r3 = defpackage.hd3.C1(r1)
            if (r3 == 0) goto L_0x004f
            long r3 = r8.h
            r8.g = r1
            r8.f = r2
            java.lang.Object r3 = defpackage.hd3.C0(r3, r8)
            if (r3 != r0) goto L_0x003e
            return r0
        L_0x003e:
            boolean r3 = defpackage.hd3.C1(r1)
            if (r3 == 0) goto L_0x002b
            h76<s56> r3 = r8.i
            r3.invoke()
            goto L_0x002b
        L_0x004a:
            h76<s56> r8 = r7.i
            r8.invoke()
        L_0x004f:
            s56 r8 = defpackage.s56.f3190a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sh1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
