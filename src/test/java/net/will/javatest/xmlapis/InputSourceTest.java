package net.will.javatest.xmlapis;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InputSourceTest {
    @Test
    public void test01() throws Exception {
        String xml = "<QueryResult >Asset</QueryResult>";
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml.trim()));
        Document doc = builder.parse(is);
        
        assertNotNull(doc);
        Element elm = doc.getDocumentElement();
        assertNotNull(elm);
        
        assertEquals(elm.getTextContent(), "Asset");
    }
}
