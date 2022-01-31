package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import app.zophop.ui.fragments.UserProofsOverviewFragment;
import com.theartofdev.edmodo.cropper.CropImage$ActivityResult;
import java.io.IOException;

/* renamed from: ct0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ct0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofsOverviewFragment f751a;

    public /* synthetic */ ct0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f751a = userProofsOverviewFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        CropImage$ActivityResult a1;
        Uri uri;
        UserProofsOverviewFragment userProofsOverviewFragment = this.f751a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        if (activityResult.f == -1 && (a1 = hd3.a1(activityResult.g)) != null && (uri = a1.g) != null) {
            String H = hj1.H("randomUUID().toString()");
            g91 g91 = userProofsOverviewFragment.g;
            if (g91 != null) {
                String str = g91.d;
                if (str != null) {
                    try {
                        ve activity = userProofsOverviewFragment.c();
                        if (activity != null) {
                            p81 j = userProofsOverviewFragment.j();
                            String uri2 = uri.toString();
                            n86.d(uri2, "lCurrentLocalPhotoUri.toString()");
                            String str2 = new String();
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), uri);
                            n86.d(bitmap, "getBitmap(it.contentReso…r, lCurrentLocalPhotoUri)");
                            j.j(str, uri2, str2, H, bitmap);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                n86.l("viewModel");
                throw null;
            }
        }
    }
}
