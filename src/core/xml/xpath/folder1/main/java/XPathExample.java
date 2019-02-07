import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Nosov Serzh on 04.11.2018
 */
public class XPathExample {

    private static final String xml =
            "<root>\n" +
            "    <data>\n" +
            "        <person>\n" +
            "            <fullname>Иван Иванович Иванов</fullname>\n" +
            "            <address>ул. Советская, д. 1, кв. 1</address>\n" +
            "            <phonenumber>89998881111</phonenumber>\n" +
            "            <relatives_emails>\n" +
            "                <Email>test1@gmail.com</Email>\n" +
            "                <email>test2@gmail.com</email>\n" +
            "                <email>test3@gmail.com</email>\n" +
            "            </relatives_emails>\n" +
            "        </person>\n" +
            "    </data>\n" +
            "</root>\n";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        //XPathExpression expr = xpath.compile("/root/data/person/relatives_emails/email");
        XPathExpression expr = xpath.compile("//email | //person");
        //XPathExpression expr = xpath.compile("//email");

        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nl.getLength(); i++) {
            Node item = nl.item(i);
            String email = item.getFirstChild().getNodeValue();
            System.out.println(email);
        }
    }
}
