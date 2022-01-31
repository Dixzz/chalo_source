package defpackage;

import java.util.Objects;

/* renamed from: ig5  reason: default package */
/* compiled from: Sender */
public class ig5 implements Runnable {
    public final /* synthetic */ kg5 f;

    public ig5(kg5 kg5) {
        this.f = kg5;
    }

    public void run() {
        kg5 kg5 = this.f;
        bg5 bg5 = kg5.d;
        Objects.requireNonNull(kg5);
        bg5.a("Sender", "Play Again");
        this.f.b(true);
    }
}
