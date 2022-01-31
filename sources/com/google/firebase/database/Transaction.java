package com.google.firebase.database;

import com.google.firebase.database.snapshot.Node;

public class Transaction {

    public interface Handler {
        Result doTransaction(MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot);
    }

    public static class Result {
        private Node data;
        private boolean success;

        public Node getNode() {
            return this.data;
        }

        public boolean isSuccess() {
            return this.success;
        }

        private Result(boolean z, Node node) {
            this.success = z;
            this.data = node;
        }
    }

    public static Result abort() {
        return new Result(false, null);
    }

    public static Result success(MutableData mutableData) {
        return new Result(true, mutableData.getNode());
    }
}
