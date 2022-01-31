package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* renamed from: x6  reason: default package */
/* compiled from: LocaleListPlatformWrapper */
public final class x6 implements w6 {

    /* renamed from: a  reason: collision with root package name */
    public final LocaleList f3890a;

    public x6(LocaleList localeList) {
        this.f3890a = localeList;
    }

    @Override // defpackage.w6
    public Object a() {
        return this.f3890a;
    }

    @Override // defpackage.w6
    public Locale b(String[] strArr) {
        return this.f3890a.getFirstMatch(strArr);
    }

    public boolean equals(Object obj) {
        return this.f3890a.equals(((w6) obj).a());
    }

    @Override // defpackage.w6
    public Locale get(int i) {
        return this.f3890a.get(i);
    }

    public int hashCode() {
        return this.f3890a.hashCode();
    }

    @Override // defpackage.w6
    public int size() {
        return this.f3890a.size();
    }

    public String toString() {
        return this.f3890a.toString();
    }
}
