package com.design.singleton.single_threaded;

public class DemoSingleThread {
    public static void main(String[] args) {
        /**
         System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
         "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
         "RESULT:" + "\n");
         **/
        System.out.println("如果您看到相同的值，那么singleton被重用了（耶！）" + "\n" +
                "如果看到不同的值，则创建了2个单例（booo！！" + "\n\n" +
                "RESULT:" + "\n");
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
