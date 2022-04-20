/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package utils;

import java.io.File;
import java.io.IOException;
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
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author duylp
 */
public class ConvertXML {

    public static final String[] listCategories = {"","Samsung", "iPhone", "OPPO"};
    public static final String[] listIconsCategories = {"","https://cdn.tgdd.vn/Brand/1/samsungnew-220x48-1.png", "https://cdn.tgdd.vn/Brand/1/logo-iphone-220x48.png", "https://cdn.tgdd.vn/Brand/1/OPPO42-b_5.jpg"};

    public static void GenerateXmlFile(String xmlFilePath, boolean crawlData) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            Element db = document.createElement("db");
            document.appendChild(db);

            Element categories = document.createElement("categories");
            db.appendChild(categories);
            for (int i = 1; i < 4; i++) {
                Element category = document.createElement("category");
                categories.appendChild(category);

                Element id = document.createElement("id");
                id.appendChild(document.createTextNode("C-" + i));
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

            Element product;
            Element productId;
            Element productName;
            Element price;
            Element image;
            Element creationDate;
            Element categoryId;

            int count = 0;
            int priceConst = 37990000;
            for (int i = 1; i < 10; i++) {
                count++;
                product = document.createElement("product");
                products.appendChild(product);

                productId = document.createElement("productId");
                productId.appendChild(document.createTextNode("" + count));
                product.appendChild(productId);

                productName = document.createElement("productName");
                productName.appendChild(document.createTextNode("Samsung Galaxy" + i));
                product.appendChild(productName);

                price = document.createElement("price");
                price.appendChild(document.createTextNode(priceConst + ThreadLocalRandom.current().nextInt(1, 101) + ""));
                product.appendChild(price);

                image = document.createElement("image");
                image.appendChild(document.createTextNode("https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg"));
                product.appendChild(image);

                creationDate = document.createElement("creationDate");
                creationDate.appendChild(document.createTextNode(LocalDateTime.now().format(formatter)));
                product.appendChild(creationDate);

                categoryId = document.createElement("categoryId");
                categoryId.appendChild(document.createTextNode("C-1"));
                product.appendChild(categoryId);

            }

            if (crawlData) {
                String link = "https://www.hnammobile.com/dien-thoai?filter=p-desc&page=";
                for (int i = 1; i < 5; i++) {
                    org.jsoup.nodes.Document doc = Jsoup.connect(link + i).timeout(5000).get();
                    Elements pName = doc.select("div[class=product-mid]>h3[class=product-name]>a");
                    Elements pImage = doc.select("div[class=product-mid]>div[class=product-image]>figure>a>picture>img");
                    Elements pPrice = doc.select("div[class=product-mid]>div[class=product-price vat]>b");
                    for (int j = 0; j < 25; j++) {
                        count++;
                        product = document.createElement("product");
                        products.appendChild(product);

                        productId = document.createElement("productId");
                        productId.appendChild(document.createTextNode("" + count));
                        product.appendChild(productId);

                        productName = document.createElement("productName");
                        productName.appendChild(document.createTextNode(pName.get(j).ownText()));
                        product.appendChild(productName);

                        price = document.createElement("price");
                        price.appendChild(document.createTextNode(pPrice.get(j).ownText().replaceAll("[.đ]","")));
                        product.appendChild(price);

                        image = document.createElement("image");
                        image.appendChild(document.createTextNode(pImage.get(j).attr("data-src")));
                        product.appendChild(image);

                        creationDate = document.createElement("creationDate");
                        creationDate.appendChild(document.createTextNode(LocalDateTime.now().format(formatter)));
                        product.appendChild(creationDate);

                        categoryId = document.createElement("categoryId");
                        if (pName.get(j).ownText().substring(0, 3).equalsIgnoreCase("App")) {
                            categoryId.appendChild(document.createTextNode("C-2"));
                        } else if (pName.get(j).ownText().substring(0, 3).equalsIgnoreCase("OPP")) {
                            categoryId.appendChild(document.createTextNode("C-3"));
                        } else {
                            categoryId.appendChild(document.createTextNode("C-1"));
                        }
                        product.appendChild(categoryId);
                    }
                }
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
