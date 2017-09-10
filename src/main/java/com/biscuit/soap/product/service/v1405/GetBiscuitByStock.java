package com.biscuit.soap.product.service.v1405;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getBiscuitByStock complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getBiscuitByStock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service.product.soap.biscuit.com/}biscuitIdentity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBiscuitByStock", propOrder = { "arg0" })
@XmlRootElement(name = "getBiscuitByStock")
public class GetBiscuitByStock {

    protected BiscuitIdentity arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return possible object is {@link BiscuitIdentity }
     * 
     */
    public BiscuitIdentity getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *            allowed object is {@link BiscuitIdentity }
     * 
     */
    public void setArg0(BiscuitIdentity value) {
        this.arg0 = value;
    }

}
