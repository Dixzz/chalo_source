package app.zophop.ui.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.ui.views.ZoomableImageView;

public class ZoomedImageViewActivity extends wt {
    public String l;
    public String m;
    public boolean n;
    public boolean o;

    public static void h0(Activity activity, ImageView imageView, String str, String str2) {
        Intent intent = new Intent(activity, ZoomedImageViewActivity.class);
        intent.putExtra("picture_uri_extra", str);
        intent.putExtra("zoomed_image_title", (String) null);
        imageView.setTransitionName("zoom_picture_view");
        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity, imageView, "zoom_picture_view").toBundle());
    }

    public static void i0(Activity activity, ImageView imageView, String str, String str2, boolean z) {
        Intent intent = new Intent(activity, ZoomedImageViewActivity.class);
        intent.putExtra("picture_uri_extra", str);
        intent.putExtra("zoomed_image_title", (String) null);
        intent.putExtra("is_pinch_to_zoom", z);
        imageView.setTransitionName("zoom_picture_view");
        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity, imageView, "zoom_picture_view").toBundle());
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        g30 g30 = new g30(getIntent());
        if (g30.a()) {
            this.m = g30.f1208a.get("source");
            this.l = g30.f1208a.get(ProductPromotionsObject.KEY_TITLE);
        } else {
            Intent intent = getIntent();
            this.m = intent.getStringExtra("picture_uri_extra");
            this.l = intent.getStringExtra("zoomed_image_title");
            this.n = intent.getBooleanExtra("show_title", false);
            this.o = intent.getBooleanExtra("is_pinch_to_zoom", false);
        }
        if (this.l == null) {
            this.l = getString(R.string.zoomed_picture_title);
        } else {
            this.n = true;
        }
        if (this.m != null) {
            setContentView(R.layout.zoomed_image_activity);
            if (this.n) {
                Toolbar toolbar = (Toolbar) findViewById(R.id.zoomed_image_toolbar);
                toolbar.setVisibility(0);
                setSupportActionBar(toolbar);
                getSupportActionBar().z(this.l);
                getSupportActionBar().o(true);
            }
            if (!this.o) {
                ImageView imageView = (ImageView) findViewById(R.id.zoomed_image);
                findViewById(R.id.pinch_to_zoom_image).setVisibility(8);
                imageView.setTransitionName("zoom_picture_view");
                ml1<Bitmap> j = gl1.g(this).j();
                j.h(this.m);
                j.f(new rh0(this, imageView));
                return;
            }
            findViewById(R.id.zoomed_image).setVisibility(8);
            ZoomableImageView zoomableImageView = (ZoomableImageView) findViewById(R.id.pinch_to_zoom_image);
            zoomableImageView.setVisibility(0);
            zoomableImageView.setTransitionName("zoom_picture_view");
            ml1<Bitmap> j2 = gl1.g(this).j();
            j2.h(this.m);
            j2.f(new sh0(this, zoomableImageView));
            return;
        }
        throw new RuntimeException("No image found to show. Please ensure you have set a URI properly");
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        supportFinishAfterTransition();
        super.onBackPressed();
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
