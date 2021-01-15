/**
 * Strategy Pattern
 * 
 *   1. 특정한 계열의 알고리즘들을 정의하고
 *   2. 각 알고리즘을 캡슐화하며
 *   3. 이 알고리즘들을 해당 계열 안에서 상호 교체가 가능하게 만든다.
 */

/* Strategy */
interface Strategy {
    double doSomething(double a, double b);
}

class Add implements Strategy {
    @Override
    public double doSomething(double a, double b) {
        return a + b;
    }
}

class Subtract implements Strategy {
    @Override
    public double doSomething(double a, double b) {
        return a - b;
    }
}

class Multiply implements Strategy {
    @Override
    public double doSomething(double a, double b) {
        return a * b;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double execute(double a, double b) {
        return this.strategy.doSomething(a, b);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

public class StrategyPattern{
    public static void main(String[] args) {
        Context context = new Context(new Add());

        System.out.println(context.execute(100.8, 5));  // 105.8

        context.setStrategy(new Subtract());
        System.out.println(context.execute(100, 50));  // 50.0

        context.setStrategy(new Multiply());
        System.out.println(context.execute(10, 50));  // 500.0

        

    }
}