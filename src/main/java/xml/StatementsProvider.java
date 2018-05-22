package xml;

import dao.Entity;
import dao.Operation;
import dao.Vendor;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatementsProvider {

    private static StatementsProvider provider;

    private Map<Vendor, Map<Entity, Set<TemplateNode>>> nodes;

    private StatementsProvider() {
        try {
            nodes = SqlTemplateParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StatementsProvider getProvider(){
        if (provider == null){
            synchronized (StatementsProvider.class){
                if (provider == null){
                    provider = new StatementsProvider();
                }
            }
        }
        return provider;
    }


    public Map<Operation, String> getStatements(Vendor vendor, Entity entity){
        return nodes.entrySet()
                    .stream()
                    .filter(v -> v.getKey() == vendor)
                    .map(Map.Entry::getValue)
                    .map(Map::entrySet)
                    .flatMap(e -> e.stream().filter(o -> o.getKey() == entity))
                    .map(Map.Entry::getValue)
                    .flatMap(set -> set.stream())
                    .collect(Collectors.toMap(TemplateNode::getOperation, TemplateNode::getStatement));
    }


}
