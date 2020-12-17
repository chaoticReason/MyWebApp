package parser;

import pattern.composite.Item;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public abstract class AbstractParser {
    abstract public Item itemReturn(String filePath) throws IOException, XMLStreamException;
}

