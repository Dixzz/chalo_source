package androidx.media;

import java.util.Objects;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(no noVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        Object obj = audioAttributesCompat.f223a;
        if (noVar.i(1)) {
            obj = noVar.o();
        }
        audioAttributesCompat.f223a = (AudioAttributesImpl) obj;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, no noVar) {
        Objects.requireNonNull(noVar);
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f223a;
        noVar.p(1);
        noVar.w(audioAttributesImpl);
    }
}
