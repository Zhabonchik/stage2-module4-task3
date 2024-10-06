package com.mjc.stage2.repository;

import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.warehouse.RectangleWarehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleRepository {
    private static RectangleRepository instance;
    private List<Rectangle> rectangles;

    private RectangleRepository() {
        rectangles = new ArrayList<>();
    }

    public static RectangleRepository getInstance() {
        if (instance == null) {
            instance = new RectangleRepository();
        }
        return instance;
    }

    public boolean add(Rectangle rectangle) {
        return rectangles.add(rectangle);
    }

    public boolean remove(Rectangle rectangle) {
        return rectangles.remove(rectangle);
    }

    public Rectangle getRectangle(int index) {
        Rectangle rectangle = rectangles.get(index);
        rectangle.addObserver(RectangleWarehouse.getInstance());
        return rectangle;
    }

    public List<Rectangle> getRectangles() {
        return Collections.unmodifiableList(rectangles);
    }
}