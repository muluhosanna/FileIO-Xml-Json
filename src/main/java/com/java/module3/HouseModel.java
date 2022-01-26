package com.java.module3;

import java.util.Objects;

public class HouseModel {
    private int windowCount;
    private int doorCount;
    private String interiorPaintColor;

    public HouseModel(int windowCount, int doorCount, String paintColor) {
        this.windowCount = windowCount;
        this.doorCount = doorCount;
        this.interiorPaintColor = paintColor;
    }

    protected HouseModel() {
    }

    public int getWindowCount() {
        return windowCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public String getInteriorPaintColor() {
        return interiorPaintColor;
    }

    @Override
    public String toString() {
        return "HouseModel{" +
                "windowCount=" + windowCount +
                ", doorCount=" + doorCount +
                ", interiorPaintColor='" + interiorPaintColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseModel that = (HouseModel) o;
        return windowCount == that.windowCount && doorCount ==
                that.doorCount && Objects.equals(interiorPaintColor, that.interiorPaintColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(windowCount, doorCount, interiorPaintColor);

    }
}
