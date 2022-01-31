package app.zophop.ui.views;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.views.AppSharingView;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import defpackage.li1;
import java.util.Objects;

public class AppSharingView$$ViewInjector {

    /* compiled from: AppSharingView$$ViewInjector */
    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ AppSharingView f;

        public a(AppSharingView appSharingView) {
            this.f = appSharingView;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            AppSharingView appSharingView = this.f;
            Objects.requireNonNull(appSharingView);
            li1.a aVar = li1.a.FACEBOOK;
            appSharingView.a(aVar);
            AppSharingView.a aVar2 = appSharingView.f;
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
        }
    }

    /* compiled from: AppSharingView$$ViewInjector */
    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ AppSharingView f;

        public b(AppSharingView appSharingView) {
            this.f = appSharingView;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            AppSharingView appSharingView = this.f;
            Objects.requireNonNull(appSharingView);
            li1.a aVar = li1.a.TWITTER;
            appSharingView.a(aVar);
            AppSharingView.a aVar2 = appSharingView.f;
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
        }
    }

    /* compiled from: AppSharingView$$ViewInjector */
    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ AppSharingView f;

        public c(AppSharingView appSharingView) {
            this.f = appSharingView;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            AppSharingView appSharingView = this.f;
            Objects.requireNonNull(appSharingView);
            li1.a aVar = li1.a.GOOGLE;
            appSharingView.a(aVar);
            AppSharingView.a aVar2 = appSharingView.f;
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
        }
    }

    public static void inject(ButterKnife.Finder finder, AppSharingView appSharingView, Object obj) {
        finder.findRequiredView(obj, R.id.share_facebook, "method 'onFbSharedClick'").setOnClickListener(new a(appSharingView));
        finder.findRequiredView(obj, R.id.share_twitter, "method 'onTwitterSharedClick'").setOnClickListener(new b(appSharingView));
        finder.findRequiredView(obj, R.id.share_google, "method 'onGoogleSharedClicked'").setOnClickListener(new c(appSharingView));
    }

    public static void reset(AppSharingView appSharingView) {
    }
}
