package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* renamed from: jy4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class jy4 implements LibraryVersionComponent.VersionExtractor {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ jy4 f1995a = new jy4();

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public final String extract(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }
}
