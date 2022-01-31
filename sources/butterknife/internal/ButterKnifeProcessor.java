package butterknife.internal;

import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnItemSelected;
import butterknife.OnLongClick;
import butterknife.OnPageChange;
import butterknife.OnTextChanged;
import butterknife.OnTouch;
import butterknife.Optional;
import butterknife.internal.CollectionBinding;
import butterknife.internal.ListenerClass;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

public final class ButterKnifeProcessor extends AbstractProcessor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ANDROID_PREFIX = "android.";
    public static final String JAVA_PREFIX = "java.";
    private static final List<Class<? extends Annotation>> LISTENERS = Arrays.asList(OnCheckedChanged.class, OnClick.class, OnEditorAction.class, OnFocusChange.class, OnItemClick.class, OnItemLongClick.class, OnItemSelected.class, OnLongClick.class, OnPageChange.class, OnTextChanged.class, OnTouch.class);
    private static final String LIST_TYPE = List.class.getCanonicalName();
    public static final String SUFFIX = "$$ViewInjector";
    public static final String VIEW_TYPE = "android.view.View";
    private Elements elementUtils;
    private Filer filer;
    private Types typeUtils;

    private String doubleErasure(TypeMirror typeMirror) {
        String typeMirror2 = this.typeUtils.erasure(typeMirror).toString();
        int indexOf = typeMirror2.indexOf(60);
        return indexOf != -1 ? typeMirror2.substring(0, indexOf) : typeMirror2;
    }

    private void error(Element element, String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, str, element);
    }

    private void findAndParseListener(RoundEnvironment roundEnvironment, Class<? extends Annotation> cls, Map<TypeElement, ViewInjector> map, Set<String> set) {
        for (Element element : roundEnvironment.getElementsAnnotatedWith(cls)) {
            try {
                parseListenerAnnotation(cls, element, map, set);
            } catch (Exception e) {
                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                error(element, "Unable to generate view injector for @%s.\n\n%s", cls.getSimpleName(), stringWriter.toString());
            }
        }
    }

    private Map<TypeElement, ViewInjector> findAndParseTargets(RoundEnvironment roundEnvironment) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        for (Element element : roundEnvironment.getElementsAnnotatedWith(InjectView.class)) {
            try {
                parseInjectView(element, linkedHashMap, linkedHashSet);
            } catch (Exception e) {
                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                error(element, "Unable to generate view injector for @InjectView.\n\n%s", stringWriter);
            }
        }
        for (Element element2 : roundEnvironment.getElementsAnnotatedWith(InjectViews.class)) {
            try {
                parseInjectViews(element2, linkedHashMap, linkedHashSet);
            } catch (Exception e2) {
                StringWriter stringWriter2 = new StringWriter();
                e2.printStackTrace(new PrintWriter(stringWriter2));
                error(element2, "Unable to generate view injector for @InjectViews.\n\n%s", stringWriter2);
            }
        }
        for (Class<? extends Annotation> cls : LISTENERS) {
            findAndParseListener(roundEnvironment, cls, linkedHashMap, linkedHashSet);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String findParentFqcn = findParentFqcn((TypeElement) entry.getKey(), linkedHashSet);
            if (findParentFqcn != null) {
                ((ViewInjector) entry.getValue()).setParentInjector(findParentFqcn + SUFFIX);
            }
        }
        return linkedHashMap;
    }

    private static Integer findDuplicate(int[] iArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i : iArr) {
            if (!linkedHashSet.add(Integer.valueOf(i))) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    private String findParentFqcn(TypeElement typeElement, Set<String> set) {
        do {
            DeclaredType superclass = typeElement.getSuperclass();
            if (superclass.getKind() == TypeKind.NONE) {
                return null;
            }
            typeElement = (TypeElement) superclass.asElement();
        } while (!set.contains(typeElement.toString()));
        String packageName = getPackageName(typeElement);
        StringBuilder k0 = hj1.k0(packageName, ".");
        k0.append(getClassName(typeElement, packageName));
        return k0.toString();
    }

    private static String getClassName(TypeElement typeElement, String str) {
        return typeElement.getQualifiedName().toString().substring(str.length() + 1).replace('.', '$');
    }

    private ViewInjector getOrCreateTargetClass(Map<TypeElement, ViewInjector> map, TypeElement typeElement) {
        ViewInjector viewInjector = map.get(typeElement);
        if (viewInjector != null) {
            return viewInjector;
        }
        String obj = typeElement.getQualifiedName().toString();
        String packageName = getPackageName(typeElement);
        ViewInjector viewInjector2 = new ViewInjector(packageName, hj1.a0(new StringBuilder(), getClassName(typeElement, packageName), SUFFIX), obj);
        map.put(typeElement, viewInjector2);
        return viewInjector2;
    }

    private String getPackageName(TypeElement typeElement) {
        return this.elementUtils.getPackageOf(typeElement).getQualifiedName().toString();
    }

    private boolean isBindingInWrongPackage(Class<? extends Annotation> cls, Element element) {
        String obj = element.getEnclosingElement().getQualifiedName().toString();
        if (obj.startsWith(ANDROID_PREFIX)) {
            error(element, "@%s-annotated class incorrectly in Android framework package. (%s)", cls.getSimpleName(), obj);
            return true;
        } else if (!obj.startsWith(JAVA_PREFIX)) {
            return false;
        } else {
            error(element, "@%s-annotated class incorrectly in Java framework package. (%s)", cls.getSimpleName(), obj);
            return true;
        }
    }

    private boolean isSubtypeOfType(TypeMirror typeMirror, String str) {
        if (str.equals(typeMirror.toString())) {
            return true;
        }
        if (!(typeMirror instanceof DeclaredType)) {
            return false;
        }
        DeclaredType declaredType = (DeclaredType) typeMirror;
        List typeArguments = declaredType.getTypeArguments();
        if (typeArguments.size() > 0) {
            StringBuilder sb = new StringBuilder(declaredType.asElement().toString());
            sb.append('<');
            for (int i = 0; i < typeArguments.size(); i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append('?');
            }
            sb.append('>');
            if (sb.toString().equals(str)) {
                return true;
            }
        }
        TypeElement asElement = declaredType.asElement();
        if (!(asElement instanceof TypeElement)) {
            return false;
        }
        TypeElement typeElement = asElement;
        if (isSubtypeOfType(typeElement.getSuperclass(), str)) {
            return true;
        }
        for (TypeMirror typeMirror2 : typeElement.getInterfaces()) {
            if (isSubtypeOfType(typeMirror2, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidForGeneratedCode(Class<? extends Annotation> cls, String str, Element element) {
        boolean z;
        TypeElement enclosingElement = element.getEnclosingElement();
        Set modifiers = element.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.STATIC)) {
            error(element, "@%s %s must not be private or static. (%s.%s)", cls.getSimpleName(), str, enclosingElement.getQualifiedName(), element.getSimpleName());
            z = true;
        } else {
            z = false;
        }
        if (enclosingElement.getKind() != ElementKind.CLASS) {
            error(enclosingElement, "@%s %s may only be contained in classes. (%s.%s)", cls.getSimpleName(), str, enclosingElement.getQualifiedName(), element.getSimpleName());
            z = true;
        }
        if (!enclosingElement.getModifiers().contains(Modifier.PRIVATE)) {
            return z;
        }
        error(enclosingElement, "@%s %s may not be contained in private classes. (%s.%s)", cls.getSimpleName(), str, enclosingElement.getQualifiedName(), element.getSimpleName());
        return true;
    }

    private void parseInjectView(Element element, Map<TypeElement, ViewInjector> map, Set<String> set) {
        boolean z;
        ViewInjection viewInjection;
        TypeElement typeElement = (TypeElement) element.getEnclosingElement();
        TypeMirror asType = element.asType();
        if (asType instanceof TypeVariable) {
            asType = ((TypeVariable) asType).getUpperBound();
        }
        boolean z2 = false;
        if (!isSubtypeOfType(asType, VIEW_TYPE)) {
            error(element, "@InjectView fields must extend from View. (%s.%s)", typeElement.getQualifiedName(), element.getSimpleName());
            z = true;
        } else {
            z = false;
        }
        boolean isValidForGeneratedCode = z | isValidForGeneratedCode(InjectView.class, "fields", element) | isBindingInWrongPackage(InjectView.class, element);
        if (element.getAnnotation(InjectViews.class) != null) {
            error(element, "Only one of @InjectView and @InjectViews is allowed. (%s.%s)", typeElement.getQualifiedName(), element.getSimpleName());
            isValidForGeneratedCode = true;
        }
        if (!isValidForGeneratedCode) {
            int value = ((InjectView) element.getAnnotation(InjectView.class)).value();
            ViewInjector viewInjector = map.get(typeElement);
            if (!(viewInjector == null || (viewInjection = viewInjector.getViewInjection(value)) == null)) {
                Iterator<ViewBinding> it = viewInjection.getViewBindings().iterator();
                if (it.hasNext()) {
                    error(element, "Attempt to use @InjectView for an already injected ID %d on '%s'. (%s.%s)", Integer.valueOf(value), it.next().getName(), typeElement.getQualifiedName(), element.getSimpleName());
                    return;
                }
            }
            String obj = element.getSimpleName().toString();
            String typeMirror = asType.toString();
            if (element.getAnnotation(Optional.class) == null) {
                z2 = true;
            }
            getOrCreateTargetClass(map, typeElement).addView(value, new ViewBinding(obj, typeMirror, z2));
            set.add(typeElement.toString());
        }
    }

    private void parseInjectViews(Element element, Map<TypeElement, ViewInjector> map, Set<String> set) {
        CollectionBinding.Kind kind;
        boolean z;
        TypeElement typeElement = (TypeElement) element.getEnclosingElement();
        ArrayType asType = element.asType();
        String doubleErasure = doubleErasure(asType);
        TypeMirror typeMirror = null;
        boolean z2 = false;
        if (asType.getKind() == TypeKind.ARRAY) {
            typeMirror = asType.getComponentType();
            kind = CollectionBinding.Kind.ARRAY;
            z = false;
        } else if (LIST_TYPE.equals(doubleErasure)) {
            List typeArguments = ((DeclaredType) asType).getTypeArguments();
            if (typeArguments.size() != 1) {
                error(element, "@InjectViews List must have a generic component. (%s.%s)", typeElement.getQualifiedName(), element.getSimpleName());
                z = true;
            } else {
                typeMirror = (TypeMirror) typeArguments.get(0);
                z = false;
            }
            kind = CollectionBinding.Kind.LIST;
        } else {
            error(element, "@InjectViews must be a List or array. (%s.%s)", typeElement.getQualifiedName(), element.getSimpleName());
            kind = null;
            z = true;
        }
        if (typeMirror instanceof TypeVariable) {
            typeMirror = ((TypeVariable) typeMirror).getUpperBound();
        }
        if (typeMirror != null && !isSubtypeOfType(typeMirror, VIEW_TYPE)) {
            error(element, "@InjectViews type must extend from View. (%s.%s)", typeElement.getQualifiedName(), element.getSimpleName());
            z = true;
        }
        if (!(z | isValidForGeneratedCode(InjectViews.class, "fields", element)) && !isBindingInWrongPackage(InjectViews.class, element)) {
            String obj = element.getSimpleName().toString();
            int[] value = ((InjectViews) element.getAnnotation(InjectViews.class)).value();
            if (value.length == 0) {
                error(element, "@InjectViews must specify at least one ID. (%s.%s)", typeElement.getQualifiedName(), element.getSimpleName());
                return;
            }
            Integer findDuplicate = findDuplicate(value);
            if (findDuplicate != null) {
                error(element, "@InjectViews annotation contains duplicate ID %d. (%s.%s)", findDuplicate, typeElement.getQualifiedName(), element.getSimpleName());
            }
            String typeMirror2 = typeMirror.toString();
            if (element.getAnnotation(Optional.class) == null) {
                z2 = true;
            }
            getOrCreateTargetClass(map, typeElement).addCollection(value, new CollectionBinding(obj, typeMirror2, kind, z2));
            set.add(typeElement.toString());
        }
    }

    private void parseListenerAnnotation(Class<? extends Annotation> cls, Element element, Map<TypeElement, ViewInjector> map, Set<String> set) throws Exception {
        ListenerMethod listenerMethod;
        ListenerClass listenerClass;
        if (!(element instanceof ExecutableElement) || element.getKind() != ElementKind.METHOD) {
            throw new IllegalStateException(String.format("@%s annotation must be on a method.", cls.getSimpleName()));
        }
        Element element2 = (ExecutableElement) element;
        TypeElement enclosingElement = element.getEnclosingElement();
        Annotation annotation = element.getAnnotation(cls);
        Method declaredMethod = cls.getDeclaredMethod(FirebaseAnalytics.Param.VALUE, new Class[0]);
        if (declaredMethod.getReturnType() == int[].class) {
            int[] iArr = (int[]) declaredMethod.invoke(annotation, new Object[0]);
            String obj = element2.getSimpleName().toString();
            boolean z = element.getAnnotation(Optional.class) == null;
            boolean isValidForGeneratedCode = isValidForGeneratedCode(cls, "methods", element) | isBindingInWrongPackage(cls, element);
            Object findDuplicate = findDuplicate(iArr);
            if (findDuplicate != null) {
                error(element, "@%s annotation for method contains duplicate ID %d. (%s.%s)", cls.getSimpleName(), findDuplicate, enclosingElement.getQualifiedName(), element.getSimpleName());
                isValidForGeneratedCode = true;
            }
            ListenerClass listenerClass2 = (ListenerClass) cls.getAnnotation(ListenerClass.class);
            if (listenerClass2 != null) {
                for (int i : iArr) {
                    if (i == -1) {
                        if (iArr.length == 1) {
                            if (!z) {
                                error(element, "ID free injection must not be annotated with @Optional. (%s.%s)", enclosingElement.getQualifiedName(), element.getSimpleName());
                                isValidForGeneratedCode = true;
                            }
                            String targetType = listenerClass2.targetType();
                            if (!isSubtypeOfType(enclosingElement.asType(), targetType)) {
                                error(element, "@%s annotation without an ID may only be used with an object of type \"%s\". (%s.%s)", cls.getSimpleName(), targetType, enclosingElement.getQualifiedName(), element.getSimpleName());
                            }
                        } else {
                            error(element, "@%s annotation contains invalid ID %d. (%s.%s)", cls.getSimpleName(), Integer.valueOf(i), enclosingElement.getQualifiedName(), element.getSimpleName());
                        }
                        isValidForGeneratedCode = true;
                    }
                }
                ListenerMethod[] method = listenerClass2.method();
                if (method.length <= 1) {
                    if (method.length != 1) {
                        Enum r4 = (Enum) cls.getDeclaredMethod("callback", new Class[0]).invoke(annotation, new Object[0]);
                        ListenerMethod listenerMethod2 = (ListenerMethod) r4.getDeclaringClass().getField(r4.name()).getAnnotation(ListenerMethod.class);
                        if (listenerMethod2 != null) {
                            listenerMethod = listenerMethod2;
                        } else {
                            throw new IllegalStateException(String.format("No @%s defined on @%s's %s.%s.", ListenerMethod.class.getSimpleName(), cls.getSimpleName(), r4.getDeclaringClass().getSimpleName(), r4.name()));
                        }
                    } else if (listenerClass2.callbacks() == ListenerClass.NONE.class) {
                        listenerMethod = method[0];
                    } else {
                        throw new IllegalStateException(String.format("Both method() and callback() defined on @%s.", cls.getSimpleName()));
                    }
                    List parameters = element2.getParameters();
                    if (parameters.size() > listenerMethod.parameters().length) {
                        error(element, "@%s methods can have at most %s parameter(s). (%s.%s)", cls.getSimpleName(), Integer.valueOf(listenerMethod.parameters().length), enclosingElement.getQualifiedName(), element.getSimpleName());
                        isValidForGeneratedCode = true;
                    }
                    TypeMirror returnType = element2.getReturnType();
                    if (returnType instanceof TypeVariable) {
                        returnType = ((TypeVariable) returnType).getUpperBound();
                    }
                    if (!returnType.toString().equals(listenerMethod.returnType())) {
                        error(element, "@%s methods must have a '%s' return type. (%s.%s)", cls.getSimpleName(), listenerMethod.returnType(), enclosingElement.getQualifiedName(), element.getSimpleName());
                        isValidForGeneratedCode = true;
                    }
                    if (!isValidForGeneratedCode) {
                        Parameter[] parameterArr = Parameter.NONE;
                        if (!parameters.isEmpty()) {
                            int size = parameters.size();
                            Parameter[] parameterArr2 = new Parameter[size];
                            BitSet bitSet = new BitSet(parameters.size());
                            String[] parameters2 = listenerMethod.parameters();
                            int i2 = 0;
                            while (i2 < parameters.size()) {
                                TypeMirror asType = ((VariableElement) parameters.get(i2)).asType();
                                if (asType instanceof TypeVariable) {
                                    asType = ((TypeVariable) asType).getUpperBound();
                                }
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= parameters2.length) {
                                        break;
                                    } else if (!bitSet.get(i3) && isSubtypeOfType(asType, parameters2[i3])) {
                                        parameterArr2[i2] = new Parameter(i3, asType.toString());
                                        bitSet.set(i3);
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (parameterArr2[i2] == null) {
                                    StringBuilder i0 = hj1.i0("Unable to match @");
                                    i0.append(cls.getSimpleName());
                                    i0.append(" method arguments. (");
                                    i0.append((CharSequence) enclosingElement.getQualifiedName());
                                    i0.append('.');
                                    i0.append((CharSequence) element.getSimpleName());
                                    i0.append(')');
                                    int i4 = 0;
                                    while (i4 < size) {
                                        Parameter parameter = parameterArr2[i4];
                                        i0.append("\n\n  Parameter #");
                                        int i5 = i4 + 1;
                                        i0.append(i5);
                                        i0.append(": ");
                                        i0.append(((VariableElement) parameters.get(i4)).asType().toString());
                                        i0.append("\n    ");
                                        if (parameter == null) {
                                            i0.append("did not match any listener parameters");
                                        } else {
                                            i0.append("matched listener parameter #");
                                            i0.append(parameter.getListenerPosition() + 1);
                                            i0.append(": ");
                                            i0.append(parameter.getType());
                                        }
                                        i4 = i5;
                                    }
                                    i0.append("\n\nMethods may have up to ");
                                    i0.append(listenerMethod.parameters().length);
                                    i0.append(" parameter(s):\n");
                                    String[] parameters3 = listenerMethod.parameters();
                                    for (String str : parameters3) {
                                        i0.append("\n  ");
                                        i0.append(str);
                                    }
                                    i0.append("\n\nThese may be listed in any order but will be searched for from top to bottom.");
                                    error(element2, i0.toString(), new Object[0]);
                                    return;
                                }
                                i2++;
                                listenerClass2 = listenerClass2;
                            }
                            listenerClass = listenerClass2;
                            parameterArr = parameterArr2;
                        } else {
                            listenerClass = listenerClass2;
                        }
                        ListenerBinding listenerBinding = new ListenerBinding(obj, Arrays.asList(parameterArr), z);
                        ViewInjector orCreateTargetClass = getOrCreateTargetClass(map, enclosingElement);
                        int length = iArr.length;
                        int i6 = 0;
                        while (i6 < length) {
                            int i7 = iArr[i6];
                            if (!orCreateTargetClass.addListener(i7, listenerClass, listenerMethod, listenerBinding)) {
                                error(element, "Multiple listener methods with return value specified for ID %d. (%s.%s)", Integer.valueOf(i7), enclosingElement.getQualifiedName(), element.getSimpleName());
                                return;
                            } else {
                                i6++;
                                listenerClass = listenerClass;
                            }
                        }
                        set.add(enclosingElement.toString());
                        return;
                    }
                    return;
                }
                throw new IllegalStateException(String.format("Multiple listener methods specified on @%s.", cls.getSimpleName()));
            }
            throw new IllegalStateException(String.format("No @%s defined on @%s.", ListenerClass.class.getSimpleName(), cls.getSimpleName()));
        }
        throw new IllegalStateException(String.format("@%s annotation value() type not int[].", cls));
    }

    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(InjectView.class.getCanonicalName());
        linkedHashSet.add(InjectViews.class.getCanonicalName());
        for (Class<? extends Annotation> cls : LISTENERS) {
            linkedHashSet.add(cls.getCanonicalName());
        }
        return linkedHashSet;
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        ButterKnifeProcessor.super.init(processingEnvironment);
        this.elementUtils = processingEnvironment.getElementUtils();
        this.typeUtils = processingEnvironment.getTypeUtils();
        this.filer = processingEnvironment.getFiler();
    }

    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (Map.Entry<TypeElement, ViewInjector> entry : findAndParseTargets(roundEnvironment).entrySet()) {
            TypeElement key = entry.getKey();
            ViewInjector value = entry.getValue();
            try {
                Writer openWriter = this.filer.createSourceFile(value.getFqcn(), new Element[]{key}).openWriter();
                openWriter.write(value.brewJava());
                openWriter.flush();
                openWriter.close();
            } catch (IOException e) {
                error(key, "Unable to write injector for type %s: %s", key, e.getMessage());
            }
        }
        return true;
    }
}
