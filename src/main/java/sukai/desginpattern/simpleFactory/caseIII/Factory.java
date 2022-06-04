package sukai.desginpattern.simpleFactory.caseIII;

import sukai.desginpattern.simpleFactory.caseII.Product;

public abstract class Factory {
    public abstract AbstractProduct ManufactureContainer();

    public abstract AbstractProduct ManufactureModule();
}
