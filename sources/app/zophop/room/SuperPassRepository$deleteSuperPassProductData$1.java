package app.zophop.room;

@y66(c = "app.zophop.room.SuperPassRepository$deleteSuperPassProductData$1", f = "SuperPassRepository.kt", l = {31, 32, 33}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$deleteSuperPassProductData$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int label;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$deleteSuperPassProductData$1(SuperPassRepository superPassRepository, k66<? super SuperPassRepository$deleteSuperPassProductData$1> k66) {
        super(2, k66);
        this.this$0 = superPassRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$deleteSuperPassProductData$1(this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((SuperPassRepository$deleteSuperPassProductData$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046 A[RETURN] */
    @Override // defpackage.u66
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            p66 r0 = defpackage.p66.COROUTINE_SUSPENDED
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001f
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            defpackage.hd3.Y2(r6)
            goto L_0x0047
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001b:
            defpackage.hd3.Y2(r6)
            goto L_0x003c
        L_0x001f:
            defpackage.hd3.Y2(r6)
            goto L_0x0031
        L_0x0023:
            defpackage.hd3.Y2(r6)
            app.zophop.room.SuperPassRepository r6 = r5.this$0
            r5.label = r4
            java.lang.Object r6 = app.zophop.room.SuperPassRepository.access$deleteAllSuperPassApplications(r6, r5)
            if (r6 != r0) goto L_0x0031
            return r0
        L_0x0031:
            app.zophop.room.SuperPassRepository r6 = r5.this$0
            r5.label = r3
            java.lang.Object r6 = app.zophop.room.SuperPassRepository.access$deleteAllMagicSuperPasses(r6, r5)
            if (r6 != r0) goto L_0x003c
            return r0
        L_0x003c:
            app.zophop.room.SuperPassRepository r6 = r5.this$0
            r5.label = r2
            java.lang.Object r6 = app.zophop.room.SuperPassRepository.access$deleteAllRideBasedSuperPasses(r6, r5)
            if (r6 != r0) goto L_0x0047
            return r0
        L_0x0047:
            s56 r6 = defpackage.s56.f3190a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassRepository$deleteSuperPassProductData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
