package DesignPatterns.SingletonPattern.NonThreadSafe;

public class SingleThread {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance("FOO");
        Singleton instance2 = Singleton.getInstance("BAR");
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        System.out.println(instance1.value);
        System.out.println(instance2.value);
    }
}
