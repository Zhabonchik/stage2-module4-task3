package com.mjc.stage2.warehouse;


import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;

import java.util.HashMap;
import java.util.Map;

public class RectangleWarehouse implements Observer {
    private static RectangleWarehouse instance;
    private Map<Integer, RectangleValues> valueMap;

    private RectangleWarehouse() {
        this.valueMap = new HashMap<>();
    }

    public static RectangleWarehouse getInstance() {
        if (instance == null) {
            instance = new RectangleWarehouse();
        }
        return instance;
    }

    public RectangleValues get(Integer rectangleId) {
        return valueMap.get(rectangleId);
    }

    public RectangleValues put(Integer rectangleId, RectangleValues rectangleValues) {
        return valueMap.put(rectangleId, rectangleValues);
    }

    public boolean remove(Integer rectangleId, RectangleValues rectangleValues) {
        return valueMap.remove(rectangleId, rectangleValues);
    }

    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        RectangleValues rectangleValues = new RectangleValues(rectangle.getSquare(), rectangle.getPerimeter());
        this.valueMap.put(event.getSource().getId(), rectangleValues);
    }
}
