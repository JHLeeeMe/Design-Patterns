/**
 * Prototype Pattern
 *   Cloneable interface를 이용한 패턴
 *   객체 생성의 비용이 큰 경우 사용하기 적합 
 *   e.g. Request db query
 *   
 *   생성한 객체를 자료구조(HashMap 등...)에 보관 -> 호출시 꺼내서 clone()
 */

import java.util.HashMap;

abstract class Shape implements Cloneable {
    private int id;
    protected String type;

    public abstract void draw();

    public String getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}

class Rectangle extends Shape {
    Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Rectangle::draw() method.");
    }
}

class Square extends Shape {
    Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Square::draw() method.");
    }
}

class Circle extends Shape {
    Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Circle::draw() method.");
    }
}

/**
 * Shape concrete class
 */
class ShapeCache {
    private static HashMap<Integer, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(int shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);

        return (Shape)cachedShape.clone();
    }

    public static void loadCache() {
        Shape circle = new Circle();
        circle.setId(1);
        shapeMap.put(circle.getId(), circle);

        Shape rectangle = new Rectangle();
        rectangle.setId(2);
        shapeMap.put(rectangle.getId(), rectangle);

        Shape square = new Square();
        square.setId(3);
        shapeMap.put(square.getId(), square);
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape1 = ShapeCache.getShape(1);
        System.out.println("Shape: " + clonedShape1.getType());

        Shape clonedShape2 = ShapeCache.getShape(2);
        System.out.println("Shape: " + clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape(3);
        System.out.println("Shape: " + clonedShape3.getType());

        Shape clonedShape4 = ShapeCache.getShape(3);
        System.out.println("Shape: " + clonedShape4.getType());

        System.out.println(clonedShape1.hashCode());
        System.out.println(clonedShape2.hashCode());
        System.out.println(clonedShape3.hashCode());
        System.out.println(clonedShape4.hashCode());
    }
}