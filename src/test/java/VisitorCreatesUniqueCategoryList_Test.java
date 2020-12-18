import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import parser.STAXParserXML;
import pattern.composite.Item;
import pattern.visitor.VisitorCreatesUniqueCategoryList;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;

public class VisitorCreatesUniqueCategoryList_Test extends Assert{
    private static Item item;

    @BeforeClass
    public static void init() throws IOException, XMLStreamException {
        item = new STAXParserXML().itemReturn("/test5.xml") ;
    }

    @Test
    public void test(){
        VisitorCreatesUniqueCategoryList v = new VisitorCreatesUniqueCategoryList();
        item.accept(v);
        ArrayList<String> arr = v.getCategories();
        assertTrue(arr.contains("Dessert"));
        assertTrue(arr.contains("Milk"));
        assertTrue(arr.contains("Granola"));
        assertTrue(arr.contains("Pancake"));
        assertTrue(arr.contains("Soybean"));
        assertTrue(arr.contains("Main"));
        assertTrue(arr.contains("Cake"));
    }
}
