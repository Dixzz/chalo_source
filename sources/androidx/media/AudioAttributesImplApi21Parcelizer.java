package androidx.media;

import android.media.AudioAttributes;
import java.util.Objects;

public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(no noVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f224a = (AudioAttributes) noVar.m(audioAttributesImplApi21.f224a, 1);
        audioAttributesImplApi21.b = noVar.k(audioAttributesImplApi21.b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, no noVar) {
        Objects.requireNonNull(noVar);
        AudioAttributes audioAttributes = audioAttributesImplApi21.f224a;
        noVar.p(1);
        noVar.u(audioAttributes);
        int i = audioAttributesImplApi21.b;
        noVar.p(2);
        noVar.t(i);
    }
}
