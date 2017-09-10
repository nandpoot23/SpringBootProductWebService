package com.biscuit.product.service.rest.error;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The HttpStatus member is not output in the final message structure. It is
 * used to set the HTTP status code in the response to the client.
 * 
 * @author mlahariya
 * @version 1.0, March 2017
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "message", "code", "timestamp", "type",
		"status" })
@XmlRootElement(name = "ProductErrorResponse")
public class ProductErrorResponse {

	@JsonProperty
	@XmlElement(name = "message", required = true)
	private String message;

	@JsonProperty
	@XmlElement(name = "code")
	private String code;

	@JsonProperty
	@XmlElement(name = "timestamp", required = true)
	private long timestamp = (new Date()).getTime();

	@JsonProperty
	@XmlElement(name = "type")
	private String type;

	@XmlTransient
	private HttpStatus status;

	/**
     * 
     */
	public ProductErrorResponse() {
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	/**
	 * 
	 * @param status
	 */
	public ProductErrorResponse(HttpStatus status) {
		this.status = status;
	}

	/**
	 * 
	 * @param message
	 */
	public ProductErrorResponse(String message) {
		this();
		this.setMessage(message);
	}

	/**
	 * 
	 * @param message
	 * @param status
	 */
	public ProductErrorResponse(String message, HttpStatus status) {
		this.setMessage(message);
		this.setStatus(status);
	}

	/**
	 * 
	 * @param thrown
	 */
	public ProductErrorResponse(Throwable thrown) {
		this();
		this.setMessage(thrown.getMessage());
		this.setType(thrown.getClass().getName());
	}

	/**
	 * 
	 * @param thrown
	 * @param status
	 */
	public ProductErrorResponse(Throwable thrown, HttpStatus status) {
		this(thrown);
		this.setStatus(status);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @param status
	 *            The status code to use in the response to the client.
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * 
	 * @return
	 */
	public HttpStatus getStatus() {
		return this.status;
	}

}
