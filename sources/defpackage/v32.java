package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import defpackage.w72;
import defpackage.x22;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

/* renamed from: v32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class v32 implements x22.f, ServiceConnection {
    @Override // defpackage.x22.f
    public final void connect(@RecentlyNonNull w72.c cVar) {
        Thread.currentThread();
        throw null;
    }

    @Override // defpackage.x22.f
    public final void disconnect() {
        Thread.currentThread();
        throw null;
    }

    @Override // defpackage.x22.f
    public final void dump(@RecentlyNonNull String str, FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, String[] strArr) {
    }

    @Override // defpackage.x22.f
    @RecentlyNonNull
    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    @Override // defpackage.x22.f
    @RecentlyNonNull
    public final String getEndpointPackageName() {
        throw null;
    }

    @Override // defpackage.x22.f
    @RecentlyNullable
    public final String getLastDisconnectMessage() {
        return null;
    }

    @Override // defpackage.x22.f
    public final int getMinApkVersion() {
        return 0;
    }

    @Override // defpackage.x22.f
    public final void getRemoteService(c82 c82, Set<Scope> set) {
    }

    @Override // defpackage.x22.f
    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    @Override // defpackage.x22.f
    @RecentlyNonNull
    public final Intent getSignInIntent() {
        return new Intent();
    }

    @Override // defpackage.x22.f
    public final boolean isConnected() {
        Thread.currentThread();
        throw null;
    }

    @Override // defpackage.x22.f
    public final boolean isConnecting() {
        Thread.currentThread();
        throw null;
    }

    public final void onServiceConnected(@RecentlyNonNull ComponentName componentName, @RecentlyNonNull IBinder iBinder) {
        throw null;
    }

    public final void onServiceDisconnected(@RecentlyNonNull ComponentName componentName) {
        throw null;
    }

    @Override // defpackage.x22.f
    public final void onUserSignOut(@RecentlyNonNull w72.e eVar) {
    }

    @Override // defpackage.x22.f
    public final boolean providesSignIn() {
        return false;
    }

    @Override // defpackage.x22.f
    public final boolean requiresGooglePlayServices() {
        return false;
    }

    @Override // defpackage.x22.f
    public final boolean requiresSignIn() {
        return false;
    }

    @Override // defpackage.x22.f
    public final void disconnect(@RecentlyNonNull String str) {
        Thread.currentThread();
        throw null;
    }
}
