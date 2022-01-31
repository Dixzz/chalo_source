package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.util.concurrent.ScheduledExecutorService;

public class AnswersEventsHandler implements j16 {
    private final Context context;
    public final ScheduledExecutorService executor;
    private final AnswersFilesManagerProvider filesManagerProvider;
    private final c06 kit;
    private final SessionMetadataCollector metadataCollector;
    private final r16 requestFactory;
    public SessionAnalyticsManagerStrategy strategy = new DisabledSessionAnalyticsManagerStrategy();

    public AnswersEventsHandler(c06 c06, Context context2, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, r16 r16, ScheduledExecutorService scheduledExecutorService) {
        this.kit = c06;
        this.context = context2;
        this.filesManagerProvider = answersFilesManagerProvider;
        this.metadataCollector = sessionMetadataCollector;
        this.requestFactory = r16;
        this.executor = scheduledExecutorService;
    }

    private void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Exception unused) {
        }
    }

    private void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Exception unused) {
        }
    }

    public void disable() {
        executeAsync(new Runnable() {
            /* class com.crashlytics.android.answers.AnswersEventsHandler.AnonymousClass2 */

            public void run() {
                try {
                    AnswersEventsHandler answersEventsHandler = AnswersEventsHandler.this;
                    SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = answersEventsHandler.strategy;
                    answersEventsHandler.strategy = new DisabledSessionAnalyticsManagerStrategy();
                    sessionAnalyticsManagerStrategy.deleteAllEvents();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void enable() {
        executeAsync(new Runnable() {
            /* class com.crashlytics.android.answers.AnswersEventsHandler.AnonymousClass4 */

            public void run() {
                try {
                    SessionEventMetadata metadata = AnswersEventsHandler.this.metadataCollector.getMetadata();
                    SessionAnalyticsFilesManager analyticsFilesManager = AnswersEventsHandler.this.filesManagerProvider.getAnalyticsFilesManager();
                    analyticsFilesManager.registerRollOverListener(AnswersEventsHandler.this);
                    AnswersEventsHandler answersEventsHandler = AnswersEventsHandler.this;
                    c06 c06 = answersEventsHandler.kit;
                    Context context = AnswersEventsHandler.this.context;
                    AnswersEventsHandler answersEventsHandler2 = AnswersEventsHandler.this;
                    answersEventsHandler.strategy = new EnabledSessionAnalyticsManagerStrategy(c06, context, answersEventsHandler2.executor, analyticsFilesManager, answersEventsHandler2.requestFactory, metadata);
                } catch (Exception unused) {
                }
            }
        });
    }

    public void flushEvents() {
        executeAsync(new Runnable() {
            /* class com.crashlytics.android.answers.AnswersEventsHandler.AnonymousClass5 */

            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.rollFileOver();
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // defpackage.j16
    public void onRollOver(String str) {
        executeAsync(new Runnable() {
            /* class com.crashlytics.android.answers.AnswersEventsHandler.AnonymousClass3 */

            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.sendEvents();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void processEvent(final SessionEvent.Builder builder, boolean z, final boolean z2) {
        AnonymousClass6 r0 = new Runnable() {
            /* class com.crashlytics.android.answers.AnswersEventsHandler.AnonymousClass6 */

            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.processEvent(builder);
                    if (z2) {
                        AnswersEventsHandler.this.strategy.rollFileOver();
                    }
                } catch (Exception unused) {
                }
            }
        };
        if (z) {
            executeSync(r0);
        } else {
            executeAsync(r0);
        }
    }

    public void processEventAsync(SessionEvent.Builder builder) {
        processEvent(builder, false, false);
    }

    public void processEventAsyncAndFlush(SessionEvent.Builder builder) {
        processEvent(builder, false, true);
    }

    public void processEventSync(SessionEvent.Builder builder) {
        processEvent(builder, true, false);
    }

    public void setAnalyticsSettingsData(y16 y16, String str) {
        executeAsync(new Runnable(y16, str) {
            /* class com.crashlytics.android.answers.AnswersEventsHandler.AnonymousClass1 */
            public final /* synthetic */ y16 val$analyticsSettingsData;
            public final /* synthetic */ String val$protocolAndHostOverride;

            {
                this.val$protocolAndHostOverride = r3;
            }

            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.setAnalyticsSettingsData(this.val$analyticsSettingsData, this.val$protocolAndHostOverride);
                } catch (Exception unused) {
                }
            }
        });
    }
}
