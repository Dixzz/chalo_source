package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

public class AlertController {
    public NestedScrollView A;
    public int B = 0;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int I = -1;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler Q;
    public final View.OnClickListener R = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Context f193a;
    public final n0 b;
    public final Window c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public ListView g;
    public View h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n = false;
    public Button o;
    public CharSequence p;
    public Message q;
    public Drawable r;
    public Button s;
    public CharSequence t;
    public Message u;
    public Drawable v;
    public Button w;
    public CharSequence x;
    public Message y;
    public Drawable z;

    public static class RecycleListView extends ListView {
        public final int f;
        public final int g;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.g = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.o && (message4 = alertController.q) != null) {
                message = Message.obtain(message4);
            } else if (view != alertController.s || (message3 = alertController.u) == null) {
                message = (view != alertController.w || (message2 = alertController.y) == null) ? null : Message.obtain(message2);
            } else {
                message = Message.obtain(message3);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.Q.obtainMessage(1, alertController2.b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f194a;
        public final LayoutInflater b;
        public Drawable c;
        public CharSequence d;
        public View e;
        public CharSequence f;
        public CharSequence g;
        public DialogInterface.OnClickListener h;
        public CharSequence i;
        public DialogInterface.OnClickListener j;
        public boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnKeyListener m;
        public CharSequence[] n;
        public ListAdapter o;
        public DialogInterface.OnClickListener p;
        public View q;
        public boolean r;
        public int s = -1;

        public b(Context context) {
            this.f194a = context;
            this.k = true;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    public static final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<DialogInterface> f195a;

        public c(DialogInterface dialogInterface) {
            this.f195a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f195a.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, n0 n0Var, Window window) {
        this.f193a = context;
        this.b = n0Var;
        this.c = window;
        this.Q = new c(n0Var);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        n0Var.c(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void c(View view, View view2, View view3) {
        int i2 = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i2 = 0;
            }
            view3.setVisibility(i2);
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public final ViewGroup d(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public void e(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        Message obtainMessage = onClickListener != null ? this.Q.obtainMessage(i2, onClickListener) : null;
        if (i2 == -3) {
            this.x = charSequence;
            this.y = obtainMessage;
            this.z = null;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = obtainMessage;
            this.v = null;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = obtainMessage;
            this.r = null;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }
}
