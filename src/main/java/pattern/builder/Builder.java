package pattern.builder;

import pattern.composite.Item;
import pattern.composite.Shelf;

public class Builder {
    private final Shelf items = new Shelf();
    private Builder parent;

    public void setCategory(String name){
        items.setCategory(name);
    }

    public void setParent(Builder parent){
        this.parent = parent;
    }

    public Builder item(Item item){
        items.add(item);
        return this;
    }

    public Builder startShelf(){
        Builder builder = new Builder();
        builder.setParent(this);
        return builder;
    }

    public Builder startShelf(String name){
        Builder builder = startShelf();
        builder.setCategory(name);
        return builder;
    }
    public Builder endShelf(){
        parent.add(items);
        return parent;
    }
    public Item getItems(){
        return items.getChildren().get(0);
    }
    public Builder add(Shelf shelf){
        items.add(shelf);
        return this;
    }
}
