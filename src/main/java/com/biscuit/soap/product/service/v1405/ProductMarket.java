package com.biscuit.soap.product.service.v1405;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for productMarket complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="productMarket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="marketValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "productMarket", propOrder = { "marketValue", "productId", "productValue" })
@XmlRootElement(name = "productMarket")
public class ProductMarket {

    protected String marketValue;
    protected int productId;
    protected String productValue;

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
     * Gets the value of the productId property.
     * 
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     */
    public void setProductId(int value) {
        this.productId = value;
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
