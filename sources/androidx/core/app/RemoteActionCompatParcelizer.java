package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(no noVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object obj = remoteActionCompat.f202a;
        if (noVar.i(1)) {
            obj = noVar.o();
        }
        remoteActionCompat.f202a = (IconCompat) obj;
        CharSequence charSequence = remoteActionCompat.b;
        if (noVar.i(2)) {
            charSequence = noVar.h();
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (noVar.i(3)) {
            charSequence2 = noVar.h();
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.d = (PendingIntent) noVar.m(remoteActionCompat.d, 4);
        boolean z = remoteActionCompat.e;
        if (noVar.i(5)) {
            z = noVar.f();
        }
        remoteActionCompat.e = z;
        boolean z2 = remoteActionCompat.f;
        if (noVar.i(6)) {
            z2 = noVar.f();
        }
        remoteActionCompat.f = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, no noVar) {
        Objects.requireNonNull(noVar);
        IconCompat iconCompat = remoteActionCompat.f202a;
        noVar.p(1);
        noVar.w(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        noVar.p(2);
        noVar.s(charSequence);
        CharSequence charSequence2 = remoteActionCompat.c;
        noVar.p(3);
        noVar.s(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.d;
        noVar.p(4);
        noVar.u(pendingIntent);
        boolean z = remoteActionCompat.e;
        noVar.p(5);
        noVar.q(z);
        boolean z2 = remoteActionCompat.f;
        noVar.p(6);
        noVar.q(z2);
    }
}
