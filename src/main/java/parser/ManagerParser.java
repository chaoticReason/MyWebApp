package parser;

public class ManagerParser {
    public static Object manage(String fileName, XML_STYLE choice){
        String extension = fileName.substring(fileName.lastIndexOf("."));
        switch(extension){
            case ".xml":
                switch (choice) {
                    case STAX: {
                        return new STAXParserXML();
                    }
                    case DOM: {
                        return new DOMParserXML();
                    }
                }
            case ".json":
                System.out.println("json:\n");
                return new ParserJSON();
            default:
                throw new UnsupportedOperationException("Неподдерживаемый тип файла");
        }
    }
}