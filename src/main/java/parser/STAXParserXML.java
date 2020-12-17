package parser;

import pattern.builder.Builder;
import pattern.composite.Item;
import pattern.composite.Product;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class STAXParserXML extends AbstractParser {

    Builder builder;
    Product product;

    public static final String ELEMENT_SHELF = "shelf";
    public static final String ELEMENT_SHELFNAME = "shelfname";
    public static final String ELEMENT_PRODUCT = "product";
    private static final String ELEMENT_ID = "id";
    private static final String ELEMENT_CATEGORY = "category";
    public static final String ELEMENT_FLAVOUR = "flavour";
    public static final String ELEMENT_COUNTRY = "country";
    public static final String ELEMENT_COST = "cost";

    @Override
    public Item itemReturn(String filePath) throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(this.getClass().getResourceAsStream(filePath));
        builder = new Builder();

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case ELEMENT_SHELF:
                        builder = builder.startShelf();
                        break;
                    case ELEMENT_SHELFNAME: {
                        nextEvent = reader.nextEvent();
                        builder.setCategory(nextEvent.asCharacters().getData());
                        break;
                    }
                    case ELEMENT_PRODUCT: product = new Product(); break;
                    case ELEMENT_ID: {
                        nextEvent = reader.nextEvent();
                        product.setId(nextEvent.asCharacters().getData());
                        break;
                    }
                    case ELEMENT_CATEGORY: {
                        nextEvent = reader.nextEvent();
                        product.setCategory(nextEvent.asCharacters().getData());
                        break;
                    }
                    case ELEMENT_FLAVOUR: {
                        nextEvent = reader.nextEvent();
                        product.setFlavour(nextEvent.asCharacters().getData());
                        break;
                    }
                    case ELEMENT_COUNTRY: {
                        nextEvent = reader.nextEvent();
                        product.setCountry(nextEvent.asCharacters().getData());
                        break;
                    }
                    case ELEMENT_COST: {
                        nextEvent = reader.nextEvent();
                        product.setCost(nextEvent.asCharacters().getData());
                        break;
                    }
                    default: throw new IllegalStateException("Unexpected value: " + startElement.getName().getLocalPart());
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                switch (endElement.getName().getLocalPart()) {
                    case ELEMENT_PRODUCT:
                        builder = builder.item(product);
                        break;
                    case ELEMENT_SHELF:
                        builder = builder.endShelf();
                        break;
                    default:
                }
            }
        }

        return builder.getItems();
    }
}

