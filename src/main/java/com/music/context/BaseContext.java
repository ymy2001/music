package com.music.context;

public class BaseContext {

    public static ThreadLocal<Long> threadLocal1 = new ThreadLocal<>();
    public static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal1.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal1.get();
    }

    public static void removeCurrentId() {
        threadLocal1.remove();
    }

    public static void setCurrentName(String username) {
        threadLocal2.set(username);
    }
    public static String getCurrentName() {
        return threadLocal2.get();
    }

    public static void removeCurrentName() {
        threadLocal2.remove();
    }
}
