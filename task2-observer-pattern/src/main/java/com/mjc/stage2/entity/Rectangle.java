package com.mjc.stage2.entity;

import com.mjc.stage2.Observable;
import com.mjc.stage2.Observer;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

import java.util.HashSet;
import java.util.Set;

public class Rectangle implements Observable {
    private int id;
    private double sideA;
    private double sideB;
    private final Set<Observer> observers = new HashSet<>();

    // Write your code here!
    public Rectangle(int id, double sideA, double sideB) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
        addObserver(RectangleWarehouse.getInstance());
        this.notifyObserver();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        this.notifyObserver();
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        this.notifyObserver();
    }

    public double getSquare() {
        return this.sideA * this.sideB;
    }

    public double getPerimeter() {
        return this.sideA * 2 + this.sideB * 2;
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        this.observers.forEach(observer -> observer.handleEvent(new RectangleEvent(this)));
    }
}
