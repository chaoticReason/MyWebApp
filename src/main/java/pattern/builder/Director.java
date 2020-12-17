package pattern.builder;

import pattern.composite.Item;
import pattern.composite.Product;

public class Director {

    public Item cake(){
        return new Builder().
                        startShelf("Cake").
                            item(cream()).
                            startShelf("Biscuit").
                                item(new Product("Flour","Wheat")).
                                item(new Product("Butter","Coconut")).
                            endShelf().
                        endShelf().
                getItems();
    }


    public Item cream(){
        return new Builder().
                        startShelf("Cream").
                            item(new Product("Milk", "Coconut")).
                            item(new Product("Honey")).
                        endShelf().
                getItems();
    }


    public Item cereals(){
        return new Builder().
                        startShelf("Cereals").
                            item(new Product("Milk", "Coconut")).
                            item(new Product("Granola")).
                        endShelf().
                getItems();
    }

}
