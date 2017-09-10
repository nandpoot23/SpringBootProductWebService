package com.biscuit.soap.product.service.v1102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getProductTypeResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getProductTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.product.soap.biscuit.com/}productType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductTypeResponse", propOrder = { "_return" })
@XmlRootElement(name = "getProductTypeResponse")
public class GetProductTypeResponse {

    @XmlElement(name = "return")
    protected ProductType _return;

    /**
     * Gets the value of the return property.
     * 
     * @return possible object is {@link ProductType }
     * 
     */
    public ProductType getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *            allowed object is {@link ProductType }
     * 
     */
    public void setReturn(ProductType value) {
        this._return = value;
    }

}
