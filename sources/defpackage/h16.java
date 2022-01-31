package defpackage;

import android.content.Context;
import android.util.Log;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: h16  reason: default package */
/* compiled from: EventsFilesManager */
public abstract class h16<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    public final Context context;
    public final l06 currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    public final i16 eventStorage;
    public volatile long lastRollOverTime;
    public final List<j16> rollOverListeners = new CopyOnWriteArrayList();
    public final g16<T> transform;

    /* renamed from: h16$a */
    /* compiled from: EventsFilesManager */
    public class a implements Comparator<b>, j$.util.Comparator {
        public a(h16 h16) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return (int) (bVar.b - bVar2.b);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<b> reversed() {
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
        public /* synthetic */ java.util.Comparator<b> thenComparing(java.util.Comparator<? super b> comparator) {
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

    /* renamed from: h16$b */
    /* compiled from: EventsFilesManager */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final File f1331a;
        public final long b;

        public b(File file, long j) {
            this.f1331a = file;
            this.b = j;
        }
    }

    public h16(Context context2, g16<T> g16, l06 l06, i16 i16, int i) throws IOException {
        this.context = context2.getApplicationContext();
        this.transform = g16;
        this.eventStorage = i16;
        this.currentTimeProvider = l06;
        Objects.requireNonNull((q06) l06);
        this.lastRollOverTime = System.currentTimeMillis();
        this.defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i) throws IOException {
        if (!((((m16) this.eventStorage).e.n() + 4) + i <= getMaxByteSizePerFile())) {
            String format = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(((m16) this.eventStorage).e.n()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile()));
            if (j06.i(this.context) && xz5.f3984a.a(4)) {
                Log.println(4, "Fabric", format);
            }
            rollFileOver();
        }
    }

    private void triggerRollOverOnListeners(String str) {
        for (j16 j16 : this.rollOverListeners) {
            try {
                j16.onRollOver(str);
            } catch (Exception unused) {
                j06.i(this.context);
            }
        }
    }

    public void deleteAllEventsFiles() {
        m16 m16 = (m16) this.eventStorage;
        m16.b(Arrays.asList(m16.f.listFiles()));
        m16 m162 = (m16) this.eventStorage;
        Objects.requireNonNull(m162);
        try {
            m162.e.close();
        } catch (IOException unused) {
        }
        m162.d.delete();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> asList = Arrays.asList(((m16) this.eventStorage).f.listFiles());
        int maxFilesToKeep = getMaxFilesToKeep();
        if (asList.size() > maxFilesToKeep) {
            int size = asList.size() - maxFilesToKeep;
            Context context2 = this.context;
            String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(asList.size()), Integer.valueOf(maxFilesToKeep), Integer.valueOf(size));
            j06.i(context2);
            TreeSet treeSet = new TreeSet(new a(this));
            for (File file : asList) {
                treeSet.add(new b(file, parseCreationTimestampFromFileName(file.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((b) it.next()).f1331a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            ((m16) this.eventStorage).b(arrayList);
        }
    }

    public void deleteSentFiles(List<File> list) {
        ((m16) this.eventStorage).b(list);
    }

    public abstract String generateUniqueRollOverFileName();

    public List<File> getBatchOfFilesToSend() {
        m16 m16 = (m16) this.eventStorage;
        Objects.requireNonNull(m16);
        ArrayList arrayList = new ArrayList();
        for (File file : m16.f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= 1) {
                break;
            }
        }
        return arrayList;
    }

    public long getLastRollOverTime() {
        return this.lastRollOverTime;
    }

    public int getMaxByteSizePerFile() {
        return MAX_BYTE_SIZE_PER_FILE;
    }

    public int getMaxFilesToKeep() {
        return this.defaultMaxFilesToKeep;
    }

    public long parseCreationTimestampFromFileName(String str) {
        String[] split = str.split("_");
        if (split.length != 3) {
            return 0;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void registerRollOverListener(j16 j16) {
        if (j16 != null) {
            this.rollOverListeners.add(j16);
        }
    }

    public boolean rollFileOver() throws IOException {
        String str;
        boolean z = false;
        if (!((m16) this.eventStorage).e.h()) {
            str = generateUniqueRollOverFileName();
            m16 m16 = (m16) this.eventStorage;
            m16.e.close();
            m16.c(m16.d, new File(m16.f, str));
            m16.e = new p06(m16.d);
            Context context2 = this.context;
            String format = String.format(Locale.US, "generated new file %s", str);
            if (j06.i(context2) && xz5.f3984a.a(4)) {
                Log.println(4, "Fabric", format);
            }
            Objects.requireNonNull((q06) this.currentTimeProvider);
            this.lastRollOverTime = System.currentTimeMillis();
            z = true;
        } else {
            str = null;
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    public void writeEvent(T t) throws IOException {
        byte[] bytes = this.transform.toBytes(t);
        rollFileOverIfNeeded(bytes.length);
        ((m16) this.eventStorage).e.c(bytes);
    }
}
