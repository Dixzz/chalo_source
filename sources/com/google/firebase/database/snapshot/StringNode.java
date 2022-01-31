package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

public class StringNode extends LeafNode<StringNode> {
    private final String value;

    /* renamed from: com.google.firebase.database.snapshot.StringNode$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.google.firebase.database.snapshot.Node.HashVersion.values()
                r0 = 2
                int[] r1 = new int[r0]
                com.google.firebase.database.snapshot.StringNode.AnonymousClass1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion = r1
                r2 = 1
                com.google.firebase.database.snapshot.Node$HashVersion r3 = com.google.firebase.database.snapshot.Node.HashVersion.V1     // Catch:{ NoSuchFieldError -> 0x000e }
                r3 = 0
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r1 = com.google.firebase.database.snapshot.StringNode.AnonymousClass1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.database.snapshot.Node$HashVersion r3 = com.google.firebase.database.snapshot.Node.HashVersion.V2     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.snapshot.StringNode.AnonymousClass1.<clinit>():void");
        }
    }

    public StringNode(String str, Node node) {
        super(node);
        this.value = str;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object obj) {
        if (!(obj instanceof StringNode)) {
            return false;
        }
        StringNode stringNode = (StringNode) obj;
        if (!this.value.equals(stringNode.value) || !this.priority.equals(stringNode.priority)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        int ordinal = hashVersion.ordinal();
        if (ordinal == 0) {
            return getPriorityHash(hashVersion) + "string:" + this.value;
        } else if (ordinal == 1) {
            return getPriorityHash(hashVersion) + "string:" + Utilities.stringHashV2Representation(this.value);
        } else {
            throw new IllegalArgumentException("Invalid hash version for string node: " + hashVersion);
        }
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.String;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return this.priority.hashCode() + this.value.hashCode();
    }

    public int compareLeafValues(StringNode stringNode) {
        return this.value.compareTo(stringNode.value);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public StringNode updatePriority(Node node) {
        return new StringNode(this.value, node);
    }
}
