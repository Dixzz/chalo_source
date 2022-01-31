package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.rabbitmq.client.AMQP;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class ConfigFetchHandler {
    public static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    public static final int HTTP_TOO_MANY_REQUESTS = 429;
    private final AnalyticsConnector analyticsConnector;
    private final cb2 clock;
    private final Map<String, String> customHttpHeaders;
    private final Executor executor;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigFetchHttpClient frcBackendApiClient;
    private final ConfigMetadataClient frcMetadata;
    private final Random randomGenerator;

    public static class FetchResponse {
        private final Date fetchTime;
        private final ConfigContainer fetchedConfigs;
        private final String lastFetchETag;
        private final int status;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
            public static final int BACKEND_HAS_NO_UPDATES = 1;
            public static final int BACKEND_UPDATES_FETCHED = 0;
            public static final int LOCAL_STORAGE_USED = 2;
        }

        private FetchResponse(Date date, int i, ConfigContainer configContainer, String str) {
            this.fetchTime = date;
            this.status = i;
            this.fetchedConfigs = configContainer;
            this.lastFetchETag = str;
        }

        public static FetchResponse forBackendHasNoUpdates(Date date) {
            return new FetchResponse(date, 1, null, null);
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forLocalStorageUsed(Date date) {
            return new FetchResponse(date, 2, null, null);
        }

        public Date getFetchTime() {
            return this.fetchTime;
        }

        public ConfigContainer getFetchedConfigs() {
            return this.fetchedConfigs;
        }

        public String getLastFetchETag() {
            return this.lastFetchETag;
        }

        public int getStatus() {
            return this.status;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, AnalyticsConnector analyticsConnector2, Executor executor2, cb2 cb2, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = analyticsConnector2;
        this.executor = executor2;
        this.clock = cb2;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcMetadata = configMetadataClient;
        this.customHttpHeaders = map;
    }

    private boolean areCachedFetchConfigsValid(long j, Date date) {
        Date lastSuccessfulFetchTime = this.frcMetadata.getLastSuccessfulFetchTime();
        if (lastSuccessfulFetchTime.equals(ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
            return false;
        }
        return date.before(new Date(TimeUnit.SECONDS.toMillis(j) + lastSuccessfulFetchTime.getTime()));
    }

    private FirebaseRemoteConfigServerException createExceptionWithGenericMessage(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else if (httpStatusCode == 429) {
            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
        } else if (httpStatusCode != 500) {
            switch (httpStatusCode) {
                case AMQP.SYNTAX_ERROR /*{ENCODED_INT: 502}*/:
                case AMQP.COMMAND_INVALID /*{ENCODED_INT: 503}*/:
                case AMQP.CHANNEL_ERROR /*{ENCODED_INT: 504}*/:
                    str = "The server is unavailable. Please try again later.";
                    break;
                default:
                    str = "The server returned an unexpected error.";
                    break;
            }
        } else {
            str = "There was an internal server error.";
        }
        return new FirebaseRemoteConfigServerException(firebaseRemoteConfigServerException.getHttpStatusCode(), hj1.S("Fetch failed: ", str), firebaseRemoteConfigServerException);
    }

    private String createThrottledMessage(long j) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j)));
    }

    private FetchResponse fetchFromBackend(String str, String str2, Date date) throws FirebaseRemoteConfigException {
        try {
            FetchResponse fetch = this.frcBackendApiClient.fetch(this.frcBackendApiClient.createHttpURLConnection(), str, str2, getUserProperties(), this.frcMetadata.getLastFetchETag(), this.customHttpHeaders, date);
            if (fetch.getLastFetchETag() != null) {
                this.frcMetadata.setLastFetchETag(fetch.getLastFetchETag());
            }
            this.frcMetadata.resetBackoff();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e) {
            ConfigMetadataClient.BackoffMetadata updateAndReturnBackoffMetadata = updateAndReturnBackoffMetadata(e.getHttpStatusCode(), date);
            if (shouldThrottle(updateAndReturnBackoffMetadata, e.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(updateAndReturnBackoffMetadata.getBackoffEndTime().getTime());
            }
            throw createExceptionWithGenericMessage(e);
        }
    }

    private yi4<FetchResponse> fetchFromBackendAndCacheResponse(String str, String str2, Date date) {
        try {
            FetchResponse fetchFromBackend = fetchFromBackend(str, str2, date);
            if (fetchFromBackend.getStatus() != 0) {
                return hd3.W0(fetchFromBackend);
            }
            return this.fetchedConfigsCache.put(fetchFromBackend.getFetchedConfigs()).s(this.executor, ConfigFetchHandler$$Lambda$4.lambdaFactory$(fetchFromBackend));
        } catch (FirebaseRemoteConfigException e) {
            return hd3.V0(e);
        }
    }

    /* access modifiers changed from: private */
    public yi4<FetchResponse> fetchIfCacheExpiredAndNotThrottled(yi4<ConfigContainer> yi4, long j) {
        yi4<TContinuationResult> yi42;
        Objects.requireNonNull((db2) this.clock);
        Date date = new Date(System.currentTimeMillis());
        if (yi4.q() && areCachedFetchConfigsValid(j, date)) {
            return hd3.W0(FetchResponse.forLocalStorageUsed(date));
        }
        Date backoffEndTimeInMillis = getBackoffEndTimeInMillis(date);
        if (backoffEndTimeInMillis != null) {
            yi42 = hd3.V0(new FirebaseRemoteConfigFetchThrottledException(createThrottledMessage(backoffEndTimeInMillis.getTime() - date.getTime()), backoffEndTimeInMillis.getTime()));
        } else {
            yi4<String> id = this.firebaseInstallations.getId();
            yi4<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
            yi42 = hd3.i3(id, token).k(this.executor, ConfigFetchHandler$$Lambda$2.lambdaFactory$(this, id, token, date));
        }
        return yi42.k(this.executor, ConfigFetchHandler$$Lambda$3.lambdaFactory$(this, date));
    }

    private Date getBackoffEndTimeInMillis(Date date) {
        Date backoffEndTime = this.frcMetadata.getBackoffMetadata().getBackoffEndTime();
        if (date.before(backoffEndTime)) {
            return backoffEndTime;
        }
        return null;
    }

    private long getRandomizedBackoffDurationInMillis(int i) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        long millis = timeUnit.toMillis((long) iArr[Math.min(i, iArr.length) - 1]);
        return (millis / 2) + ((long) this.randomGenerator.nextInt((int) millis));
    }

    private Map<String, String> getUserProperties() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector2 = this.analyticsConnector;
        if (analyticsConnector2 == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : analyticsConnector2.getUserProperties(false).entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private boolean isThrottleableServerError(int i) {
        return i == 429 || i == 502 || i == 503 || i == 504;
    }

    public static /* synthetic */ yi4 lambda$fetchIfCacheExpiredAndNotThrottled$1(ConfigFetchHandler configFetchHandler, yi4 yi4, yi4 yi42, Date date, yi4 yi43) throws Exception {
        if (!yi4.q()) {
            return hd3.V0(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", yi4.l()));
        }
        if (!yi42.q()) {
            return hd3.V0(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", yi42.l()));
        }
        return configFetchHandler.fetchFromBackendAndCacheResponse((String) yi4.m(), ((InstallationTokenResult) yi42.m()).getToken(), date);
    }

    private boolean shouldThrottle(ConfigMetadataClient.BackoffMetadata backoffMetadata, int i) {
        return backoffMetadata.getNumFailedFetches() > 1 || i == 429;
    }

    private ConfigMetadataClient.BackoffMetadata updateAndReturnBackoffMetadata(int i, Date date) {
        if (isThrottleableServerError(i)) {
            updateBackoffMetadataWithLastFailedFetchTime(date);
        }
        return this.frcMetadata.getBackoffMetadata();
    }

    private void updateBackoffMetadataWithLastFailedFetchTime(Date date) {
        int numFailedFetches = this.frcMetadata.getBackoffMetadata().getNumFailedFetches() + 1;
        this.frcMetadata.setBackoffMetadata(numFailedFetches, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedFetches)));
    }

    /* access modifiers changed from: private */
    public void updateLastFetchStatusAndTime(yi4<FetchResponse> yi4, Date date) {
        if (yi4.q()) {
            this.frcMetadata.updateLastFetchAsSuccessfulAt(date);
            return;
        }
        Exception l = yi4.l();
        if (l != null) {
            if (l instanceof FirebaseRemoteConfigFetchThrottledException) {
                this.frcMetadata.updateLastFetchAsThrottled();
            } else {
                this.frcMetadata.updateLastFetchAsFailed();
            }
        }
    }

    public yi4<FetchResponse> fetch() {
        return fetch(this.frcMetadata.getMinimumFetchIntervalInSeconds());
    }

    public AnalyticsConnector getAnalyticsConnector() {
        return this.analyticsConnector;
    }

    public yi4<FetchResponse> fetch(long j) {
        return this.fetchedConfigsCache.get().k(this.executor, ConfigFetchHandler$$Lambda$1.lambdaFactory$(this, j));
    }
}
