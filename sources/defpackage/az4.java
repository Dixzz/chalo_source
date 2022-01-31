package defpackage;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: az4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class az4 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ az4 f355a = new az4();

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        nv1.b((Context) componentContainer.get(Context.class));
        return nv1.a().c(iu1.g);
    }
}
