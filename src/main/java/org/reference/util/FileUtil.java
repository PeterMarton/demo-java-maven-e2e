package org.reference.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);


	private FileUtil() {

	}

	public static InputStream getFileContentAsStream(String fileName) throws IOException {
		URL resource = ClassLoader.getSystemResource(fileName);
		if (resource != null) {
			return resource.openStream();
		}
		logger.error("No such file: " + fileName);
		throw new FileNotFoundException("No such file: " + fileName); 
	}
	
	public static String getFileContentAsString(String fileName) throws IOException {
		return IOUtils.toString(getFileContentAsStream(fileName), StringUtil.CHAR_ENCODING_UTF_8);
	}
	
	public static JsonNode getJsonByMethodname(String content, String methodName) throws JsonMappingException, JsonProcessingException {
		JsonNode jsonNode =  new ObjectMapper().readTree(content);
		return jsonNode.get(methodName);
	}


}
//