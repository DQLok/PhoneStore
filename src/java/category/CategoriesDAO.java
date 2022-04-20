/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

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
public class CategoriesDAO {
    
    public List<CategoriesDTO> getAllCategories(String path) {
        List<CategoriesDTO> list = new ArrayList<>();
        try{
            Document doc = ProcessFile.getFile(path);
            NodeList nList = doc.getElementsByTagName("category");
            
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    CategoriesDTO dto = new CategoriesDTO();
                    dto.setId(eElement.getElementsByTagName("id").item(0).getTextContent());
                    dto.setCategoryName(eElement.getElementsByTagName("categoryName").item(0).getTextContent());
                    dto.setIcon(eElement.getElementsByTagName("icon").item(0).getTextContent());
                    list.add(dto);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
