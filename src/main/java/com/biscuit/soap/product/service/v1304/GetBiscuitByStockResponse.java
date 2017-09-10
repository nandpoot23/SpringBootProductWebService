package com.biscuit.soap.product.service.v1304;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getBiscuitByStockResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getBiscuitByStockResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.product.soap.biscuit.com/}brandStock" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBiscuitByStockResponse", propOrder = { "_return" })
@XmlRootElement(name = "getBiscuitByStockResponse")
public class GetBiscuitByStockResponse {

    @XmlElement(name = "return")
    protected BrandStock _return;

    /**
     * Gets the value of the return property.
     * 
     * @return possible object is {@link BrandStock }
     * 
     */
    public BrandStock getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *            allowed object is {@link BrandStock }
     * 
     */
    public void setReturn(BrandStock value) {
        this._return = value;
    }

}
