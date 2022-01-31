package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    public static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    public h06 apiKey = new h06();
    private final Context context;
    public boolean customEventsEnabled = true;
    public EventFilter eventFilter = new KeepAllEventFilter();
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    public l16 filesSender;
    private final r16 httpRequestFactory;
    private final c06 kit;
    public final SessionEventMetadata metadata;
    public boolean predefinedEventsEnabled = true;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference<>();
    public volatile int rolloverIntervalSeconds = -1;

    public EnabledSessionAnalyticsManagerStrategy(c06 c06, Context context2, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, r16 r16, SessionEventMetadata sessionEventMetadata) {
        this.kit = c06;
        this.context = context2;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = r16;
        this.metadata = sessionEventMetadata;
    }

    @Override // defpackage.k16, com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            j06.i(this.context);
            this.rolloverFutureRef.get().cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void processEvent(SessionEvent.Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        if (!this.customEventsEnabled && SessionEvent.Type.CUSTOM.equals(build.type)) {
            String str = "Custom events tracking disabled - skipping event: " + build;
        } else if (!this.predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(build.type)) {
            String str2 = "Predefined events tracking disabled - skipping event: " + build;
        } else if (this.eventFilter.skipEvent(build)) {
            String str3 = "Skipping filtered event: " + build;
        } else {
            try {
                this.filesManager.writeEvent(build);
            } catch (IOException unused) {
                String str4 = "Failed to write event: " + build;
            }
            scheduleTimeBasedRollOverIfNeeded();
        }
    }

    @Override // defpackage.k16, com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException unused) {
            j06.i(this.context);
            return false;
        }
    }

    public void scheduleTimeBasedFileRollOver(long j, long j2) {
        if (this.rolloverFutureRef.get() == null) {
            Context context2 = this.context;
            n16 n16 = new n16(context2, this);
            j06.i(context2);
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(n16, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException unused) {
                j06.i(this.context);
            }
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.rolloverIntervalSeconds != -1) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void sendEvents() {
        if (this.filesSender == null) {
            j06.i(this.context);
            return;
        }
        j06.i(this.context);
        List<File> batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (true) {
            try {
                if (batchOfFilesToSend.size() <= 0) {
                    break;
                }
                Context context2 = this.context;
                String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(batchOfFilesToSend.size()));
                j06.i(context2);
                boolean send = this.filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                }
                batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
            } catch (Exception e) {
                Context context3 = this.context;
                e.getMessage();
                j06.i(context3);
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void setAnalyticsSettingsData(y16 y16, String str) {
        throw null;
    }
}
