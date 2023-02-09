package com.designpattern.builderpattern.caseI;

/**
 * 施工方
 */
public interface Builder {

    public void buildBasement();

    public void buildWall();

    public void buildRoof();

    public Building getBuilding();
}
