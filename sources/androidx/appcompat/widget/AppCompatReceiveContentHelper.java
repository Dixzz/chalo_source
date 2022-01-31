package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.core.R;
import defpackage.b8;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppCompatReceiveContentHelper {
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final String LOG_TAG = "ReceiveContent";

    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        /* JADX INFO: finally extract failed */
        public static boolean onDropForTextView(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                r8.q(textView, new b8(new b8.a(dragEvent.getClipData(), 3)));
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        public static boolean onDropForView(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            r8.q(view, new b8(new b8.a(dragEvent.getClipData(), 3)));
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    public static k9 createOnCommitContentListener(final View view) {
        return new k9() {
            /* class androidx.appcompat.widget.AppCompatReceiveContentHelper.AnonymousClass1 */

            @Override // defpackage.k9
            public boolean onCommitContent(l9 l9Var, int i, Bundle bundle) {
                if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                    try {
                        l9Var.f2187a.b();
                        InputContentInfo inputContentInfo = (InputContentInfo) l9Var.f2187a.d();
                        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                        bundle.putParcelable(AppCompatReceiveContentHelper.EXTRA_INPUT_CONTENT_INFO, inputContentInfo);
                    } catch (Exception unused) {
                        return false;
                    }
                }
                b8.a aVar = new b8.a(new ClipData(l9Var.f2187a.getDescription(), new ClipData.Item(l9Var.f2187a.a())), 2);
                aVar.d = l9Var.f2187a.c();
                aVar.e = bundle;
                if (r8.q(view, new b8(aVar)) == null) {
                    return true;
                }
                return false;
            }
        };
    }

    public static boolean maybeHandleDragEventViaPerformReceiveContent(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (((String[]) view.getTag(R.id.tag_on_receive_content_mime_types)) != null) {
                Activity tryGetActivity = tryGetActivity(view);
                if (tryGetActivity == null) {
                    String str = "Can't handle drop: no activity: view=" + view;
                    return false;
                } else if (dragEvent.getAction() == 1) {
                    return !(view instanceof TextView);
                } else {
                    if (dragEvent.getAction() == 3) {
                        if (view instanceof TextView) {
                            return OnDropApi24Impl.onDropForTextView(dragEvent, (TextView) view, tryGetActivity);
                        }
                        return OnDropApi24Impl.onDropForView(dragEvent, view, tryGetActivity);
                    }
                }
            }
        }
        return false;
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView textView, int i) {
        ClipData clipData;
        int i2 = 0;
        if (i == 16908322 || i == 16908337) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (((String[]) textView.getTag(R.id.tag_on_receive_content_mime_types)) != null) {
                ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
                if (clipboardManager == null) {
                    clipData = null;
                } else {
                    clipData = clipboardManager.getPrimaryClip();
                }
                if (clipData != null && clipData.getItemCount() > 0) {
                    b8.a aVar = new b8.a(clipData, 1);
                    if (i != 16908322) {
                        i2 = 1;
                    }
                    aVar.c = i2;
                    r8.q(textView, new b8(aVar));
                }
                return true;
            }
        }
        return false;
    }

    public static Activity tryGetActivity(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
