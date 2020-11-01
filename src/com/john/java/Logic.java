package com.john.java;


import com.john.java.model.Box;

import java.util.Map;

public class Logic extends BaseClass {

     Logic(Box container, Map<Integer, Box> packingBoxes) {
        super(container, packingBoxes);
    }

    @Override
    public String toString() {
        return String.format("Number of Boxes : %s\n" +
                "Volume of packed Boxes : %s\n" +
                "Volume of container : %s\n" +
                "Wasted Space : %s\n",getNumBoxes(),getTotalPackingBoxVolume(),getContainerVolume(),getWastedSpace());
    }


}
