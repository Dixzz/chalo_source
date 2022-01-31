package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.theartofdev.edmodo.cropper.CropImage$ActivityResult;
import java.io.IOException;

/* renamed from: g51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class g51 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofUploadFragment f1216a;

    public /* synthetic */ g51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment) {
        this.f1216a = superPassUserProofUploadFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        CropImage$ActivityResult a1;
        Uri uri;
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f1216a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        if (activityResult.f == -1 && (a1 = hd3.a1(activityResult.g)) != null && (uri = a1.g) != null) {
            String H = hj1.H("randomUUID()\n           …              .toString()");
            fa1 fa1 = superPassUserProofUploadFragment.g;
            if (fa1 != null) {
                ProofDocumentProps proofDocumentProps = fa1.d;
                String uri2 = uri.toString();
                n86.d(uri2, "lCurrentLocalPhotoUri.toString()");
                fa1.d(uri2);
                try {
                    ve activity = superPassUserProofUploadFragment.c();
                    if (activity != null) {
                        SuperPassPurchaseSharedViewModel j = superPassUserProofUploadFragment.j();
                        String proofId = proofDocumentProps.getProofId();
                        String uri3 = uri.toString();
                        n86.d(uri3, "lCurrentLocalPhotoUri.toString()");
                        String str = new String();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), uri);
                        n86.d(bitmap, "getBitmap(it.contentReso…r, lCurrentLocalPhotoUri)");
                        j.j(proofId, uri3, str, H, bitmap);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                n86.f(superPassUserProofUploadFragment, "$this$findNavController");
                NavController d = NavHostFragment.d(superPassUserProofUploadFragment);
                n86.b(d, "NavHostFragment.findNavController(this)");
                d.g();
                return;
            }
            n86.l("viewModel");
            throw null;
        }
    }
}
