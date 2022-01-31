package defpackage;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* renamed from: mm4  reason: default package */
/* compiled from: PickerFragment */
public abstract class mm4<S> extends Fragment {
    public final LinkedHashSet<lm4<S>> f = new LinkedHashSet<>();

    public boolean d(lm4<S> lm4) {
        return this.f.add(lm4);
    }
}
