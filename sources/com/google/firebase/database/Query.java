package com.google.firebase.database;

import com.google.firebase.database.core.ChildEventRegistration;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PathIndex;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.ValueIndex;
import java.util.Objects;

public class Query {
    private final boolean orderByCalled;
    public final QueryParams params;
    public final Path path;
    public final Repo repo;

    public Query(Repo repo2, Path path2, QueryParams queryParams, boolean z) throws DatabaseException {
        this.repo = repo2;
        this.path = path2;
        this.params = queryParams;
        this.orderByCalled = z;
        Utilities.hardAssert(queryParams.isValid(), "Validation of queries failed.");
    }

    private void addEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().recordEventRegistration(eventRegistration);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.Query.AnonymousClass3 */

            public void run() {
                Query.this.repo.addEventCallback(eventRegistration);
            }
        });
    }

    private void removeEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().zombifyForRemove(eventRegistration);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.Query.AnonymousClass2 */

            public void run() {
                Query.this.repo.removeEventCallback(eventRegistration);
            }
        });
    }

    private void validateEqualToCall() {
        if (this.params.hasStart()) {
            throw new IllegalArgumentException("Can't call equalTo() and startAt() combined");
        } else if (this.params.hasEnd()) {
            throw new IllegalArgumentException("Can't call equalTo() and endAt() combined");
        }
    }

    private void validateLimit(QueryParams queryParams) {
        if (queryParams.hasStart() && queryParams.hasEnd() && queryParams.hasLimit() && !queryParams.hasAnchoredLimit()) {
            throw new IllegalArgumentException("Can't combine startAt(), endAt() and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private void validateNoOrderByCall() {
        if (this.orderByCalled) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    private void validateQueryEndpoints(QueryParams queryParams) {
        if (queryParams.getIndex().equals(KeyIndex.getInstance())) {
            if (queryParams.hasStart()) {
                Node indexStartValue = queryParams.getIndexStartValue();
                if (!gj1.G(queryParams.getIndexStartName(), ChildKey.getMinName()) || !(indexStartValue instanceof StringNode)) {
                    throw new IllegalArgumentException("You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
                }
            }
            if (queryParams.hasEnd()) {
                Node indexEndValue = queryParams.getIndexEndValue();
                if (!queryParams.getIndexEndName().equals(ChildKey.getMaxName()) || !(indexEndValue instanceof StringNode)) {
                    throw new IllegalArgumentException("You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
                }
            }
        } else if (!queryParams.getIndex().equals(PriorityIndex.getInstance())) {
        } else {
            if ((queryParams.hasStart() && !PriorityUtilities.isValidPriority(queryParams.getIndexStartValue())) || (queryParams.hasEnd() && !PriorityUtilities.isValidPriority(queryParams.getIndexEndValue()))) {
                throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), endAt(), or equalTo() must be valid priorities.");
            }
        }
    }

    public ChildEventListener addChildEventListener(ChildEventListener childEventListener) {
        addEventRegistration(new ChildEventRegistration(this.repo, childEventListener, getSpec()));
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(final ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.repo, new ValueEventListener() {
            /* class com.google.firebase.database.Query.AnonymousClass1 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                valueEventListener.onCancelled(databaseError);
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                Query.this.removeEventListener(this);
                valueEventListener.onDataChange(dataSnapshot);
            }
        }, getSpec()));
    }

    public ValueEventListener addValueEventListener(ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.repo, valueEventListener, getSpec()));
        return valueEventListener;
    }

    public Query endAt(String str) {
        return endAt(str, (String) null);
    }

    public Query equalTo(String str) {
        validateEqualToCall();
        return startAt(str).endAt(str);
    }

    public Path getPath() {
        return this.path;
    }

    public DatabaseReference getRef() {
        return new DatabaseReference(this.repo, getPath());
    }

    public Repo getRepo() {
        return this.repo;
    }

    public QuerySpec getSpec() {
        return new QuerySpec(this.path, this.params);
    }

    public void keepSynced(final boolean z) {
        if (this.path.isEmpty() || !this.path.getFront().equals(ChildKey.getInfoKey())) {
            this.repo.scheduleNow(new Runnable() {
                /* class com.google.firebase.database.Query.AnonymousClass4 */

                public void run() {
                    Query query = Query.this;
                    query.repo.keepSynced(query.getSpec(), z);
                }
            });
            return;
        }
        throw new DatabaseException("Can't call keepSynced() on .info paths.");
    }

    public Query limitToFirst(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.params.hasLimit()) {
            return new Query(this.repo, this.path, this.params.limitToFirst(i), this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query limitToLast(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.params.hasLimit()) {
            return new Query(this.repo, this.path, this.params.limitToLast(i), this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query orderByChild(String str) {
        Objects.requireNonNull(str, "Key can't be null");
        if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException(hj1.T("Can't use '", str, "' as path, please use orderByKey() instead!"));
        } else if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException(hj1.T("Can't use '", str, "' as path, please use orderByPriority() instead!"));
        } else if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException(hj1.T("Can't use '", str, "' as path, please use orderByValue() instead!"));
        } else {
            Validation.validatePathString(str);
            validateNoOrderByCall();
            Path path2 = new Path(str);
            if (path2.size() != 0) {
                return new Query(this.repo, this.path, this.params.orderBy(new PathIndex(path2)), true);
            }
            throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
        }
    }

    public Query orderByKey() {
        validateNoOrderByCall();
        QueryParams orderBy = this.params.orderBy(KeyIndex.getInstance());
        validateQueryEndpoints(orderBy);
        return new Query(this.repo, this.path, orderBy, true);
    }

    public Query orderByPriority() {
        validateNoOrderByCall();
        QueryParams orderBy = this.params.orderBy(PriorityIndex.getInstance());
        validateQueryEndpoints(orderBy);
        return new Query(this.repo, this.path, orderBy, true);
    }

    public Query orderByValue() {
        validateNoOrderByCall();
        return new Query(this.repo, this.path, this.params.orderBy(ValueIndex.getInstance()), true);
    }

    public void removeEventListener(ValueEventListener valueEventListener) {
        Objects.requireNonNull(valueEventListener, "listener must not be null");
        removeEventRegistration(new ValueEventRegistration(this.repo, valueEventListener, getSpec()));
    }

    public Query startAt(String str) {
        return startAt(str, (String) null);
    }

    public Query endAt(double d) {
        return endAt(d, (String) null);
    }

    public Query startAt(double d) {
        return startAt(d, (String) null);
    }

    public Query endAt(boolean z) {
        return endAt(z, (String) null);
    }

    public Query equalTo(double d) {
        validateEqualToCall();
        return startAt(d).endAt(d);
    }

    public void removeEventListener(ChildEventListener childEventListener) {
        Objects.requireNonNull(childEventListener, "listener must not be null");
        removeEventRegistration(new ChildEventRegistration(this.repo, childEventListener, getSpec()));
    }

    public Query startAt(boolean z) {
        return startAt(z, (String) null);
    }

    public Query endAt(String str, String str2) {
        return endAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    public Query startAt(String str, String str2) {
        return startAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    public Query equalTo(boolean z) {
        validateEqualToCall();
        return startAt(z).endAt(z);
    }

    public Query endAt(double d, String str) {
        return endAt(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    public Query startAt(double d, String str) {
        return startAt(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    public Query(Repo repo2, Path path2) {
        this.repo = repo2;
        this.path = path2;
        this.params = QueryParams.DEFAULT_PARAMS;
        this.orderByCalled = false;
    }

    public Query endAt(boolean z, String str) {
        return endAt(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }

    public Query equalTo(String str, String str2) {
        validateEqualToCall();
        return startAt(str, str2).endAt(str, str2);
    }

    public Query startAt(boolean z, String str) {
        return startAt(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }

    private Query endAt(Node node, String str) {
        Validation.validateNullableKey(str);
        if (node.isLeafNode() || node.isEmpty()) {
            ChildKey fromString = str != null ? ChildKey.fromString(str) : null;
            if (!this.params.hasEnd()) {
                QueryParams endAt = this.params.endAt(node, fromString);
                validateLimit(endAt);
                validateQueryEndpoints(endAt);
                Utilities.hardAssert(endAt.isValid());
                return new Query(this.repo, this.path, endAt, this.orderByCalled);
            }
            throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
        }
        throw new IllegalArgumentException("Can only use simple values for endAt()");
    }

    private Query startAt(Node node, String str) {
        Validation.validateNullableKey(str);
        if (!node.isLeafNode() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt()");
        } else if (!this.params.hasStart()) {
            QueryParams startAt = this.params.startAt(node, str != null ? ChildKey.fromString(str) : null);
            validateLimit(startAt);
            validateQueryEndpoints(startAt);
            Utilities.hardAssert(startAt.isValid());
            return new Query(this.repo, this.path, startAt, this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call startAt() or equalTo() multiple times");
        }
    }

    public Query equalTo(double d, String str) {
        validateEqualToCall();
        return startAt(d, str).endAt(d, str);
    }

    public Query equalTo(boolean z, String str) {
        validateEqualToCall();
        return startAt(z, str).endAt(z, str);
    }
}
