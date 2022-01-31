package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;

public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    /* renamed from: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.google.firebase.crashlytics.internal.report.model.Report.Type.values()
                r0 = 2
                int[] r1 = new int[r0]
                com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall.AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type = r1
                r2 = 1
                com.google.firebase.crashlytics.internal.report.model.Report$Type r3 = com.google.firebase.crashlytics.internal.report.model.Report.Type.JAVA     // Catch:{ NoSuchFieldError -> 0x000e }
                r3 = 0
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r1 = com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall.AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.crashlytics.internal.report.model.Report$Type r3 = com.google.firebase.crashlytics.internal.report.model.Report.Type.NATIVE     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall.AnonymousClass1.<clinit>():void");
        }
    }

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        int ordinal = createReportRequest.report.getType().ordinal();
        if (ordinal == 0) {
            this.javaReportSpiCall.invoke(createReportRequest, z);
            return true;
        } else if (ordinal != 1) {
            return false;
        } else {
            this.nativeReportSpiCall.invoke(createReportRequest, z);
            return true;
        }
    }
}
