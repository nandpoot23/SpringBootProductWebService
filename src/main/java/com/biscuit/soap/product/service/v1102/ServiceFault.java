package com.biscuit.soap.product.service.v1102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for serviceFault complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="serviceFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="messages" type="{http://service.product.soap.biscuit.com/}messagesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceFault", propOrder = { "messages" })
public class ServiceFault {

    protected MessagesType messages;

    /**
     * Gets the value of the messages property.
     * 
     * @return possible object is {@link MessagesType }
     * 
     */
    public MessagesType getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *            allowed object is {@link MessagesType }
     * 
     */
    public void setMessages(MessagesType value) {
        this.messages = value;
    }

}
