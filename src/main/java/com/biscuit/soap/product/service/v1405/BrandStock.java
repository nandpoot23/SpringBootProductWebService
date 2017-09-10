package com.biscuit.soap.product.service.v1405;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for brandStock complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="brandStock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="biscuitBrand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biscuitStock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brandStock", propOrder = { "biscuitBrand", "biscuitStock" })
@XmlRootElement(name = "brandStock")
public class BrandStock {

    protected String biscuitBrand;
    protected String biscuitStock;

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

}
