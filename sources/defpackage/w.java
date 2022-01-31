package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;

/* renamed from: w  reason: default package */
/* compiled from: ActivityResultContracts */
public final class w extends t<Intent, ActivityResult> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // defpackage.t
    public Intent a(Context context, Intent intent) {
        return intent;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.t
    public ActivityResult c(int i, Intent intent) {
        return new ActivityResult(i, intent);
    }
}
