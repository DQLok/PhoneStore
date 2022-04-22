/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author LokDQ
 */
public class ProductDTO implements Serializable{

    public ProductDTO() {
    }
        
    public ProductDTO(String productId, String productName, BigDecimal price, String image, String creationDate, String categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.creationDate = creationDate;
        this.categoryId = categoryId;
    }
        
    @XmlElement(required = true)
    protected String productId;
    @XmlElement(required = true)
    protected String productName;
    @XmlElement(required = true)
    protected BigDecimal price;
    @XmlElement(required = true)
    protected String image;
    @XmlElement(required = true)
    protected String creationDate;
    @XmlElement(required = true)
    protected String categoryId;

    /**
     * Gets the value of the productId property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setProductId(String value) {
        this.productId = value;
    }

    /**
     * Gets the value of the productName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the image property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the creationDate property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the categoryId property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCategoryId(String value) {
        this.categoryId = value;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productId=" + productId + ", productName=" + productName + ", price=" + price + ", image=" + image + ", creationDate=" + creationDate + ", categoryId=" + categoryId + '}';
    }

}
