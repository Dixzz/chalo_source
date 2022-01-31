package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.theartofdev.edmodo.cropper.CropImageActivity;
import com.theartofdev.edmodo.cropper.CropImageOptions;

/* renamed from: wf5  reason: default package */
/* compiled from: CropImage */
public final class wf5 {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f3772a;
    public final CropImageOptions b = new CropImageOptions();

    public wf5(Uri uri, vf5 vf5) {
        this.f3772a = uri;
    }

    public Intent a(Context context) {
        this.b.a();
        Intent intent = new Intent();
        intent.setClass(context, CropImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("CROP_IMAGE_EXTRA_SOURCE", this.f3772a);
        bundle.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", this.b);
        intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
        return intent;
    }
}
