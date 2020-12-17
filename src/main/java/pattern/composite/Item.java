package pattern.composite;

import pattern.visitor.Visitor;

public interface Item{
    double getPrice();
    void accept(Visitor v);
    Item clone();
}
