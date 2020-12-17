package pattern.visitor;

import pattern.composite.Item;
import pattern.composite.Product;
import pattern.composite.Shelf;

import java.util.ArrayList;
import java.util.List;

public class VisitorCreatesList implements Visitor {
        List<Product> list;

        public VisitorCreatesList() {
                list = new ArrayList<>();
        }

        public List<Product> getList() {
                return list;
        }


        @Override
        public void visit(Shelf s) {
                for(Item item: s.getChildren()) {
                        if(item.getClass() == Product.class){
                                list.add((Product)item);
                        }
                        else
                                item.accept(this);
                }
        }

        @Override
        public void visit(Product p) {
                list.add(p);
        }
}
