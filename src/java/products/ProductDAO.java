/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utils.ProcessFile;

/**
 *
 * @author LokDQ
 */
public class ProductDAO {

    public List<ProductDTO> getAllProducts(String path) {
        List<ProductDTO> list = new ArrayList<>();
        try {
            Document doc = ProcessFile.getFile(path);
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("product");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
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
//            File inputFile = new File(path);
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(inputFile);
//            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            NodeList nList = doc.getElementsByTagName("product");
//            System.out.println("**************");
//            System.out.println(nList.getLength() + "");
//            System.out.println("-----------------");
//            System.out.println(nList.item(1));

            Document doc = ProcessFile.getFile(path);
            NodeList nList = doc.getElementsByTagName("product");

            for (int i = (index - 1) * 25; i < (index - 1) * 25 + 25; i++) {
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
            e.printStackTrace();
        }
        return list;
    }

    public String addProduct(ProductDTO dto, String path) {
        try {
            Document doc = ProcessFile.getFile(path);

            Node products = doc.getElementsByTagName("products").item(0);
            Element product = doc.createElement("product");
            //id
            Element productId = doc.createElement("productId");
            productId.appendChild(doc.createTextNode(dto.getProductId()));
            product.appendChild(productId);
            //name
            Element productName = doc.createElement("productName");
            productName.appendChild(doc.createTextNode(dto.getProductName()));
            product.appendChild(productName);
            //price
            Element price = doc.createElement("price");
            price.appendChild(doc.createTextNode(dto.getPrice().toString()));
            product.appendChild(price);
            //image
            Element image = doc.createElement("image");
            image.appendChild(doc.createTextNode(dto.getImage()));
            product.appendChild(image);
            //date
            Element creationDate = doc.createElement("creationDate");
            creationDate.appendChild(doc.createTextNode(dto.getCreationDate()));
            product.appendChild(creationDate);
            //categoryid
            Element categoryId = doc.createElement("categoryId");
            categoryId.appendChild(doc.createTextNode(dto.getCategoryId()));
            product.appendChild(categoryId);

            products.appendChild(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Addnew Succesfully";
    }

    public String deleteProduct(String id, String path) {
        try {
            Document doc = ProcessFile.getFile(path);

            NodeList nList = doc.getElementsByTagName("product");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName("productId").item(0).getTextContent().equals(id)) {
                    eElement.getParentNode().removeChild(eElement);
                }
            }
            ProcessFile.saveXMLContent(doc, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete Succefully";
    }

    public String updateProduct(ProductDTO dto, String path) {
        try {
            Document doc = ProcessFile.getFile(path);

            NodeList nList = doc.getElementsByTagName("product");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName("productId").item(0).getTextContent().equals(dto.getProductId())) {
                    eElement.getElementsByTagName("productName").item(0).setTextContent(dto.getProductName());
                    eElement.getElementsByTagName("image").item(0).setTextContent(dto.getImage());
                    eElement.getElementsByTagName("price").item(0).setTextContent(dto.getPrice().toString());
                    eElement.getElementsByTagName("creationDate").item(0).setTextContent(dto.getCreationDate());
                    eElement.getElementsByTagName("categoryId").item(0).setTextContent(dto.getCategoryId());
                }
            }
            ProcessFile.saveXMLContent(doc, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Update Succesfully";
    }
}
