package com.biscuit.soap.product.service.v1102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getProductMarketRateResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getProductMarketRateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.product.soap.biscuit.com/}productMarketRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductMarketRateResponse", propOrder = { "_return" })
@XmlRootElement(name = "getProductMarketRateResponse")
public class GetProductMarketRateResponse {

    @XmlElement(name = "return")
    protected ProductMarketRate _return;

    /**
     * Gets the value of the return property.
     * 
     * @return possible object is {@link ProductMarketRate }
     * 
     */
    public ProductMarketRate getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *            allowed object is {@link ProductMarketRate }
     * 
     */
    public void setReturn(ProductMarketRate value) {
        this._return = value;
    }

}
