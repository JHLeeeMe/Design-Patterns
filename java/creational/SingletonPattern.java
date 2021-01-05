/**
 * Singleton Pattern
 *   1. private constructor
 *   2. static instance variable
 *   3. static instance getter
 */

class SingleObject {
    // static instance
    private static SingleObject instance = new SingleObject();
    public int num = 0;

    // private constructor
    private SingleObject() {}

    // static method
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello Singleton!");
        System.out.println("num: " + this.num);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        SingleObject obj1 = SingleObject.getInstance();
        obj1.showMessage();

        obj1.num = 10;

        SingleObject obj2 = SingleObject.getInstance();
        obj2.showMessage();

        System.out.println(obj1.num);

        if (System.identityHashCode(obj1) == System.identityHashCode(obj2)) {
            System.out.println("obj1 == obj2");
            System.out.println("obj1 HashCode: " + System.identityHashCode(obj1));
            System.out.println("obj2 HashCode: " + System.identityHashCode(obj2));
        } else {
            System.out.println("????");
        }
    }
}