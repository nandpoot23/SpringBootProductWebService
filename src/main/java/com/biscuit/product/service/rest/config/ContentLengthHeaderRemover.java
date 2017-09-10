package com.biscuit.product.service.rest.config;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

/**
 * Little trick to pass over some stupid contentLength error
 * 
 * The reason this trick is needed is because when you create your own
 * HttpClient, the Apache framework wants to duplicate some of the HttpHeader
 * fields. Eg, it will attempt to send two 'Length' headers, which returns an
 * error from the server.
 * 
 * @author mlahariya
 * @version 1.0, March 2017
 */

class ContentLengthHeaderRemover implements HttpRequestInterceptor {

	@Override
	public void process(HttpRequest request, HttpContext context)
			throws HttpException, IOException {
		request.removeHeaders(HTTP.CONTENT_LEN);

	}

}
