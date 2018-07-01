package org.zk.tech;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 5/22/2018.
 */
public class DomTest {

    private static final Log LOGGER = LogFactory.getLog(DomTest.class);

    /**
     * JAXP attribute used to configure the schema language for validation.
     */
    private static final String SCHEMA_LANGUAGE_ATTRIBUTE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    /**
     * JAXP attribute value indicating the XSD schema language.
     */
    private static final String XSD_SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";

    @Test
    public void test1() throws Exception {
        Resource res = new ClassPathResource("applicationContext.xml");
        InputSource inputSource = new InputSource(res.getInputStream());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(true);
        factory.setAttribute(SCHEMA_LANGUAGE_ATTRIBUTE, XSD_SCHEMA_LANGUAGE);

        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        dBuilder.setErrorHandler(new SimpleSaxErrorHandler(LOGGER));
        Document doc = dBuilder.parse(inputSource); // 整个xml文档

        Element root = doc.getDocumentElement(); // beans
        NodeList noList = root.getChildNodes(); // beans的子元素
        for (int i = 0; i < noList.getLength(); i++) {
            Node node = noList.item(i); // text bean text 这3个
            if (node instanceof Element) {
                System.out.println(((Element) node).getAttribute("id"));
                System.out.println(((Element) node).getAttribute("class"));
            }
        }
    }

    @Test
    public void testMyXsd() throws Exception{
        Resource res = new ClassPathResource("myDom.xml");
        InputSource inputSource = new InputSource(res.getInputStream());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(true);
        factory.setAttribute(SCHEMA_LANGUAGE_ATTRIBUTE, XSD_SCHEMA_LANGUAGE);

        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        dBuilder.setEntityResolver(new MyEntityResolver());
        dBuilder.setErrorHandler(new SimpleSaxErrorHandler(LOGGER));
        Document doc = dBuilder.parse(inputSource); // 整个xml文档

        Element root = doc.getDocumentElement(); // beans
        NodeList noList = root.getChildNodes(); // beans的子元素
        for (int i = 0; i < noList.getLength(); i++) {
            Node node = noList.item(i); // text bean text 这3个
            if (node instanceof Element) {
                System.out.println(((Element) node).getAttribute("id"));
                System.out.println(((Element) node).getAttribute("class"));
            }
        }
    }

    // EntityResolver 用于本地查找xsd，不用到网络上去下载xsd
    static class MyEntityResolver implements EntityResolver {

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            ClassPathResource resource = new ClassPathResource("zk-beans.xsd");
            InputSource inputSource = new InputSource(resource.getInputStream());
            inputSource.setPublicId(publicId);
            inputSource.setSystemId(systemId);
            return inputSource;
        }
    }

}
