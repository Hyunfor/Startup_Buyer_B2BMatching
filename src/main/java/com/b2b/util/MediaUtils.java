package com.b2b.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtils {
	//MediaUtils 확장자를 가지고 이미지 타입인지 판단해주는 역할
	//별도의 클래스로 구성한 이유: 브라우저에서 파일을 다운로드할 것 인지 보여줄 것인지 결정하기 위해
	
	private static Map<String, MediaType> mediaMap;
	
	static{
		
		mediaMap = new HashMap<String, MediaType>();		
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	
	public static MediaType getMediaType(String type){
		
		return mediaMap.get(type.toUpperCase());
	}
}



