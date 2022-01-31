package butterknife.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ViewInjection {
    private final int id;
    private final LinkedHashMap<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>> listenerBindings = new LinkedHashMap<>();
    private final Set<ViewBinding> viewBindings = new LinkedHashSet();

    public ViewInjection(int i) {
        this.id = i;
    }

    public void addListenerBinding(ListenerClass listenerClass, ListenerMethod listenerMethod, ListenerBinding listenerBinding) {
        Set<ListenerBinding> set;
        Map<ListenerMethod, Set<ListenerBinding>> map = this.listenerBindings.get(listenerClass);
        if (map == null) {
            map = new LinkedHashMap<>();
            this.listenerBindings.put(listenerClass, map);
            set = null;
        } else {
            set = map.get(listenerMethod);
        }
        if (set == null) {
            set = new LinkedHashSet<>();
            map.put(listenerMethod, set);
        }
        set.add(listenerBinding);
    }

    public void addViewBinding(ViewBinding viewBinding) {
        this.viewBindings.add(viewBinding);
    }

    public int getId() {
        return this.id;
    }

    public Map<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>> getListenerBindings() {
        return this.listenerBindings;
    }

    public List<Binding> getRequiredBindings() {
        ArrayList arrayList = new ArrayList();
        for (ViewBinding viewBinding : this.viewBindings) {
            if (viewBinding.isRequired()) {
                arrayList.add(viewBinding);
            }
        }
        for (Map<ListenerMethod, Set<ListenerBinding>> map : this.listenerBindings.values()) {
            for (Set<ListenerBinding> set : map.values()) {
                for (ListenerBinding listenerBinding : set) {
                    if (listenerBinding.isRequired()) {
                        arrayList.add(listenerBinding);
                    }
                }
            }
        }
        return arrayList;
    }

    public Collection<ViewBinding> getViewBindings() {
        return this.viewBindings;
    }

    public boolean hasListenerBinding(ListenerClass listenerClass, ListenerMethod listenerMethod) {
        Map<ListenerMethod, Set<ListenerBinding>> map = this.listenerBindings.get(listenerClass);
        return map != null && map.containsKey(listenerMethod);
    }
}
