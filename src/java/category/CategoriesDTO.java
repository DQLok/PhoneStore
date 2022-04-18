/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author LokDQ
 */
public class CategoriesDTO {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String categoryName;
    @XmlElement(required = true)
    protected String icon;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the categoryName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCategoryName(String value) {
        this.categoryName = value;
    }

    /**
     * Gets the value of the icon property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setIcon(String value) {
        this.icon = value;
    }

}
