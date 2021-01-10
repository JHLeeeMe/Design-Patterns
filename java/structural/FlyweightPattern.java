/**
 * Flyweight Pattern
 *   Prototype 패턴이 큰 데이터를 다룰 때 리소스 절약을 위함이라면,
 *   Flyweight 패턴은 작은 데이터를 다룰 때 성능 이슈를 다룬다.
 *   Singleton 패턴의 그것과 비슷하다.
 *   String class가 이것으로 구현됨.
 * 
 *   1. 팩토리는 객체를 저장할 자료구조를 가지고 있으며,
 *   2. 생성할려는 객체가 저장 공간에 있는지 확인
 *   3. 없으면 만들고(new) -> 저장공간에 넣고(put) 리턴, 있으면 꺼내서(get) 리턴
 */

import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
        System.out.println("Color: " + this.color +
                           " X: " + this.x +
                           " Y: " + this.y +
                           " Radius: " + this.radius);
    }
}

class ShapeFactory {
    private static Map<String, Shape> cache = new HashMap<>();

    public static Circle getCircle(String color) {
        Shape circle = cache.get(color);

        if (circle == null) {
            circle = new Circle(color);
            cache.put(color, circle);
            System.out.println("Create circle of color: " + color);
        }

        return (Circle)circle;
    }
}

public class FlyweightPattern {
    private static final String[] COLORS = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i=0; i<20; ++i) {
            Circle circle = ShapeFactory.getCircle(getRandomColor());

            circle.setX(getRandomX());
            circle.setX(getRandomY());
            circle.setRadius(7000);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return COLORS[(int)(Math.random()*COLORS.length)];
    }

    private static int getRandomX() {
        return (int)(Math.random()*100);
    }

    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}