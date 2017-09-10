package com.biscuit.soap.product.service.v1001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for productDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="productDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="marketValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productDetails", propOrder = { "id", "marketValue", "productName", "productType", "productValue" })
@XmlRootElement(name = "productDetails")
public class ProductDetails {

    protected int id;
    protected String marketValue;
    protected String productName;
    protected String productType;
    protected String productValue;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the marketValue property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getMarketValue() {
        return marketValue;
    }

    /**
     * Sets the value of the marketValue property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setMarketValue(String value) {
        this.marketValue = value;
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
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setProductType(String value) {
        this.productType = value;
    }

    /**
     * Gets the value of the productValue property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getProductValue() {
        return productValue;
    }

    /**
     * Sets the value of the productValue property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setProductValue(String value) {
        this.productValue = value;
    }

}
