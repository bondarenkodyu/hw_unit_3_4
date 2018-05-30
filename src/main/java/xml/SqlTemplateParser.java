package xml;

import dao.Entity;
import dao.Operation;
import dao.Vendor;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class SqlTemplateParser {

    public static Map<Vendor, Map<Entity, Set<TemplateNode>>> parse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("C:\\Users\\dbond\\IdeaProjects\\hw_unit_3_4\\web\\WEB-INF\\resources\\sql\\sql.xml");
        document.normalizeDocument();
        Map<Vendor, Map<Entity, Set<TemplateNode>>> result = new HashMap<>();
        Element root =  document.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("vendor");
        for(int i = 0; i < nodeList.getLength(); i++){
            Map<Entity, Set<TemplateNode>> vendorMap = new HashMap<>();
            fillTimplateMap(nodeList.item(i), vendorMap);
            String vendor = extractAttribute(nodeList.item(i), "type");
            result.put(Vendor.valueOf(vendor), vendorMap);
        }
        return result;
    }

    private static void fillTimplateMap(Node node, Map<Entity, Set<TemplateNode>> map){
        NodeList entityList = getChildren(node, "entity");
        for (int i = 0; i < entityList.getLength(); i++){
            if (isElement(entityList.item(i))){
                Node entity = entityList.item(i);
                String entityType = extractAttribute(entity, "type");
                NodeList statementList = getChildren(entity, "statement");
                Set<TemplateNode> sqlSet = new HashSet<>();
                for (int j = 0; j < statementList.getLength(); j++){
                    String operation = extractAttribute(statementList.item(j), "type");
                    String sql = extractText(statementList.item(j));
                    sqlSet.add(new TemplateNode(Operation.valueOf(operation), sql));
                }
                map.put(Entity.valueOf(entityType), sqlSet);
            }
        }
    }

    private static NodeList getChildren(Node node, String tag){
        Element element = (Element) node;
        return element.getElementsByTagName(tag);
    }


    private static String extractAttribute(Node node, String attrName){
        return node.getAttributes().getNamedItem(attrName).getNodeValue();
    }

    private static String extractAttributeUpperCase(Node node, String attrName){
        return extractAttribute(node, attrName).toUpperCase();
    }


    private static String extractText(Node node){
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            if (nodeList.item(i).getNodeType() == Node.CDATA_SECTION_NODE){
                return nodeList.item(i).getTextContent().trim();
            }
        }
        return "";
    }


    private static boolean isElement(Node node){
        return node.getNodeType() == Node.ELEMENT_NODE;
    }



}
