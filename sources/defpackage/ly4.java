package defpackage;

import android.content.Context;
import android.os.Build;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* renamed from: ly4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ly4 implements LibraryVersionComponent.VersionExtractor {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ly4 f2295a = new ly4();

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public final String extract(Object obj) {
        Context context = (Context) obj;
        int i = Build.VERSION.SDK_INT;
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            return "tv";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            return "watch";
        }
        if (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
        }
        return "auto";
    }
}
