package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Set;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.util.Set;
import java.util.Spliterator;

public class SamplingEventFilter implements EventFilter {
    public static final Set<SessionEvent.Type> EVENTS_TYPE_TO_SAMPLE = new j$.util.Set() {
        /* class com.crashlytics.android.answers.SamplingEventFilter.AnonymousClass1 */

        {
            add(SessionEvent.Type.START);
            add(SessionEvent.Type.RESUME);
            add(SessionEvent.Type.PAUSE);
            add(SessionEvent.Type.STOP);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        /* Return type fixed from 'j$.util.Spliterator' to match base method */
        @Override // java.util.HashSet, j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public /* synthetic */ Spliterator<SessionEvent.Type> spliterator() {
            return Set.CC.$default$spliterator(this);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }
    };
    public final int samplingRate;

    public SamplingEventFilter(int i) {
        this.samplingRate = i;
    }

    @Override // com.crashlytics.android.answers.EventFilter
    public boolean skipEvent(SessionEvent sessionEvent) {
        boolean z = EVENTS_TYPE_TO_SAMPLE.contains(sessionEvent.type) && sessionEvent.sessionEventMetadata.betaDeviceToken == null;
        boolean z2 = Math.abs(sessionEvent.sessionEventMetadata.installationId.hashCode() % this.samplingRate) != 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
