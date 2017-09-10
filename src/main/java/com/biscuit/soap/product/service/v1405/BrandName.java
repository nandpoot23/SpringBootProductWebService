package com.biscuit.soap.product.service.v1405;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for brandName complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="brandName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="biscuitBrand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "brandName", propOrder = { "biscuitBrand", "biscuitType" })
@XmlRootElement(name = "brandName")
public class BrandName {

    protected String biscuitBrand;
    protected String biscuitType;

    /**
     * Gets the value of the biscuitBrand property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBiscuitBrand() {
        return biscuitBrand;
    }

    /**
     * Sets the value of the biscuitBrand property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBiscuitBrand(String value) {
        this.biscuitBrand = value;
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
