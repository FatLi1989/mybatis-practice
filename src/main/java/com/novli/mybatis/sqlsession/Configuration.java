package com.novli.mybatis.sqlsession;

import com.novli.mybatis.binding.MapperMethod;
import com.novli.mybatis.binding.MapperRegistry;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author novLi
 * @date 2020年02月28日 10:53
 */
public class Configuration {

    private InputStream inputStream;

    MapperRegistry mapperRegistry = new MapperRegistry();


    public void loadConfiguration() throws IOException {
        try {
            Document document = new SAXReader().read(inputStream);
            Element root = document.getRootElement();
            List<Element> mappers = root.element("mappers").elements("mapper");

            for (Element mapper : mappers) {
                if (mapper.attribute("resource") != null) {
                    mapperRegistry.setKnownMappers(loadXmlConfiguration(mapper.attribute("resource").getText()));
                }
                if (mapper.attribute("class") != null) {
                }
            }
        } catch (DocumentException e) {
            System.out.println("读取配置文件错误");
        } finally {
            inputStream.close();
        }
    }

    private Map<String, MapperMethod> loadXmlConfiguration(String resource) {
        Map<String, MapperMethod> map = new HashMap<>();
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream(resource);
            Document document = new SAXReader().read(is);
            Element root = document.getRootElement();

            if (root.getName().equalsIgnoreCase("mapper")) {
                String nameSpace = root.attribute("namespace").getText();
                for (Element select : root.elements("select")) {
                    MapperMethod mapperModal = new MapperMethod();
                    mapperModal.setSql(select.getText().trim());
                    mapperModal.setType(Class.forName(select.attribute("resultType").getText()));
                    map.put(nameSpace + "." + select.attribute("id").getText(), mapperModal);
                }
            }
        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }


    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    public void setMapperRegistry(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }
}
