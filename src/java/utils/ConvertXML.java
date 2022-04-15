/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author duylp
 */
public class ConvertXML {

    public static final String[] listCategories = {"SamSung", "Iphone", "Oppo"};
    public static final String[] listIconsCategories = {"https://cdn.tgdd.vn/Brand/1/samsungnew-220x48-1.png", "https://cdn.tgdd.vn/Brand/1/logo-iphone-220x48.png", "https://cdn.tgdd.vn/Brand/1/OPPO42-b_5.jpg"};

    public static void GenerateXmlFile(String xmlFilePath) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            Element db = document.createElement("db");
            document.appendChild(db);

            Element categories = document.createElement("categories");
            db.appendChild(categories);
            for (int i = 0; i < 3; i++) {
                Element category = document.createElement("category");
                categories.appendChild(category);

                Element id = document.createElement("id");
                id.appendChild(document.createTextNode(i + 1 + ""));
                category.appendChild(id);

                Element categoryName = document.createElement("categoryName");
                categoryName.appendChild(document.createTextNode(listCategories[i]));
                category.appendChild(categoryName);

                Element icon = document.createElement("icon");
                icon.appendChild(document.createTextNode(listIconsCategories[i]));
                category.appendChild(icon);
            }

            Element products = document.createElement("products");
            db.appendChild(products);
            int count = 0;
            int priceConst = 37990000;
            for (int i = 1; i < 10; i++) {
                count++;
                Element product = document.createElement("product");
                products.appendChild(product);

                Element productId = document.createElement("productId");
                productId.appendChild(document.createTextNode("P-" + i));
                product.appendChild(productId);

                Element productName = document.createElement("productName");
                productName.appendChild(document.createTextNode("Samsung Galaxy" + i));
                product.appendChild(productName);

                Element price = document.createElement("price");
                price.appendChild(document.createTextNode(priceConst + ThreadLocalRandom.current().nextInt(1, 101) + ""));
                product.appendChild(price);

                Element image = document.createElement("image");
                image.appendChild(document.createTextNode("https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg"));
                product.appendChild(image);

                Element creationDate = document.createElement("creationDate");
                creationDate.appendChild(document.createTextNode(LocalDateTime.now().format(formatter)));
                product.appendChild(creationDate);

                Element categoryId = document.createElement("categoryId");
                categoryId.appendChild(document.createTextNode("1"));
                product.appendChild(categoryId);

            }
            Element total = document.createElement("total");
            total.appendChild(document.createTextNode("" + count));
            db.appendChild(total);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
