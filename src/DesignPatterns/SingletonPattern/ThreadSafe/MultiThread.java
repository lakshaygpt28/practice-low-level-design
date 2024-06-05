package DesignPatterns.SingletonPattern.ThreadSafe;

public class MultiThread {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread thread1 = new Thread(new ThreadFoo());
        Thread thread2 = new Thread(new ThreadBar());
        thread1.start();
        thread2.start();
    }

    public static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance("FOO");
            System.out.println(instance.value);
            SingletonEnum enumInstance = SingletonEnum.INSTANCE;
            System.out.println(enumInstance.getValue());
            enumInstance.setValue("FOO enum");
            System.out.println(enumInstance.getValue());
        }
    }

    public static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance("BAR");
            System.out.println(instance.value);
            SingletonEnum enumInstance = SingletonEnum.INSTANCE;
            System.out.println(enumInstance.getValue());
            enumInstance.setValue("BAR enum");
            System.out.println(enumInstance.getValue());
        }
    }
}
