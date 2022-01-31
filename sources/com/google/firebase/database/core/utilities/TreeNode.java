package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    public String toString(String str) {
        StringBuilder k0 = hj1.k0(str, "<value>: ");
        k0.append((Object) this.value);
        k0.append("\n");
        String sb = k0.toString();
        if (this.children.isEmpty()) {
            return hj1.T(sb, str, "<empty>");
        }
        for (Map.Entry<ChildKey, TreeNode<T>> entry : this.children.entrySet()) {
            StringBuilder k02 = hj1.k0(sb, str);
            k02.append(entry.getKey());
            k02.append(":\n");
            k02.append(entry.getValue().toString(str + "\t"));
            k02.append("\n");
            sb = k02.toString();
        }
        return sb;
    }
}
