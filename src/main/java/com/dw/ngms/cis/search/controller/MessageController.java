package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.exception.ExceptionConstants;
import com.dw.ngms.cis.exception.ResponseBuilderAgent;
import com.dw.ngms.cis.exception.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@CrossOrigin(origins = "*")
public class MessageController implements ExceptionConstants {

	@Autowired
	private ResponseBuilderAgent responseBuilderAgent;


	/**
	 * This is to generate failure response 
	 * 
	 * @param request
	 * @param exception
	 * @return ResponseEntity
	 */
	protected ResponseEntity<?> generateFailureResponse(HttpServletRequest request, Exception exception) {
		RestResponse errorResponse = responseBuilderAgent.createFailureResponse(exception, request.getRequestURI(), RESPONSE_ERROR_CODE);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}//generateFailureResponse

	/**
	 * This is to generate empty response 
	 * 
	 * @param request
	 * @param responseMessage
	 * @return ResponseEntity
	 */
	protected ResponseEntity<?> generateEmptyResponse(HttpServletRequest request, String responseMessage) {
		RestResponse emptyResponse = responseBuilderAgent.createErrorResponse(request.getRequestURI(), responseMessage, RESPONSE_ERROR_CODE);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emptyResponse);
	}//generateEmptyResponse


	protected ResponseEntity<?> generateEmptyWithOKResponse(HttpServletRequest request, String responseMessage) {
		RestResponse emptyResponse = responseBuilderAgent.createErrorResponse(request.getRequestURI(), responseMessage, RESPONSE_SUCCESS_CODE);
		return ResponseEntity.status(HttpStatus.OK).body(emptyResponse);
	}//generateEmptyResponse

	protected ResponseEntity<?> getResponseEntityStream(File reportFile, String reportName) throws Exception {		
		HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+reportName);
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(reportFile.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        String mimeType = URLConnection.guessContentTypeFromName(reportFile.getName());
        if(mimeType == null)
        	mimeType = "application/octet-stream";
        	
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(reportFile.length())
                .contentType(MediaType.parseMediaType(mimeType))
                .body(resource);		
	}//getResponseEntityStream
	
	protected String getResourcePath() throws IOException {
		URL url = this.getClass().getResource("/images/Logo_App.jpg");
		return (url != null && url.getPath() != null) ? 
				url.getPath().replace("/images/Logo_App.jpg", "") : null;
	}//getResourcePath



	
}

