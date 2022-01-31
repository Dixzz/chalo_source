package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: ds4  reason: default package */
public final class ds4 extends bw4 {
    public final File f;
    public final File g;
    public final NavigableMap<Long, File> h = new TreeMap();

    public ds4(File file, File file2) throws IOException {
        this.f = file;
        this.g = file2;
        ArrayList arrayList = (ArrayList) du4.a(file, file2);
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            long j = 0;
            while (it.hasNext()) {
                File file3 = (File) it.next();
                this.h.put(Long.valueOf(j), file3);
                j += file3.length();
            }
            return;
        }
        throw new os4(String.format("Virtualized slice archive empty for %s, %s", file, file2));
    }

    @Override // defpackage.bw4
    public final long a() {
        Map.Entry<Long, File> lastEntry = this.h.lastEntry();
        return lastEntry.getValue().length() + lastEntry.getKey().longValue();
    }

    @Override // defpackage.bw4
    public final InputStream c(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new os4(String.format("Invalid input parameters %s, %s", Long.valueOf(j), Long.valueOf(j2)));
        }
        long j3 = j + j2;
        if (j3 <= a()) {
            Long floorKey = this.h.floorKey(Long.valueOf(j));
            Long floorKey2 = this.h.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new cs4(e(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(e(j, floorKey));
            Collection<File> values = this.h.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new nt4(Collections.enumeration(values)));
            }
            arrayList.add(new cs4(new FileInputStream((File) this.h.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new os4(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", Long.valueOf(a()), Long.valueOf(j3)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final InputStream e(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.h.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new os4(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", l));
    }
}
