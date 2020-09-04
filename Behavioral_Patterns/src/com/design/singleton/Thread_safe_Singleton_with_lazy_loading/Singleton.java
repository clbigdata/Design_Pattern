package com.design.singleton.Thread_safe_Singleton_with_lazy_loading;

public class Singleton {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    //保障线程间共享资源的可见性,防止重排序
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {

        /**
         * 执行双重检查是因为，如果多个线程同时了通过了第一次检查，并且其中一个线程首先通过了第二次检查并实例化了对象，
         * 那么剩余通过了第一次检查的线程就不会再去实例化对象。
         * 这样，除了初始化的时候会出现加锁的情况，后续的所有调用都会避免加锁而直接返回，解决了性能消耗的问题。
         */
        Singleton result = instance;
        //第一次检查，引用是否为null
        if (result != null) {
            return result;
        }
        synchronized(Singleton.class) {
            //第二次检查，引用是否为null
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
