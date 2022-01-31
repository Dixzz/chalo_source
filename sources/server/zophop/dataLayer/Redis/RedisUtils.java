package server.zophop.dataLayer.Redis;

import redis.clients.jedis.Jedis;

public class RedisUtils implements IKeyValueStore<String, String> {
    private Jedis getJedisResource() {
        return JedisFactory.get_instance().getJedisPool().getResource();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002b A[SYNTHETIC, Splitter:B:18:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsKey(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            redis.clients.jedis.Jedis r1 = r4.getJedisResource()     // Catch:{ JedisConnectionException -> 0x0027 }
            if (r1 == 0) goto L_0x0013
            java.lang.Boolean r5 = r1.exists(r5)     // Catch:{ JedisConnectionException -> 0x0023 }
            boolean r5 = r5.booleanValue()     // Catch:{ JedisConnectionException -> 0x0023 }
            r1.close()
            return r5
        L_0x0013:
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r2 = "connection null error :("
            r5.println(r2)
            if (r1 == 0) goto L_0x004b
            r1.close()
            goto L_0x004b
        L_0x0020:
            r5 = move-exception
            r0 = r1
            goto L_0x004d
        L_0x0023:
            r5 = move-exception
            goto L_0x0029
        L_0x0025:
            r5 = move-exception
            goto L_0x004d
        L_0x0027:
            r5 = move-exception
            r1 = r0
        L_0x0029:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x0025 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0025 }
            r2.<init>()     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "Redis connect error :( "
            r2.append(r3)     // Catch:{ all -> 0x0025 }
            r2.append(r5)     // Catch:{ all -> 0x0025 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0025 }
            r1.println(r5)     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x004b
            r0.close()
        L_0x004b:
            r5 = 0
            return r5
        L_0x004d:
            if (r0 == 0) goto L_0x0052
            r0.close()
        L_0x0052:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.dataLayer.Redis.RedisUtils.containsKey(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        if (r8 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        throw r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean geoAdd(java.lang.String r10, java.lang.String r11, double r12, double r14) {
        /*
            r9 = this;
            r0 = 0
            redis.clients.jedis.Jedis r8 = r9.getJedisResource()     // Catch:{ Exception -> 0x002d }
            r1 = r8
            r2 = r10
            r3 = r14
            r5 = r12
            r7 = r11
            java.lang.Long r12 = r1.geoadd(r2, r3, r5, r7)     // Catch:{ all -> 0x001f }
            long r12 = r12.longValue()     // Catch:{ all -> 0x001f }
            r14 = 0
            int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x001a
            r12 = 1
            goto L_0x001b
        L_0x001a:
            r12 = 0
        L_0x001b:
            r8.close()
            return r12
        L_0x001f:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r13 = move-exception
            if (r8 == 0) goto L_0x002c
            r8.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r14 = move-exception
            r12.addSuppressed(r14)
        L_0x002c:
            throw r13
        L_0x002d:
            r12 = move-exception
            java.io.PrintStream r13 = java.lang.System.out
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Error geoadd data to redis set, key:"
            r14.append(r15)
            r14.append(r10)
            java.lang.String r10 = ", member:"
            r14.append(r10)
            r14.append(r11)
            java.lang.String r10 = ", error:"
            r14.append(r10)
            java.lang.String r10 = r12.getMessage()
            r14.append(r10)
            java.lang.String r10 = r14.toString()
            r13.println(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.dataLayer.Redis.RedisUtils.geoAdd(java.lang.String, java.lang.String, double, double):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025 A[SYNTHETIC, Splitter:B:17:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String get(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            redis.clients.jedis.Jedis r1 = r4.getJedisResource()     // Catch:{ JedisConnectionException -> 0x0021 }
            if (r1 == 0) goto L_0x000b
            r1.get(r5)     // Catch:{ JedisConnectionException -> 0x001d }
            goto L_0x0012
        L_0x000b:
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ JedisConnectionException -> 0x001d }
            java.lang.String r3 = "connection null error :("
            r2.println(r3)     // Catch:{ JedisConnectionException -> 0x001d }
        L_0x0012:
            java.lang.String r5 = r1.get(r5)     // Catch:{ JedisConnectionException -> 0x001d }
            r1.close()
            return r5
        L_0x001a:
            r5 = move-exception
            r0 = r1
            goto L_0x0048
        L_0x001d:
            r5 = move-exception
            goto L_0x0023
        L_0x001f:
            r5 = move-exception
            goto L_0x0048
        L_0x0021:
            r5 = move-exception
            r1 = r0
        L_0x0023:
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ all -> 0x001a }
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x001f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x001f }
            r2.<init>()     // Catch:{ all -> 0x001f }
            java.lang.String r3 = "Redis connect error :( "
            r2.append(r3)     // Catch:{ all -> 0x001f }
            r2.append(r5)     // Catch:{ all -> 0x001f }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x001f }
            r1.println(r5)     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0045
            r0.close()
        L_0x0045:
            java.lang.String r5 = ""
            return r5
        L_0x0048:
            if (r0 == 0) goto L_0x004d
            r0.close()
        L_0x004d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.dataLayer.Redis.RedisUtils.get(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        if (r1 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            redis.clients.jedis.Jedis r1 = r7.getJedisResource()     // Catch:{ Exception -> 0x0028 }
            java.lang.Long r2 = r1.del(r8)     // Catch:{ all -> 0x001a }
            long r2 = r2.longValue()     // Catch:{ all -> 0x001a }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0015
            r2 = 1
            goto L_0x0016
        L_0x0015:
            r2 = 0
        L_0x0016:
            r1.close()
            return r2
        L_0x001a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001c }
        L_0x001c:
            r3 = move-exception
            if (r1 == 0) goto L_0x0027
            r1.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x0027:
            throw r3
        L_0x0028:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.String r3 = "Error removing data from redis, key:"
            java.lang.String r4 = ", error:"
            java.lang.StringBuilder r8 = defpackage.hj1.l0(r3, r8, r4)
            java.lang.String r1 = r1.getMessage()
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r2.println(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.dataLayer.Redis.RedisUtils.remove(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        if (r1 != null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeFromSet(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            redis.clients.jedis.Jedis r1 = r8.getJedisResource()     // Catch:{ Exception -> 0x002c }
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x001e }
            r3[r0] = r10     // Catch:{ all -> 0x001e }
            java.lang.Long r3 = r1.zrem(r9, r3)     // Catch:{ all -> 0x001e }
            long r3 = r3.longValue()     // Catch:{ all -> 0x001e }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            r1.close()
            return r2
        L_0x001e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r3 = move-exception
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ all -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x002b:
            throw r3
        L_0x002c:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error removing data from redis set, key:"
            r3.append(r4)
            r3.append(r9)
            java.lang.String r9 = ", member:"
            r3.append(r9)
            r3.append(r10)
            java.lang.String r9 = ", error:"
            r3.append(r9)
            java.lang.String r9 = r1.getMessage()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            r2.println(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.dataLayer.Redis.RedisUtils.removeFromSet(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[SYNTHETIC, Splitter:B:16:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            redis.clients.jedis.Jedis r1 = r3.getJedisResource()     // Catch:{ JedisConnectionException -> 0x001f }
            if (r1 == 0) goto L_0x000b
            r1.set(r4, r5)     // Catch:{ JedisConnectionException -> 0x001b }
            goto L_0x0012
        L_0x000b:
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ JedisConnectionException -> 0x001b }
            java.lang.String r5 = "connection null error :("
            r4.println(r5)     // Catch:{ JedisConnectionException -> 0x001b }
        L_0x0012:
            if (r1 == 0) goto L_0x0043
            r1.close()
            goto L_0x0043
        L_0x0018:
            r4 = move-exception
            r0 = r1
            goto L_0x0044
        L_0x001b:
            r4 = move-exception
            goto L_0x0021
        L_0x001d:
            r4 = move-exception
            goto L_0x0044
        L_0x001f:
            r4 = move-exception
            r1 = r0
        L_0x0021:
            if (r1 == 0) goto L_0x0027
            r1.close()     // Catch:{ all -> 0x0018 }
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ all -> 0x001d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001d }
            r1.<init>()     // Catch:{ all -> 0x001d }
            java.lang.String r2 = "Redis connect error :( "
            r1.append(r2)     // Catch:{ all -> 0x001d }
            r1.append(r4)     // Catch:{ all -> 0x001d }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x001d }
            r5.println(r4)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0043
            r0.close()
        L_0x0043:
            return
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()
        L_0x0049:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.dataLayer.Redis.RedisUtils.put(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r2 = this;
            r0 = 0
            redis.clients.jedis.Jedis r1 = r2.getJedisResource()     // Catch:{ JedisConnectionException -> 0x002d }
            if (r1 == 0) goto L_0x0019
            java.lang.String r4 = r1.set(r3, r4)     // Catch:{ JedisConnectionException -> 0x0029 }
            r1.expire(r3, r5)     // Catch:{ JedisConnectionException -> 0x0029 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ JedisConnectionException -> 0x0029 }
            r3.println(r4)     // Catch:{ JedisConnectionException -> 0x0029 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ JedisConnectionException -> 0x0029 }
            r3.println(r4)     // Catch:{ JedisConnectionException -> 0x0029 }
            goto L_0x0020
        L_0x0019:
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ JedisConnectionException -> 0x0029 }
            java.lang.String r4 = "connection null error :("
            r3.println(r4)     // Catch:{ JedisConnectionException -> 0x0029 }
        L_0x0020:
            if (r1 == 0) goto L_0x0051
            r1.close()
            goto L_0x0051
        L_0x0026:
            r3 = move-exception
            r0 = r1
            goto L_0x0052
        L_0x0029:
            r3 = move-exception
            goto L_0x002f
        L_0x002b:
            r3 = move-exception
            goto L_0x0052
        L_0x002d:
            r3 = move-exception
            r1 = r0
        L_0x002f:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ all -> 0x0026 }
            goto L_0x0036
        L_0x0035:
            r0 = r1
        L_0x0036:
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r1 = "Redis connect error :( "
            r5.append(r1)     // Catch:{ all -> 0x002b }
            r5.append(r3)     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x002b }
            r4.println(r3)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0051
            r0.close()
        L_0x0051:
            return
        L_0x0052:
            if (r0 == 0) goto L_0x0057
            r0.close()
        L_0x0057:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.dataLayer.Redis.RedisUtils.put(java.lang.String, java.lang.String, int):void");
    }
}
