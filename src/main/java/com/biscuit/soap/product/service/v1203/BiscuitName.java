package com.biscuit.soap.product.service.v1203;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for biscuitName complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="biscuitName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="biscuitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "biscuitName", propOrder = { "biscuitName" })
@XmlRootElement(name = "biscuitName")
public class BiscuitName {

    protected String biscuitName;

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

}
