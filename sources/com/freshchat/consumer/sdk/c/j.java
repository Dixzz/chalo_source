package com.freshchat.consumer.sdk.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.c.a.l;
import com.freshchat.consumer.sdk.j.as;
import java.util.List;
import java.util.Map;

public class j extends b {
    private Context context;

    public j(Context context2) {
        super(context2);
        this.context = context2.getApplicationContext();
    }

    public static String a(int i, Tag.TaggedType... taggedTypeArr) {
        if (i == 0) {
            return null;
        }
        StringBuilder k0 = hj1.k0("name", " IN (");
        k0.append(as.a("?", ",", i));
        k0.append(")");
        if (taggedTypeArr != null && taggedTypeArr.length > 0) {
            k0.append(" AND ");
            k0.append("tagged_type");
            k0.append(" IN (");
            int length = taggedTypeArr.length;
            int i2 = 0;
            String str = "";
            while (i2 < length) {
                Tag.TaggedType taggedType = taggedTypeArr[i2];
                k0.append(str);
                k0.append("\"");
                k0.append(taggedType.asInt());
                k0.append("\"");
                i2++;
                str = ",";
            }
            k0.append(")");
        }
        return k0.toString();
    }

    @Override // com.freshchat.consumer.sdk.c.b
    public Map<String, Integer> a(Cursor cursor) {
        return null;
    }

    public void a(Tag.TaggedType taggedType) {
        cs().delete("tags", "tagged_type = ? ", new String[]{Integer.toString(taggedType.asInt())});
    }

    public void f(List<Tag> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new l().cS());
        if (compileStatement != null) {
            for (int i = 0; i < list.size(); i++) {
                Tag tag = list.get(i);
                compileStatement.clearBindings();
                compileStatement.bindString(1, tag.getTagName());
                compileStatement.bindString(2, tag.getTaggedItemId());
                compileStatement.bindString(3, Integer.toString(tag.getTaggedItemType().asInt()));
                compileStatement.execute();
            }
            b.a(compileStatement);
        }
    }
}
