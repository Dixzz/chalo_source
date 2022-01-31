package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateUpdateHandler;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.internal.SessionAwareObject;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Trace extends AppStateUpdateHandler implements Parcelable, FirebasePerformanceAttributable, SessionAwareObject {
    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new Parcelable.Creator<Trace>() {
        /* class com.google.firebase.perf.metrics.Trace.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Trace createFromParcel(Parcel parcel) {
            return new Trace(parcel, false);
        }

        @Override // android.os.Parcelable.Creator
        public Trace[] newArray(int i) {
            return new Trace[i];
        }
    };
    public static final Parcelable.Creator<Trace> CREATOR_DATAONLY = new Parcelable.Creator<Trace>() {
        /* class com.google.firebase.perf.metrics.Trace.AnonymousClass2 */

        @Override // android.os.Parcelable.Creator
        public Trace createFromParcel(Parcel parcel) {
            return new Trace(parcel, true);
        }

        @Override // android.os.Parcelable.Creator
        public Trace[] newArray(int i) {
            return new Trace[i];
        }
    };
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final Map<String, Trace> sTraces = new ConcurrentHashMap();
    private final Map<String, String> attributes;
    private final Clock clock;
    private final Map<String, Counter> counters;
    private Timer endTime;
    private final GaugeManager gaugeManager;
    private final String name;
    private final Trace parent;
    private final List<PerfSession> sessions;
    private Timer startTime;
    private final List<Trace> subtraces;
    private final TransportManager transportManager;
    private final WeakReference<SessionAwareObject> weakReference;

    private void checkAttribute(String str, String str2) {
        if (isStopped()) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Trace '%s' has been stopped", this.name));
        } else if (this.attributes.containsKey(str) || this.attributes.size() < 5) {
            String validateAttribute = PerfMetricValidator.validateAttribute(new AbstractMap.SimpleEntry(str, str2));
            if (validateAttribute != null) {
                throw new IllegalArgumentException(validateAttribute);
            }
        } else {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", 5));
        }
    }

    public static Trace create(String str) {
        return new Trace(str);
    }

    public static synchronized Trace getTrace(String str) {
        Trace trace;
        synchronized (Trace.class) {
            Map<String, Trace> map = sTraces;
            trace = map.get(str);
            if (trace == null) {
                trace = new Trace(str);
                map.put(str, trace);
            }
        }
        return trace;
    }

    private Counter obtainOrCreateCounterByName(String str) {
        Counter counter = this.counters.get(str);
        if (counter != null) {
            return counter;
        }
        Counter counter2 = new Counter(str);
        this.counters.put(str, counter2);
        return counter2;
    }

    private void setEndTimeOfLastStage(Timer timer) {
        if (!this.subtraces.isEmpty()) {
            Trace trace = this.subtraces.get(this.subtraces.size() - 1);
            if (trace.endTime == null) {
                trace.endTime = timer;
            }
        }
    }

    public static Trace startTrace(String str) {
        Trace trace = sTraces.get(str);
        if (trace != null) {
            trace.start();
        }
        return trace;
    }

    public static Trace stopTrace(String str) {
        Map<String, Trace> map = sTraces;
        Trace trace = map.get(str);
        if (trace != null) {
            trace.stop();
            map.remove(str);
        }
        return trace;
    }

    @Keep
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            if (isActive()) {
                logger.warn(String.format(Locale.ENGLISH, "Trace '%s' is started but not stopped when it is destructed!", this.name), new Object[0]);
                incrementTsnsCount(1);
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    @Keep
    public String getAttribute(String str) {
        return this.attributes.get(str);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.attributes);
    }

    public Map<String, Counter> getCounters() {
        return this.counters;
    }

    public Timer getEndTime() {
        return this.endTime;
    }

    @Keep
    public long getLongMetric(String str) {
        Counter counter = str != null ? this.counters.get(str.trim()) : null;
        if (counter == null) {
            return 0;
        }
        return counter.getCount();
    }

    public String getName() {
        return this.name;
    }

    public List<PerfSession> getSessions() {
        List<PerfSession> unmodifiableList;
        synchronized (this.sessions) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession perfSession : this.sessions) {
                if (perfSession != null) {
                    arrayList.add(perfSession);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public Timer getStartTime() {
        return this.startTime;
    }

    public List<Trace> getSubtraces() {
        return this.subtraces;
    }

    public boolean hasStarted() {
        return this.startTime != null;
    }

    @Keep
    public void incrementMetric(String str, long j) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error(String.format(Locale.ENGLISH, "Cannot increment metric '%s'. Metric name is invalid.(%s)", str, validateMetricName), new Object[0]);
        } else if (!hasStarted()) {
            logger.warn(String.format(Locale.ENGLISH, "Cannot increment metric '%s' for trace '%s' because it's not started", str, this.name), new Object[0]);
        } else if (isStopped()) {
            logger.warn(String.format(Locale.ENGLISH, "Cannot increment metric '%s' for trace '%s' because it's been stopped", str, this.name), new Object[0]);
        } else {
            Counter obtainOrCreateCounterByName = obtainOrCreateCounterByName(str.trim());
            obtainOrCreateCounterByName.increment(j);
            logger.debug(String.format(Locale.ENGLISH, "Incrementing metric '%s' to %d on trace '%s'", str, Long.valueOf(obtainOrCreateCounterByName.getCount()), this.name), new Object[0]);
        }
    }

    public boolean isActive() {
        return hasStarted() && !isStopped();
    }

    public boolean isStopped() {
        return this.endTime != null;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    @Keep
    public void putAttribute(String str, String str2) {
        boolean z = true;
        try {
            str = str.trim();
            str2 = str2.trim();
            checkAttribute(str, str2);
            logger.debug(String.format(Locale.ENGLISH, "Setting attribute '%s' to '%s' on trace '%s'", str, str2, this.name), new Object[0]);
        } catch (Exception e) {
            logger.error(String.format(Locale.ENGLISH, "Can not set attribute '%s' with value '%s' (%s)", str, str2, e.getMessage()), new Object[0]);
            z = false;
        }
        if (z) {
            this.attributes.put(str, str2);
        }
    }

    @Keep
    public void putMetric(String str, long j) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error(String.format(Locale.ENGLISH, "Cannot set value for metric '%s'. Metric name is invalid.(%s)", str, validateMetricName), new Object[0]);
        } else if (!hasStarted()) {
            logger.warn(String.format(Locale.ENGLISH, "Cannot set value for metric '%s' for trace '%s' because it's not started", str, this.name), new Object[0]);
        } else if (isStopped()) {
            logger.warn(String.format(Locale.ENGLISH, "Cannot set value for metric '%s' for trace '%s' because it's been stopped", str, this.name), new Object[0]);
        } else {
            obtainOrCreateCounterByName(str.trim()).setCount(j);
            logger.debug(String.format(Locale.ENGLISH, "Setting metric '%s' to '%s' on trace '%s'", str, Long.valueOf(j), this.name), new Object[0]);
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    @Keep
    public void removeAttribute(String str) {
        if (isStopped()) {
            logger.error("Can't remove a attribute from a Trace that's stopped.", new Object[0]);
        } else {
            this.attributes.remove(str);
        }
    }

    @Keep
    public void start() {
        if (!ConfigResolver.getInstance().isPerformanceMonitoringEnabled()) {
            logger.info("Trace feature is disabled.", new Object[0]);
            return;
        }
        String validateTraceName = PerfMetricValidator.validateTraceName(this.name);
        if (validateTraceName != null) {
            logger.error(String.format(Locale.ENGLISH, "Cannot start trace '%s'. Trace name is invalid.(%s)", this.name, validateTraceName), new Object[0]);
        } else if (this.startTime != null) {
            logger.error(String.format(Locale.ENGLISH, "Trace '%s' has already started, should not start again!", this.name), new Object[0]);
        } else {
            this.startTime = this.clock.getTime();
            registerForAppState();
            PerfSession perfSession = SessionManager.getInstance().perfSession();
            SessionManager.getInstance().registerForSessionUpdates(this.weakReference);
            updateSession(perfSession);
            if (perfSession.isGaugeAndEventCollectionEnabled()) {
                this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
            }
        }
    }

    public void startStage(String str) {
        Timer time = this.clock.getTime();
        setEndTimeOfLastStage(time);
        this.subtraces.add(new Trace(this, str, time, null, null, null, null));
    }

    @Keep
    public void stop() {
        if (!hasStarted()) {
            logger.error(String.format(Locale.ENGLISH, "Trace '%s' has not been started so unable to stop!", this.name), new Object[0]);
        } else if (isStopped()) {
            logger.error(String.format(Locale.ENGLISH, "Trace '%s' has already stopped, should not stop again!", this.name), new Object[0]);
        } else {
            SessionManager.getInstance().unregisterForSessionUpdates(this.weakReference);
            unregisterForAppState();
            Timer time = this.clock.getTime();
            this.endTime = time;
            if (this.parent == null) {
                setEndTimeOfLastStage(time);
                if (!this.name.isEmpty()) {
                    this.transportManager.log(new TraceMetricBuilder(this).build(), getAppState());
                    if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
                        this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
                        return;
                    }
                    return;
                }
                logger.error("Trace name is empty, no log is sent to server", new Object[0]);
            }
        }
    }

    public void stopStage() {
        setEndTimeOfLastStage(this.clock.getTime());
    }

    @Override // com.google.firebase.perf.internal.SessionAwareObject
    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.info("Unable to add new SessionId to the Trace. Continuing without it.", new Object[0]);
        } else if (hasStarted() && !isStopped()) {
            this.sessions.add(perfSession);
        }
    }

    @Keep
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.parent, 0);
        parcel.writeString(this.name);
        parcel.writeList(this.subtraces);
        parcel.writeMap(this.counters);
        parcel.writeParcelable(this.startTime, 0);
        parcel.writeParcelable(this.endTime, 0);
        synchronized (this.sessions) {
            parcel.writeList(this.sessions);
        }
    }

    private Trace(String str) {
        this(str, TransportManager.getInstance(), new Clock(), AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public static synchronized Trace getTrace(String str, TransportManager transportManager2, Clock clock2, AppStateMonitor appStateMonitor) {
        Trace trace;
        synchronized (Trace.class) {
            Map<String, Trace> map = sTraces;
            trace = map.get(str);
            if (trace == null) {
                trace = new Trace(str, transportManager2, clock2, appStateMonitor, GaugeManager.getInstance());
                map.put(str, trace);
            }
        }
        return trace;
    }

    private Trace(Trace trace, String str, Timer timer, Timer timer2, List<Trace> list, Map<String, Counter> map, Map<String, String> map2) {
        this.weakReference = new WeakReference<>(this);
        this.parent = trace;
        this.name = str.trim();
        this.startTime = timer;
        this.endTime = timer2;
        this.subtraces = list == null ? new ArrayList<>() : list;
        this.counters = map == null ? new ConcurrentHashMap<>() : map;
        this.attributes = map2 == null ? new ConcurrentHashMap<>() : map2;
        this.clock = trace.clock;
        this.transportManager = trace.transportManager;
        this.sessions = Collections.synchronizedList(new ArrayList());
        this.gaugeManager = trace.gaugeManager;
    }

    public Trace(String str, TransportManager transportManager2, Clock clock2, AppStateMonitor appStateMonitor) {
        this(str, transportManager2, clock2, appStateMonitor, GaugeManager.getInstance());
    }

    public Trace(String str, TransportManager transportManager2, Clock clock2, AppStateMonitor appStateMonitor, GaugeManager gaugeManager2) {
        super(appStateMonitor);
        this.weakReference = new WeakReference<>(this);
        this.parent = null;
        this.name = str.trim();
        this.subtraces = new ArrayList();
        this.counters = new ConcurrentHashMap();
        this.attributes = new ConcurrentHashMap();
        this.clock = clock2;
        this.transportManager = transportManager2;
        this.sessions = Collections.synchronizedList(new ArrayList());
        this.gaugeManager = gaugeManager2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private Trace(Parcel parcel, boolean z) {
        super(z ? null : AppStateMonitor.getInstance());
        this.weakReference = new WeakReference<>(this);
        this.parent = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.subtraces = arrayList;
        parcel.readList(arrayList, Trace.class.getClassLoader());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.counters = concurrentHashMap;
        this.attributes = new ConcurrentHashMap();
        parcel.readMap(concurrentHashMap, Counter.class.getClassLoader());
        this.startTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        this.endTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        List<PerfSession> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.sessions = synchronizedList;
        parcel.readList(synchronizedList, PerfSession.class.getClassLoader());
        if (z) {
            this.transportManager = null;
            this.clock = null;
            this.gaugeManager = null;
            return;
        }
        this.transportManager = TransportManager.getInstance();
        this.clock = new Clock();
        this.gaugeManager = GaugeManager.getInstance();
    }
}
