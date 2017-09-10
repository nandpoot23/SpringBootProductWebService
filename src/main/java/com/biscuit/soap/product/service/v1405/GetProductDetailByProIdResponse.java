package com.biscuit.soap.product.service.v1405;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getProductDetailByProIdResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getProductDetailByProIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.product.soap.biscuit.com/}productDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductDetailByProIdResponse", propOrder = { "_return" })
@XmlRootElement(name = "getProductDetailByProIdResponse")
public class GetProductDetailByProIdResponse {

    @XmlElement(name = "return")
    protected ProductDetails _return;

    /**
     * Gets the value of the return property.
     * 
     * @return possible object is {@link ProductDetails }
     * 
     */
    public ProductDetails getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *            allowed object is {@link ProductDetails }
     * 
     */
    public void setReturn(ProductDetails value) {
        this._return = value;
    }

}
