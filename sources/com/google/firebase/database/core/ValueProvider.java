package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;

public abstract class ValueProvider {

    public static class DeferredValueProvider extends ValueProvider {
        private final Path path;
        private final SyncTree syncTree;

        public DeferredValueProvider(SyncTree syncTree2, Path path2) {
            this.syncTree = syncTree2;
            this.path = path2;
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public ValueProvider getImmediateChild(ChildKey childKey) {
            return new DeferredValueProvider(this.syncTree, this.path.child(childKey));
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public Node node() {
            return this.syncTree.calcCompleteEventCache(this.path, new ArrayList());
        }
    }

    public static class ExistingValueProvider extends ValueProvider {
        private final Node node;

        public ExistingValueProvider(Node node2) {
            this.node = node2;
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public ValueProvider getImmediateChild(ChildKey childKey) {
            return new ExistingValueProvider(this.node.getImmediateChild(childKey));
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public Node node() {
            return this.node;
        }
    }

    public abstract ValueProvider getImmediateChild(ChildKey childKey);

    public abstract Node node();
}
