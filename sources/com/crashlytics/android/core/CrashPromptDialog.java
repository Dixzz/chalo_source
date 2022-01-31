package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;

public class CrashPromptDialog {
    private final AlertDialog.Builder dialog;
    private final OptInLatch latch;

    public interface AlwaysSendCallback {
        void sendUserReportsWithoutPrompting(boolean z);
    }

    public static class OptInLatch {
        private final CountDownLatch latch;
        private boolean send;

        private OptInLatch() {
            this.send = false;
            this.latch = new CountDownLatch(1);
        }

        public void await() {
            try {
                this.latch.await();
            } catch (InterruptedException unused) {
            }
        }

        public boolean getOptIn() {
            return this.send;
        }

        public void setOptIn(boolean z) {
            this.send = z;
            this.latch.countDown();
        }
    }

    private CrashPromptDialog(AlertDialog.Builder builder, OptInLatch optInLatch) {
        this.latch = optInLatch;
        this.dialog = builder;
    }

    public static CrashPromptDialog create(Activity activity, a26 a26, AlwaysSendCallback alwaysSendCallback) {
        final OptInLatch optInLatch = new OptInLatch();
        DialogStringResolver dialogStringResolver = new DialogStringResolver(activity, a26);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView createDialogView = createDialogView(activity, dialogStringResolver.getMessage());
        builder.setView(createDialogView).setTitle(dialogStringResolver.getTitle()).setCancelable(false).setNeutralButton(dialogStringResolver.getSendButtonTitle(), new DialogInterface.OnClickListener() {
            /* class com.crashlytics.android.core.CrashPromptDialog.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                optInLatch.setOptIn(true);
                dialogInterface.dismiss();
            }
        });
        throw null;
    }

    private static ScrollView createDialogView(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int dipsToPixels = dipsToPixels(f, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(dipsToPixels, dipsToPixels, dipsToPixels, dipsToPixels);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(dipsToPixels(f, 14), dipsToPixels(f, 2), dipsToPixels(f, 10), dipsToPixels(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private static int dipsToPixels(float f, int i) {
        return (int) (f * ((float) i));
    }

    public void await() {
        this.latch.await();
    }

    public boolean getOptIn() {
        return this.latch.getOptIn();
    }

    public void show() {
        this.dialog.show();
    }
}
