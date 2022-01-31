package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.j.k;
import java.util.List;

public class e extends RecyclerView.e<b> {
    private final Context context;
    private final LayoutInflater cr;
    private final List<MessageFragment> mX;
    private final a mY;
    private final long originalMessageId;

    public interface a {
        void a(QuickReplyButtonFragment quickReplyButtonFragment, long j);
    }

    public class b extends RecyclerView.a0 {
        private final TextView nb;

        public b(View view) {
            super(view);
            this.nb = (TextView) view.findViewById(R.id.drop_down_list_item_text);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private TextView gX() {
            return this.nb;
        }
    }

    public e(Context context2, List<MessageFragment> list, a aVar, long j) {
        this.mX = list;
        this.mY = aVar;
        this.cr = LayoutInflater.from(context2);
        this.originalMessageId = j;
        this.context = context2;
    }

    private MessageFragment F(int i) {
        if (k.isEmpty(this.mX)) {
            return null;
        }
        return this.mX.get(i);
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        TextView gX = bVar.gX();
        MessageFragment F = F(i);
        if (F instanceof QuickReplyButtonFragment) {
            com.freshchat.consumer.sdk.k.e eVar = new com.freshchat.consumer.sdk.k.e(this.context);
            eVar.b((QuickReplyButtonFragment) F);
            gX.setText(eVar.jL());
            bVar.gX().setOnClickListener(new f(this, F));
        }
    }

    /* renamed from: b */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(this.cr.inflate(R.layout.freshchat_listitem_dropdown, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return k.b(this.mX);
    }
}
