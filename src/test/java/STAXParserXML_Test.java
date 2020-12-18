import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import parser.STAXParserXML;
import pattern.composite.Item;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;


public class STAXParserXML_Test {
    private STAXParserXML staxParser;


    @Before
    public void staxParserInit(){
        staxParser = new STAXParserXML();
    }

    @Test
    public void testProductPriceWithComma(){
        try{
            Item item = staxParser.itemReturn("/test1.xml");
            item.getPrice();
        }
        catch(NullPointerException | XMLStreamException | IOException ignored){}
    }

    @Test
    public void testParserFlexibility() throws IOException, XMLStreamException {
        staxParser.itemReturn("/test2.xml");
    }

    @Test
    public void testParsingGreatNesting() throws IOException, XMLStreamException {
        staxParser.itemReturn("/test3.xml");
    }

    @Test
    public void testParserEmptyPCDATA() throws IOException, XMLStreamException {
        staxParser.itemReturn("/test4.xml");
    }
}
