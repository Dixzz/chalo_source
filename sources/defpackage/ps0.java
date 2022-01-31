package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.ui.fragments.UserProofUploadFragment;
import com.theartofdev.edmodo.cropper.CropImage$ActivityResult;
import java.io.IOException;

/* renamed from: ps0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ps0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofUploadFragment f2843a;

    public /* synthetic */ ps0(UserProofUploadFragment userProofUploadFragment) {
        this.f2843a = userProofUploadFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        CropImage$ActivityResult a1;
        Uri uri;
        UserProofUploadFragment userProofUploadFragment = this.f2843a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        if (activityResult.f == -1 && (a1 = hd3.a1(activityResult.g)) != null && (uri = a1.g) != null) {
            String H = hj1.H("randomUUID()\n           …              .toString()");
            f91 f91 = userProofUploadFragment.g;
            if (f91 != null) {
                ProofDocumentProps proofDocumentProps = f91.d;
                String uri2 = uri.toString();
                n86.d(uri2, "lCurrentLocalPhotoUri.toString()");
                f91.d(uri2);
                try {
                    ve activity = userProofUploadFragment.c();
                    if (activity != null) {
                        p81 j = userProofUploadFragment.j();
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
                n86.f(userProofUploadFragment, "$this$findNavController");
                NavController d = NavHostFragment.d(userProofUploadFragment);
                n86.b(d, "NavHostFragment.findNavController(this)");
                d.g();
                return;
            }
            n86.l("viewModel");
            throw null;
        }
    }
}
