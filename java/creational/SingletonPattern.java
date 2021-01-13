/**
 * Singleton Pattern
 *   1. private constructor
 *   2. static instance variable
 *   3. static instance getter
 */

/* Eager init (Thread safe) */
class SingleObject {
    // static instance
    private static SingleObject instance = new SingleObject();
    public int num = 0;

    // private constructor
    private SingleObject() {}

    // static getter
    public static SingleObject getInstance() {
        return instance;
    }

    public synchronized void showMessage() {
        System.out.println("Hello Singleton!");
        System.out.println("num: " + num);
    }
}

// /* Lazy init + Synchronized (Thread safe) */
// class SingleObject {
//     private static SingleObject instance;
//     public int num = 0;
//
//     private SingleObject() {}
//
//     public static synchronized SingleObject getInstance() {
//         if (instance == null) {
//             instance = new SingleObject();
//         }
//
//         return instance;
//     }
//
//     public synchronized void showMessage() {
//         System.out.println("Hello Singleton!");
//         System.out.println("num: " + num);
//     }
// }

// /* Lazy init + Double Checking Locking (DCL, Thread safe) */
// class SingleObject {
//     private volatile static SingleObject instance;  // No CPU cache, only Main memory, DCL에선 필수
//     public int num = 0;
//
//     private SingleObject() {}
//
//     public static SingleObject getInstance() {
//         if (instance == null) {
//             synchronized(SingleObject.class) {
//                 if (instance == null) {
//                     instance = new SingleObject();
//                 }
//             }
//         }
//         return instance;
//     }
//
//     public synchronized void showMessage() {
//         System.out.println("Hello Singleton!");
//         System.out.println("num: " + num);
//     }
// }

// /* Holder */
// class SingleObject {
//     public int num = 0;
//
//     private SingleObject() {}
//
//     private static class Holder {
//         private static final SingleObject INSTANCE = new SingleObject();
//     }
//
//     public static SingleObject getInstance() {
//         return Holder.INSTANCE;
//     }
//
//     public synchronized void showMessage() {
//         System.out.println("Hello Singleton!");
//         System.out.println("num: " + num);
//     }
// }

public class SingletonPattern {
    public static void main(String[] args) {
        SingleObject obj1 = SingleObject.getInstance();
        obj1.showMessage();

        obj1.num = 10;

        SingleObject obj2 = SingleObject.getInstance();
        obj2.showMessage();

        if (obj1.hashCode() == obj2.hashCode()) {
            System.out.println("obj1 == obj2");
            System.out.println("obj1 HashCode: " + obj1.hashCode());
            System.out.println("obj2 HashCode: " + obj2.hashCode());
        } else {
            System.out.println("????");
        }
    }
}
