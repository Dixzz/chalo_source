package androidx.media;

import android.util.SparseIntArray;

public class AudioAttributesCompat implements po {
    public static final SparseIntArray b;

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributesImpl f223a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f223a;
        if (audioAttributesImpl != null) {
            return audioAttributesImpl.equals(audioAttributesCompat.f223a);
        }
        if (audioAttributesCompat.f223a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f223a.hashCode();
    }

    public String toString() {
        return this.f223a.toString();
    }
}
