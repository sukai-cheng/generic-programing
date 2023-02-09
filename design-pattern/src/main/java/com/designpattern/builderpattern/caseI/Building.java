package com.designpattern.builderpattern.caseI;

import java.util.ArrayList;
import java.util.List;

/**
 * 建筑物
 */
public class Building {

    private final List<String> buildingComponets = new ArrayList<>();

    public void setBasement(String basement) {
        this.buildingComponets.add(basement);
    }

    public void setWall(String wall) {
        this.buildingComponets.add(wall);
    }

    public void setRoof(String roof) {
        this.buildingComponets.add(roof);
    }

    @Override
    public String toString() {
        StringBuilder buildingStr = new StringBuilder();
        for (int i = buildingComponets.size() - 1; i >= 0; i--) {
            buildingStr.append(buildingComponets.get(i));
        }
        return buildingStr.toString();
    }
}
