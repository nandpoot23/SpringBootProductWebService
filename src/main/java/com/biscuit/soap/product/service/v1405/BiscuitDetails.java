package com.biscuit.soap.product.service.v1405;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for biscuitDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="biscuitDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="biscuitBrandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biscuitId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="biscuitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biscuitStock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biscuitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "biscuitDetails", propOrder = { "biscuitBrandName", "biscuitId", "biscuitName", "biscuitStock",
        "biscuitType" })
@XmlRootElement(name = "biscuitDetails")
public class BiscuitDetails {

    protected String biscuitBrandName;
    protected int biscuitId;
    protected String biscuitName;
    protected String biscuitStock;
    protected String biscuitType;

    /**
     * Gets the value of the biscuitBrandName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBiscuitBrandName() {
        return biscuitBrandName;
    }

    /**
     * Sets the value of the biscuitBrandName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBiscuitBrandName(String value) {
        this.biscuitBrandName = value;
    }

    /**
     * Gets the value of the biscuitId property.
     * 
     */
    public int getBiscuitId() {
        return biscuitId;
    }

    /**
     * Sets the value of the biscuitId property.
     * 
     */
    public void setBiscuitId(int value) {
        this.biscuitId = value;
    }

    /**
     * Gets the value of the biscuitName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBiscuitName() {
        return biscuitName;
    }

    /**
     * Sets the value of the biscuitName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBiscuitName(String value) {
        this.biscuitName = value;
    }

    /**
     * Gets the value of the biscuitStock property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBiscuitStock() {
        return biscuitStock;
    }

    /**
     * Sets the value of the biscuitStock property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBiscuitStock(String value) {
        this.biscuitStock = value;
    }

    /**
     * Gets the value of the biscuitType property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBiscuitType() {
        return biscuitType;
    }

    /**
     * Sets the value of the biscuitType property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBiscuitType(String value) {
        this.biscuitType = value;
    }

}
