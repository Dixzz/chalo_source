package defpackage;

import android.content.Context;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* renamed from: iy4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class iy4 implements LibraryVersionComponent.VersionExtractor {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ iy4 f1584a = new iy4();

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public final String extract(Object obj) {
        return FirebaseCommonRegistrar.a((Context) obj);
    }
}
