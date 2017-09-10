package com.biscuit.soap.product.service.v1405;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for productValue complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="productValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="proValuation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productValue", propOrder = { "proValuation" })
@XmlRootElement(name = "productValue")
public class ProductValue {

    protected String proValuation;

    /**
     * Gets the value of the proValuation property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getProValuation() {
        return proValuation;
    }

    /**
     * Sets the value of the proValuation property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setProValuation(String value) {
        this.proValuation = value;
    }

}
