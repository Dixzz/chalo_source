package butterknife.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ViewInjector {
    private final String className;
    private final String classPackage;
    private final Map<CollectionBinding, int[]> collectionBindings = new LinkedHashMap();
    private String parentInjector;
    private final String targetClass;
    private final Map<Integer, ViewInjection> viewIdMap = new LinkedHashMap();

    /* renamed from: butterknife.internal.ViewInjector$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$butterknife$internal$CollectionBinding$Kind;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                butterknife.internal.CollectionBinding.Kind.values()
                r0 = 2
                int[] r1 = new int[r0]
                butterknife.internal.ViewInjector.AnonymousClass1.$SwitchMap$butterknife$internal$CollectionBinding$Kind = r1
                r2 = 1
                butterknife.internal.CollectionBinding$Kind r3 = butterknife.internal.CollectionBinding.Kind.ARRAY     // Catch:{ NoSuchFieldError -> 0x000e }
                r3 = 0
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r1 = butterknife.internal.ViewInjector.AnonymousClass1.$SwitchMap$butterknife$internal$CollectionBinding$Kind     // Catch:{ NoSuchFieldError -> 0x0014 }
                butterknife.internal.CollectionBinding$Kind r3 = butterknife.internal.CollectionBinding.Kind.LIST     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: butterknife.internal.ViewInjector.AnonymousClass1.<clinit>():void");
        }
    }

    public ViewInjector(String str, String str2, String str3) {
        this.classPackage = str;
        this.className = str2;
        this.targetClass = str3;
    }

    public static void emitCastIfNeeded(StringBuilder sb, String str) {
        emitCastIfNeeded(sb, ButterKnifeProcessor.VIEW_TYPE, str);
    }

    private void emitCollectionBinding(StringBuilder sb, CollectionBinding collectionBinding, int[] iArr) {
        sb.append("    target.");
        sb.append(collectionBinding.getName());
        sb.append(" = ");
        int ordinal = collectionBinding.getKind().ordinal();
        if (ordinal == 0) {
            sb.append("Finder.arrayOf(");
        } else if (ordinal == 1) {
            sb.append("Finder.listOf(");
        } else {
            StringBuilder i0 = hj1.i0("Unknown kind: ");
            i0.append(collectionBinding.getKind());
            throw new IllegalStateException(i0.toString());
        }
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append("\n        ");
            emitCastIfNeeded(sb, collectionBinding.getType());
            if (collectionBinding.isRequired()) {
                sb.append("finder.findRequiredView(source, ");
                sb.append(iArr[i]);
                sb.append(", \"");
                sb.append(collectionBinding.getName());
                sb.append("\")");
            } else {
                sb.append("finder.findOptionalView(source, ");
                sb.append(iArr[i]);
                sb.append(")");
            }
        }
        sb.append("\n    );");
    }

    public static void emitHumanDescription(StringBuilder sb, List<Binding> list) {
        int size = list.size();
        if (size == 1) {
            sb.append(list.get(0).getDescription());
        } else if (size != 2) {
            int size2 = list.size();
            for (int i = 0; i < size2; i++) {
                Binding binding = list.get(i);
                if (i != 0) {
                    sb.append(", ");
                }
                if (i == size2 - 1) {
                    sb.append("and ");
                }
                sb.append(binding.getDescription());
            }
        } else {
            sb.append(list.get(0).getDescription());
            sb.append(" and ");
            sb.append(list.get(1).getDescription());
        }
    }

    private void emitInject(StringBuilder sb) {
        sb.append("  public static void inject(Finder finder, final ");
        sb.append(this.targetClass);
        sb.append(" target, Object source) {\n");
        if (this.parentInjector != null) {
            sb.append("    ");
            sb.append(this.parentInjector);
            sb.append(".inject(finder, target, source);\n\n");
        }
        sb.append("    View view;\n");
        for (ViewInjection viewInjection : this.viewIdMap.values()) {
            emitViewInjection(sb, viewInjection);
        }
        for (Map.Entry<CollectionBinding, int[]> entry : this.collectionBindings.entrySet()) {
            emitCollectionBinding(sb, entry.getKey(), entry.getValue());
        }
        sb.append("  }\n");
    }

    private void emitListenerBindings(StringBuilder sb, ViewInjection viewInjection) {
        String str;
        Map<ListenerMethod, Set<ListenerBinding>> map;
        Iterator<Map.Entry<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>>> it;
        Map<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>> listenerBindings = viewInjection.getListenerBindings();
        if (!listenerBindings.isEmpty()) {
            boolean isEmpty = viewInjection.getRequiredBindings().isEmpty();
            if (isEmpty) {
                sb.append("    if (view != null) {\n");
                str = "  ";
            } else {
                str = "";
            }
            Iterator<Map.Entry<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>>> it2 = listenerBindings.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>> next = it2.next();
                ListenerClass key = next.getKey();
                Map<ListenerMethod, Set<ListenerBinding>> value = next.getValue();
                boolean z = !ButterKnifeProcessor.VIEW_TYPE.equals(key.targetType());
                sb.append(str);
                sb.append("    ");
                if (z) {
                    sb.append("((");
                    sb.append(key.targetType());
                    if (key.genericArguments() > 0) {
                        sb.append('<');
                        for (int i = 0; i < key.genericArguments(); i++) {
                            if (i > 0) {
                                sb.append(", ");
                            }
                            sb.append('?');
                        }
                        sb.append('>');
                    }
                    sb.append(") ");
                }
                sb.append("view");
                if (z) {
                    sb.append(')');
                }
                sb.append('.');
                sb.append(key.setter());
                sb.append("(\n");
                sb.append(str);
                sb.append("      new ");
                sb.append(key.type());
                sb.append("() {\n");
                for (ListenerMethod listenerMethod : getListenerMethods(key)) {
                    sb.append(str);
                    sb.append("        @Override public ");
                    sb.append(listenerMethod.returnType());
                    sb.append(' ');
                    sb.append(listenerMethod.name());
                    sb.append("(\n");
                    String[] parameters = listenerMethod.parameters();
                    int length = parameters.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(str);
                        sb.append("          ");
                        sb.append(parameters[i2]);
                        sb.append(" p");
                        sb.append(i2);
                        if (i2 < length - 1) {
                            sb.append(',');
                        }
                        sb.append('\n');
                    }
                    sb.append(str);
                    sb.append("        ) {\n");
                    sb.append(str);
                    sb.append("          ");
                    boolean z2 = !"void".equals(listenerMethod.returnType());
                    if (z2) {
                        sb.append("return ");
                    }
                    if (value.containsKey(listenerMethod)) {
                        Iterator<ListenerBinding> it3 = value.get(listenerMethod).iterator();
                        while (it3.hasNext()) {
                            ListenerBinding next2 = it3.next();
                            sb.append("target.");
                            sb.append(next2.getName());
                            sb.append('(');
                            List<Parameter> parameters2 = next2.getParameters();
                            String[] parameters3 = listenerMethod.parameters();
                            int size = parameters2.size();
                            int i3 = 0;
                            while (i3 < size) {
                                Parameter parameter = parameters2.get(i3);
                                int listenerPosition = parameter.getListenerPosition();
                                emitCastIfNeeded(sb, parameters3[listenerPosition], parameter.getType());
                                sb.append('p');
                                sb.append(listenerPosition);
                                if (i3 < size - 1) {
                                    sb.append(", ");
                                }
                                i3++;
                                it2 = it2;
                                value = value;
                            }
                            sb.append(");");
                            if (it3.hasNext()) {
                                sb.append("\n");
                                sb.append("          ");
                            }
                            it2 = it2;
                            value = value;
                        }
                        it = it2;
                        map = value;
                    } else {
                        it = it2;
                        map = value;
                        if (z2) {
                            sb.append(listenerMethod.defaultReturn());
                            sb.append(';');
                        }
                    }
                    sb.append('\n');
                    sb.append(str);
                    sb.append("        }\n");
                    it2 = it;
                    value = map;
                }
                sb.append(str);
                sb.append("      });\n");
                it2 = it2;
            }
            if (isEmpty) {
                sb.append("    }\n");
            }
        }
    }

    private void emitReset(StringBuilder sb) {
        sb.append("  public static void reset(");
        sb.append(this.targetClass);
        sb.append(" target) {\n");
        if (this.parentInjector != null) {
            sb.append("    ");
            sb.append(this.parentInjector);
            sb.append(".reset(target);\n\n");
        }
        for (ViewInjection viewInjection : this.viewIdMap.values()) {
            for (ViewBinding viewBinding : viewInjection.getViewBindings()) {
                sb.append("    target.");
                sb.append(viewBinding.getName());
                sb.append(" = null;\n");
            }
        }
        for (CollectionBinding collectionBinding : this.collectionBindings.keySet()) {
            sb.append("    target.");
            sb.append(collectionBinding.getName());
            sb.append(" = null;\n");
        }
        sb.append("  }\n");
    }

    private void emitViewBindings(StringBuilder sb, ViewInjection viewInjection) {
        Collection<ViewBinding> viewBindings = viewInjection.getViewBindings();
        if (!viewBindings.isEmpty()) {
            for (ViewBinding viewBinding : viewBindings) {
                sb.append("    target.");
                sb.append(viewBinding.getName());
                sb.append(" = ");
                emitCastIfNeeded(sb, viewBinding.getType());
                sb.append("view;\n");
            }
        }
    }

    private void emitViewInjection(StringBuilder sb, ViewInjection viewInjection) {
        sb.append("    view = ");
        List<Binding> requiredBindings = viewInjection.getRequiredBindings();
        if (requiredBindings.isEmpty()) {
            sb.append("finder.findOptionalView(source, ");
            sb.append(viewInjection.getId());
            sb.append(");\n");
        } else if (viewInjection.getId() == -1) {
            sb.append("target;\n");
        } else {
            sb.append("finder.findRequiredView(source, ");
            sb.append(viewInjection.getId());
            sb.append(", \"");
            emitHumanDescription(sb, requiredBindings);
            sb.append("\");\n");
        }
        emitViewBindings(sb, viewInjection);
        emitListenerBindings(sb, viewInjection);
    }

    public static List<ListenerMethod> getListenerMethods(ListenerClass listenerClass) {
        if (listenerClass.method().length == 1) {
            return Arrays.asList(listenerClass.method());
        }
        try {
            ArrayList arrayList = new ArrayList();
            Class<? extends Enum<?>> callbacks = listenerClass.callbacks();
            Enum[] enumArr = (Enum[]) callbacks.getEnumConstants();
            for (Enum r6 : enumArr) {
                ListenerMethod listenerMethod = (ListenerMethod) callbacks.getField(r6.name()).getAnnotation(ListenerMethod.class);
                if (listenerMethod != null) {
                    arrayList.add(listenerMethod);
                } else {
                    throw new IllegalStateException(String.format("@%s's %s.%s missing @%s annotation.", callbacks.getEnclosingClass().getSimpleName(), callbacks.getSimpleName(), r6.name(), ListenerMethod.class.getSimpleName()));
                }
            }
            return arrayList;
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    private ViewInjection getOrCreateViewInjection(int i) {
        ViewInjection viewInjection = this.viewIdMap.get(Integer.valueOf(i));
        if (viewInjection != null) {
            return viewInjection;
        }
        ViewInjection viewInjection2 = new ViewInjection(i);
        this.viewIdMap.put(Integer.valueOf(i), viewInjection2);
        return viewInjection2;
    }

    public void addCollection(int[] iArr, CollectionBinding collectionBinding) {
        this.collectionBindings.put(collectionBinding, iArr);
    }

    public boolean addListener(int i, ListenerClass listenerClass, ListenerMethod listenerMethod, ListenerBinding listenerBinding) {
        ViewInjection orCreateViewInjection = getOrCreateViewInjection(i);
        if (orCreateViewInjection.hasListenerBinding(listenerClass, listenerMethod) && !"void".equals(listenerMethod.returnType())) {
            return false;
        }
        orCreateViewInjection.addListenerBinding(listenerClass, listenerMethod, listenerBinding);
        return true;
    }

    public void addView(int i, ViewBinding viewBinding) {
        getOrCreateViewInjection(i).addViewBinding(viewBinding);
    }

    public String brewJava() {
        StringBuilder k0 = hj1.k0("// Generated code from Butter Knife. Do not modify!\n", "package ");
        hj1.V0(k0, this.classPackage, ";\n\n", "import android.view.View;\n", "import butterknife.ButterKnife.Finder;\n\n");
        k0.append("public class ");
        k0.append(this.className);
        k0.append(" {\n");
        emitInject(k0);
        k0.append('\n');
        emitReset(k0);
        k0.append("}\n");
        return k0.toString();
    }

    public String getFqcn() {
        return this.classPackage + "." + this.className;
    }

    public ViewInjection getViewInjection(int i) {
        return this.viewIdMap.get(Integer.valueOf(i));
    }

    public void setParentInjector(String str) {
        this.parentInjector = str;
    }

    public static void emitCastIfNeeded(StringBuilder sb, String str, String str2) {
        if (!str.equals(str2)) {
            sb.append('(');
            sb.append(str2);
            sb.append(") ");
        }
    }
}
