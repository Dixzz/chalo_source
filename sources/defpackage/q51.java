package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.theartofdev.edmodo.cropper.CropImage$ActivityResult;
import java.io.IOException;

/* renamed from: q51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class q51 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f2898a;

    public /* synthetic */ q51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f2898a = superPassUserProofsOverviewFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        CropImage$ActivityResult a1;
        Uri uri;
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f2898a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        if (activityResult.f == -1 && (a1 = hd3.a1(activityResult.g)) != null && (uri = a1.g) != null) {
            String H = hj1.H("randomUUID().toString()");
            ga1 ga1 = superPassUserProofsOverviewFragment.g;
            if (ga1 != null) {
                String str = ga1.d;
                if (str != null) {
                    try {
                        ve activity = superPassUserProofsOverviewFragment.c();
                        if (activity != null) {
                            SuperPassPurchaseSharedViewModel j = superPassUserProofsOverviewFragment.j();
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
