package com.DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static Map<String, Shape> map = new HashMap<>();

    public static Shape getShape(String color) {
        Circle circle = (Circle) map.get(color);
        if (circle == null) {
            circle = new Circle(color);
            map.put(color, circle);
            System.out.println("Circle's color is:" + color);
        }
        return circle;

    }
}
