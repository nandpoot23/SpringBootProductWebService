package com.biscuit.soap.product.service.v1102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getProductDetailByProId complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getProductDetailByProId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service.product.soap.biscuit.com/}productIdentity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductDetailByProId", propOrder = { "arg0" })
@XmlRootElement(name = "getProductDetailByProId")
public class GetProductDetailByProId {

    protected ProductIdentity arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return possible object is {@link ProductIdentity }
     * 
     */
    public ProductIdentity getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *            allowed object is {@link ProductIdentity }
     * 
     */
    public void setArg0(ProductIdentity value) {
        this.arg0 = value;
    }

}
