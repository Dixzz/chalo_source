package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: xw4  reason: default package */
public abstract class xw4 extends pw4 implements yw4 {
    public static yw4 F(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof yw4 ? (yw4) queryLocalInterface : new ww4(iBinder);
    }
}
