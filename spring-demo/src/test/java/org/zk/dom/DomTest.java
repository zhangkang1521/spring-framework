package org.zk.dom;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

/**
 * Created by Administrator on 5/22/2018.
 */
public class DomTest {

    @Test
    public void test1() throws Exception {
        Resource res = new ClassPathResource("applicationContext.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(res.getFile()); // 整个xml文档
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
}
