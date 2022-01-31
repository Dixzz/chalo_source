package androidx.media;

import java.util.Objects;

public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(no noVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f225a = noVar.k(audioAttributesImplBase.f225a, 1);
        audioAttributesImplBase.b = noVar.k(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = noVar.k(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = noVar.k(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, no noVar) {
        Objects.requireNonNull(noVar);
        int i = audioAttributesImplBase.f225a;
        noVar.p(1);
        noVar.t(i);
        int i2 = audioAttributesImplBase.b;
        noVar.p(2);
        noVar.t(i2);
        int i3 = audioAttributesImplBase.c;
        noVar.p(3);
        noVar.t(i3);
        int i4 = audioAttributesImplBase.d;
        noVar.p(4);
        noVar.t(i4);
    }
}
