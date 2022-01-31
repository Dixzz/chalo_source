package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f224a;
    public int b = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f224a.equals(((AudioAttributesImplApi21) obj).f224a);
    }

    public int hashCode() {
        return this.f224a.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("AudioAttributesCompat: audioattributes=");
        i0.append(this.f224a);
        return i0.toString();
    }
}
