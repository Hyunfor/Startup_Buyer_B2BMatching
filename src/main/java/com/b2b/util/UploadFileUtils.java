package com.b2b.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

  private static final Logger logger = 
      LoggerFactory.getLogger(UploadFileUtils.class);

  // 파일 저장 경로(uploadPath), 원본 파일 이름(originalName), 파일 데이터( byte[] fileData) 3개의 데이터를 파라미터로 전송받는 uploadFile()함수
  public static String uploadFile(String uploadPath, 
                              String originalName, 
                              byte[] fileData)throws Exception{
   //1. UUID를 이용한 고유한 값 생성
    UUID uid = UUID.randomUUID();
    
    //2. UUID를 이용한 고유한 값_파일명
    String savedName = uid.toString() +"_"+originalName;
    
    //3. 저장될 경로를 계산(연, 월, 일)
    String savedPath = calcPath(uploadPath);
    
    //4. 기본경로+폴더 경로+파일이름
    File target = new File(uploadPath +savedPath,savedName);
    
    //5. 원본파일을 저장하는 부분
    FileCopyUtils.copy(fileData, target);
    
    //formatName: 원본파일의 확장자를 의미한다. 
    //--> 6.확장자를 이용해 이미지 파일인 경우와 아닌 경우를 나누어 처리
    String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
    
    String uploadedFileName = null;
   
    //이미지 타입의 파일인 경우에는 썸네일을 생성하고 그렇지 않은 경우에는 makeIcon()을 통해서 만듬
    //결과를 만들어 내는데 makeIcon은 경로 처리를 하는 문자열의 치환용도이다.
    if(MediaUtils.getMediaType(formatName) != null){
      uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
    }else{
      uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
    }
    
    return uploadedFileName;
    
  }
  
  private static  String makeIcon(String uploadPath, 
      String path, 
      String fileName)throws Exception{

    String iconName = 
        uploadPath + path + File.separator+ fileName;
    
    return iconName.substring(
        uploadPath.length()).replace(File.separatorChar, '/');
  }
  
  
  /**
   * uploadPath: 기본경로
   * path: 년/월/일 폴더
   * fileName: 현재 업로드 된 파일의 이름
   */
  //썸네일 이미지를 생성하는 메소드( pom.xml에 imageScalr 라이브어리가 추가되었는지 확인)
  private static  String makeThumbnail(
              String uploadPath, 
              String path, 
              String fileName)throws Exception{
     //BufferedImage는 실제 이미지가 아닌 메모리상의 이미지
     //원본파일을 메모리상으로 로딩하고 크기에 맞게 작은 이미지 파일에 원본 파일을 복사
     BufferedImage sourceImg = 
        ImageIO.read(new File(uploadPath + path, fileName));
   
    //썸네일의 이미지 사이즈를 높이 100으로 맞춤
//    BufferedImage destImg = 
//        Scalr.resize(sourceImg, 
//            Scalr.Method.AUTOMATIC, 
//            Scalr.Mode.FIT_TO_HEIGHT,200
////            Scalr.Mode.FIT_TO_WIDTH, 290
//            
//              );
    BufferedImage destImg = 
          Scalr.resize(sourceImg, 
                Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 290, 200
                );
    //저장되는 썸네일 이미지의 파일이름을 's_'로 시작하도록 함
    //'s_' 를 제외하면 원본파일의 이름임
    String thumbnailName = 
        uploadPath + 
        path + File.separator +"s_"+ fileName;
    
    File newFile = new File(thumbnailName);
    
    //
    String formatName = 
          fileName.substring(fileName.lastIndexOf(".")+1);
    
    
    ImageIO.write(destImg, formatName.toUpperCase(), newFile);
    return thumbnailName.substring(
        uploadPath.length()).replace(File.separatorChar, '/');
    //문자열을 치환하는 이유 : 브라우저에 윈도우의 경로로 사용하는 문자가 인식되지 않기 때문에 /로 치환
  } 
  
  //폴더 생성하는 기능이 필요하기 때문에 기본적인 경로uploadPath를 파라미터로 전달현재 시스템의 날짜에 맞는 테이터를 얻고 기본 경로와 함께  makeDir()전달되어 폴더 생성 
  private static String calcPath(String uploadPath){
    
    Calendar cal = Calendar.getInstance();
    
    String yearPath = File.separator+cal.get(Calendar.YEAR);
    
    String monthPath = yearPath + 
        File.separator + 
        new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);

    String datePath = monthPath + 
        File.separator + 
        new DecimalFormat("00").format(cal.get(Calendar.DATE));
    
    makeDir(uploadPath, yearPath,monthPath,datePath);
    
    logger.info(datePath);
    
    return datePath;
  }
  
  
  private static void makeDir(String uploadPath, String... paths){
    
    if(new File(paths[paths.length-1]).exists()){
      return;
    }
    
    for (String path : paths) {
      
      File dirPath = new File(uploadPath + path);
      
      if(! dirPath.exists() ){
        dirPath.mkdir();
      } 
    }
  }
  
  
}