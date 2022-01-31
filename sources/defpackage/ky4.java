package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* renamed from: ky4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ky4 implements LibraryVersionComponent.VersionExtractor {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ky4 f2138a = new ky4();

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public final String extract(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }
}
