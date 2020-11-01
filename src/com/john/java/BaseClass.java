package com.john.java;



import com.john.java.implementation.BoxImpl;
import com.john.java.implementation.BoxImplI;
import com.john.java.model.Box;

import java.util.Map;

public abstract class BaseClass implements LogicI {
    final Map<Integer, Box> packingBoxes; // holds the number of difference sized boxes;
    BoxImplI containerBoxImplI;

    public BaseClass(Box container, Map<Integer, Box> packingBoxes) {
        this.packingBoxes = packingBoxes;
        this.containerBoxImplI=new BoxImpl(container);
    }

    @Override
    public double getTotalPackingBoxSA() {
        double totalSurfaceArea=0;
        for (Map.Entry<Integer, Box> entry : this.packingBoxes.entrySet()) {
            Integer integer = entry.getKey();
            Box box = entry.getValue();
            totalSurfaceArea += (integer * (new BoxImpl(box).getSurfaceArea()));
        }
        return totalSurfaceArea;
    }

    @Override
    public double getTotalPackingBoxVolume() {
        double totalVolume=0;
        for (Map.Entry<Integer, Box> entry : this.packingBoxes.entrySet()) {
            Integer integer = entry.getKey();
            Box box = entry.getValue();
            totalVolume += (integer * (new BoxImpl(box).getVolume()));
        }
        return totalVolume;
    }

    @Override
    public double getContainerSA() {
        return this.containerBoxImplI.getSurfaceArea();
    }

    @Override
    public double getWastedSpace() {
        return (getContainerSA()-getTotalPackingBoxSA());
    }

    @Override
    public int getNumBoxes() {
        return packingBoxes.keySet().stream().mapToInt(integer -> integer).sum();
    }

    @Override
    public double getContainerVolume() {
        return this.containerBoxImplI.getVolume();
    }
}
