package pattern.composite;

import pattern.visitor.Visitor;

import java.util.ArrayList;

public class Shelf implements Item{
    private final ArrayList<Item> children = new ArrayList<>();;
    private String category;
    private static final String NO_NAME = "<No name shelf>";

    public Shelf(){
        category = NO_NAME;
    }

    public Shelf(String category){
        this.category = category;
    }

    public ArrayList<Item> getChildren(){
        return children;
    }

    public void add(Item item){
        children.add(item);
    }

    public void remove(Item item){
        children.remove(item);
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Item item : children){
            price += item.getPrice();
        }
        return price;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Item clone() {
        Shelf shelf = new Shelf(category);
        for(Item item: children){
            shelf.add(item.clone());
        }
        return shelf;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return toString(1);
    }

    public String toString(int k) {
        StringBuilder str = new StringBuilder();
        str.append(category);
        str.append(" ").append(getPrice()).append("\n");

        for(Item item: children){
            for(int i = 0; i < k; i++)
                str.append('\t');
            if(item.getClass() == Shelf.class)
                str.append(((Shelf)item).toString(k+1));
            else
                str.append(item.toString());
        }
        return str.toString();
    }
}
