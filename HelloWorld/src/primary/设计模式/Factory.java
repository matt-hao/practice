package primary.设计模式;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Map<Class, Shape> map = new HashMap<>();

    public static Shape getShape(Class<? extends Shape> clazz) {
        Shape obj = null;
        try {
            if (map.containsKey(clazz)) {
                obj = map.get(clazz);
            } else {
                Class c = Class.forName(clazz.getName());
                obj = (Shape) c.newInstance();
                map.put(clazz, obj);
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        assert obj != null;
        obj.draw();
        return obj;
    }

    public static void main(String[] args) {
        Factory.getShape(Circle.class);
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    Circle() {
        System.out.println("Circle...");
    }

    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}

class Triangle implements Shape {

    Triangle() {
        System.out.println("Triangle...");
    }

    @Override
    public void draw() {
        System.out.println("draw triangle");
    }
}