/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author LokDQ
 */
public class ProductDAO {

    public List<ProductDTO> getAllProducts(String path) {
        List<ProductDTO> list = new ArrayList<>();
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("product");
            System.out.println("**************");
            System.out.println(nList.getLength() + "");
            System.out.println("-----------------");
            System.out.println(nList.item(1));

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println(eElement.getElementsByTagName("productId").item(0).getTextContent());

                    ProductDTO dto = new ProductDTO();
                    dto.setProductId(eElement.getElementsByTagName("productId").item(0).getTextContent());
                    dto.setProductName(eElement.getElementsByTagName("productName").item(0).getTextContent());
                    dto.setPrice(new BigDecimal(eElement.getElementsByTagName("price").item(0).getTextContent()));
                    dto.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
                    dto.setCreationDate(eElement.getElementsByTagName("creationDate").item(0).getTextContent());
                    dto.setCategoryId(eElement.getElementsByTagName("categoryId").item(0).getTextContent());
                    list.add(dto);
                }
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<ProductDTO> pagingProducts(String path, int index) {
        List<ProductDTO> list = new ArrayList<>();
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("product");
            System.out.println("**************");
            System.out.println(nList.getLength() + "");
            System.out.println("-----------------");
            System.out.println(nList.item(1));

            for (int i = (index - 1)*25; i < (index - 1)*25 + 25; i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println(eElement.getElementsByTagName("productId").item(0).getTextContent());

                    ProductDTO dto = new ProductDTO();
                    dto.setProductId(eElement.getElementsByTagName("productId").item(0).getTextContent());
                    dto.setProductName(eElement.getElementsByTagName("productName").item(0).getTextContent());
                    dto.setPrice(new BigDecimal(eElement.getElementsByTagName("price").item(0).getTextContent()));
                    dto.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
                    dto.setCreationDate(eElement.getElementsByTagName("creationDate").item(0).getTextContent());
                    dto.setCategoryId(eElement.getElementsByTagName("categoryId").item(0).getTextContent());
                    list.add(dto);
                }
            }
        } catch (Exception e) {

        }
        return list;
    }

}
