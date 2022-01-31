package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.j.k;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class h extends c<Channel> {
    private Map<Long, Integer> ap;
    private final g av;
    private final e eT;
    private final c eU;
    private final boolean kQ;
    private boolean re;
    private List<String> tags;

    public class a implements Comparator<Channel>, j$.util.Comparator {
        private a() {
        }

        /* renamed from: a */
        public int compare(Channel channel, Channel channel2) {
            if (channel == null || channel2 == null) {
                return 0;
            }
            if (channel.getLatestOrWelcomeMessage() == null && channel2.getLatestOrWelcomeMessage() == null) {
                return channel.getPosition() > channel2.getPosition() ? 1 : -1;
            }
            if (channel.getLatestOrWelcomeMessage() == null) {
                return -1;
            }
            if (channel2.getLatestOrWelcomeMessage() == null) {
                return 1;
            }
            long createdMillis = channel.getLatestOrWelcomeMessage().getCreatedMillis();
            long createdMillis2 = channel2.getLatestOrWelcomeMessage().getCreatedMillis();
            return (createdMillis > 0 || createdMillis2 > 0) ? createdMillis > createdMillis2 ? -1 : 1 : channel.getPosition() > channel2.getPosition() ? 1 : -1;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<Channel> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<Channel> thenComparing(java.util.Comparator<? super Channel> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public h(Context context, boolean z) {
        super(context);
        this.eU = new c(context);
        this.av = new g(context);
        this.eT = new e(context);
        this.kQ = z;
    }

    public h(Context context, boolean z, List<String> list) {
        this(context, z);
        this.tags = list;
    }

    @Override // com.freshchat.consumer.sdk.g.c
    public List<Channel> dd() {
        if (this.kQ) {
            this.eT.fR();
        }
        List<Channel> a2 = this.eU.a(this.tags, false);
        if (k.isEmpty(a2)) {
            Channel cw = this.eU.cw();
            if (cw != null) {
                a2.add(cw);
                this.re = true;
            }
        } else {
            this.re = false;
        }
        Collections.sort(a2, new a());
        this.ap = this.av.cF();
        return a2;
    }

    public Map<Long, Integer> iT() {
        return this.ap;
    }
}
