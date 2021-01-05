/**
 * Abstract Factory Pattern
 *   (Factory of Factories)
 */

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw() method.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw() method.");
    }
}

class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("RoundedRectangle::draw() method.");
    }
}

class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("RoundedSquare::draw() method.");
    }
}

/**
 * Abstract Factory
 */
abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

/**
 * Factory Concrete
 */
class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }

        return null;
    }
}

/**
 * Factory Concrete
 */
class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RoundedRectangle")) {
            return new RoundedRectangle();
        } else if (shapeType.equalsIgnoreCase("RoundedSquare")) {
            return new RoundedSquare();
        }

        return null;
    }
}

/**
 * Factory generator/producer
 *   get factories
 */
class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        Shape rectangle = shapeFactory.getShape("rectangle");
        Shape square = shapeFactory.getShape("Square");

        AbstractFactory roundedShapeFactory = FactoryProducer.getFactory(true);
        Shape roundedRectangle = roundedShapeFactory.getShape("roundedRectangle");
        Shape roundedSqaure = roundedShapeFactory.getShape("roundedSquare");

        rectangle.draw();
        square.draw();
        roundedRectangle.draw();
        roundedSqaure.draw();
    }
}