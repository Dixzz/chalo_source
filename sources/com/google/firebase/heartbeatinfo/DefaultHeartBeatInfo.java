package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultHeartBeatInfo implements HeartBeatInfo {
    private static final ThreadFactory THREAD_FACTORY = ez4.f1048a;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f660a = 0;
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private Provider<HeartBeatInfoStorage> storageProvider;

    private DefaultHeartBeatInfo(Context context, Set<HeartBeatConsumer> set) {
        this(new Lazy((Provider) new gz4(context)), set, new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY));
    }

    public static /* synthetic */ HeartBeatInfo a(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo((Context) componentContainer.get(Context.class), componentContainer.setOf(HeartBeatConsumer.class));
    }

    public static Component<HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).add(Dependency.setOf(HeartBeatConsumer.class)).factory(iz4.f1588a).build();
    }

    public /* synthetic */ List b() {
        HeartBeatInfo.HeartBeat heartBeat;
        ArrayList arrayList = new ArrayList();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        List<SdkHeartBeatResult> storedHeartBeats = heartBeatInfoStorage.getStoredHeartBeats(true);
        long lastGlobalHeartBeat = heartBeatInfoStorage.getLastGlobalHeartBeat();
        for (SdkHeartBeatResult sdkHeartBeatResult : storedHeartBeats) {
            boolean isSameDateUtc = HeartBeatInfoStorage.isSameDateUtc(lastGlobalHeartBeat, sdkHeartBeatResult.getMillis());
            if (isSameDateUtc) {
                heartBeat = HeartBeatInfo.HeartBeat.COMBINED;
            } else {
                heartBeat = HeartBeatInfo.HeartBeat.SDK;
            }
            if (isSameDateUtc) {
                lastGlobalHeartBeat = sdkHeartBeatResult.getMillis();
            }
            arrayList.add(HeartBeatResult.create(sdkHeartBeatResult.getSdkName(), sdkHeartBeatResult.getMillis(), heartBeat));
        }
        if (lastGlobalHeartBeat > 0) {
            heartBeatInfoStorage.updateGlobalHeartBeat(lastGlobalHeartBeat);
        }
        return arrayList;
    }

    public /* synthetic */ Void c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.storageProvider.get().shouldSendSdkHeartBeat(str, currentTimeMillis)) {
            return null;
        }
        this.storageProvider.get().storeHeartBeatInformation(str, currentTimeMillis);
        return null;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public yi4<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo() {
        return hd3.A(this.backgroundExecutor, new fz4(this));
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public HeartBeatInfo.HeartBeat getHeartBeatCode(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean shouldSendSdkHeartBeat = this.storageProvider.get().shouldSendSdkHeartBeat(str, currentTimeMillis);
        boolean shouldSendGlobalHeartBeat = this.storageProvider.get().shouldSendGlobalHeartBeat(currentTimeMillis);
        if (shouldSendSdkHeartBeat && shouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (shouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (shouldSendSdkHeartBeat) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public yi4<Void> storeHeartBeatInfo(String str) {
        if (this.consumers.size() <= 0) {
            return hd3.W0(null);
        }
        return hd3.A(this.backgroundExecutor, new hz4(this, str));
    }

    public DefaultHeartBeatInfo(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
    }
}
