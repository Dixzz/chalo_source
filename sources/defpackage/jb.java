package defpackage;

import java.io.File;

/* renamed from: jb  reason: default package */
/* compiled from: PreferenceDataStoreFactory.kt */
public final class jb extends o86 implements h76<File> {
    public final /* synthetic */ h76<File> f;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: h76<? extends java.io.File> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public jb(h76<? extends File> h76) {
        super(0);
        this.f = h76;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public File invoke() {
        File invoke = this.f.invoke();
        n86.e(invoke, "$this$extension");
        String name = invoke.getName();
        n86.d(name, "name");
        if (n86.a(ea6.I(name, '.', ""), "preferences_pb")) {
            return invoke;
        }
        throw new IllegalStateException(("File extension for file: " + invoke + " does not match required extension for Preferences file: " + "preferences_pb").toString());
    }
}
