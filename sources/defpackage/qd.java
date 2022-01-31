package defpackage;

import defpackage.wc;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: qd  reason: default package */
/* compiled from: Reader */
public interface qd {
    void A(List<Float> list) throws IOException;

    int B() throws IOException;

    boolean C() throws IOException;

    int D() throws IOException;

    void E(List<ub> list) throws IOException;

    void F(List<Double> list) throws IOException;

    long G() throws IOException;

    String H() throws IOException;

    void I(List<Long> list) throws IOException;

    <T> T J(rd<T> rdVar, cc ccVar) throws IOException;

    <K, V> void K(Map<K, V> map, wc.a<K, V> aVar, cc ccVar) throws IOException;

    @Deprecated
    <T> void L(List<T> list, rd<T> rdVar, cc ccVar) throws IOException;

    <T> void M(List<T> list, rd<T> rdVar, cc ccVar) throws IOException;

    @Deprecated
    <T> T N(rd<T> rdVar, cc ccVar) throws IOException;

    int a();

    void b(List<Integer> list) throws IOException;

    long c() throws IOException;

    long d() throws IOException;

    void e(List<Integer> list) throws IOException;

    void f(List<Long> list) throws IOException;

    void g(List<Integer> list) throws IOException;

    int h() throws IOException;

    boolean i() throws IOException;

    long j() throws IOException;

    void k(List<Long> list) throws IOException;

    int l() throws IOException;

    void m(List<Long> list) throws IOException;

    void n(List<Long> list) throws IOException;

    void o(List<Integer> list) throws IOException;

    void p(List<Integer> list) throws IOException;

    int q() throws IOException;

    void r(List<Integer> list) throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    int s() throws IOException;

    long t() throws IOException;

    void u(List<Boolean> list) throws IOException;

    String v() throws IOException;

    int w() throws IOException;

    void x(List<String> list) throws IOException;

    void y(List<String> list) throws IOException;

    ub z() throws IOException;
}
