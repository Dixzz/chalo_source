package defpackage;

import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: uu1  reason: default package */
/* compiled from: ClientInfo */
public abstract class uu1 {

    /* renamed from: uu1$a */
    /* compiled from: ClientInfo */
    public enum a {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);
        
        private final int value;

        private a(int i) {
            this.value = i;
        }
    }

    public abstract ku1 a();

    public abstract a b();
}
