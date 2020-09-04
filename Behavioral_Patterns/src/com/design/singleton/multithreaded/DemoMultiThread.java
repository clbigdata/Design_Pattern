package com.design.singleton.multithreaded;

public class DemoMultiThread {
    public static void main(String[] args) {
        /**
         System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
         "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
         "RESULT:" + "\n");
         **/
        System.out.println("如果您看到相同的值，那么singleton被重用了（耶！）" + "\n" +
                "如果看到不同的值，则创建了2个单例（booo！！" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
