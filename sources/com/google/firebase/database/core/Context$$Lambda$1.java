package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Context */
public final /* synthetic */ class Context$$Lambda$1 implements ConnectionAuthTokenProvider {
    private final AuthTokenProvider arg$1;
    private final ScheduledExecutorService arg$2;

    private Context$$Lambda$1(AuthTokenProvider authTokenProvider, ScheduledExecutorService scheduledExecutorService) {
        this.arg$1 = authTokenProvider;
        this.arg$2 = scheduledExecutorService;
    }

    public static ConnectionAuthTokenProvider lambdaFactory$(AuthTokenProvider authTokenProvider, ScheduledExecutorService scheduledExecutorService) {
        return new Context$$Lambda$1(authTokenProvider, scheduledExecutorService);
    }

    @Override // com.google.firebase.database.connection.ConnectionAuthTokenProvider
    public void getToken(boolean z, ConnectionAuthTokenProvider.GetTokenCallback getTokenCallback) {
        this.arg$1.getToken(z, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: INVOKE  
              (wrap: com.google.firebase.database.core.AuthTokenProvider : 0x0000: IGET  (r0v0 com.google.firebase.database.core.AuthTokenProvider) = (r2v0 'this' com.google.firebase.database.core.Context$$Lambda$1 A[IMMUTABLE_TYPE, THIS]) com.google.firebase.database.core.Context$$Lambda$1.arg$1 com.google.firebase.database.core.AuthTokenProvider)
              (r3v0 'z' boolean)
              (wrap: com.google.firebase.database.core.Context$1 : 0x0002: CONSTRUCTOR  
              (wrap: java.util.concurrent.ScheduledExecutorService : 0x0002: IGET  (r1v0 java.util.concurrent.ScheduledExecutorService) = (r2v0 'this' com.google.firebase.database.core.Context$$Lambda$1 A[IMMUTABLE_TYPE, THIS]) com.google.firebase.database.core.Context$$Lambda$1.arg$2 java.util.concurrent.ScheduledExecutorService)
              (r4v0 'getTokenCallback' com.google.firebase.database.connection.ConnectionAuthTokenProvider$GetTokenCallback)
             call: com.google.firebase.database.core.Context.1.<init>(java.util.concurrent.ScheduledExecutorService, com.google.firebase.database.connection.ConnectionAuthTokenProvider$GetTokenCallback):void type: CONSTRUCTOR)
             type: INTERFACE call: com.google.firebase.database.core.AuthTokenProvider.getToken(boolean, com.google.firebase.database.core.AuthTokenProvider$GetTokenCompletionListener):void in method: com.google.firebase.database.core.Context$$Lambda$1.getToken(boolean, com.google.firebase.database.connection.ConnectionAuthTokenProvider$GetTokenCallback):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: CONSTRUCTOR  
              (wrap: java.util.concurrent.ScheduledExecutorService : 0x0002: IGET  (r1v0 java.util.concurrent.ScheduledExecutorService) = (r2v0 'this' com.google.firebase.database.core.Context$$Lambda$1 A[IMMUTABLE_TYPE, THIS]) com.google.firebase.database.core.Context$$Lambda$1.arg$2 java.util.concurrent.ScheduledExecutorService)
              (r4v0 'getTokenCallback' com.google.firebase.database.connection.ConnectionAuthTokenProvider$GetTokenCallback)
             call: com.google.firebase.database.core.Context.1.<init>(java.util.concurrent.ScheduledExecutorService, com.google.firebase.database.connection.ConnectionAuthTokenProvider$GetTokenCallback):void type: CONSTRUCTOR in method: com.google.firebase.database.core.Context$$Lambda$1.getToken(boolean, com.google.firebase.database.connection.ConnectionAuthTokenProvider$GetTokenCallback):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.firebase.database.core.Context, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            this = this;
            com.google.firebase.database.core.AuthTokenProvider r0 = r2.arg$1
            java.util.concurrent.ScheduledExecutorService r1 = r2.arg$2
            com.google.firebase.database.core.Context.lambda$wrapAuthTokenProvider$0(r0, r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.Context$$Lambda$1.getToken(boolean, com.google.firebase.database.connection.ConnectionAuthTokenProvider$GetTokenCallback):void");
    }
}
