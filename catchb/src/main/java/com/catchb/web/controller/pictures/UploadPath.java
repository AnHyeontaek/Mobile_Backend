package com.catchb.web.controller.pictures;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
//사진 업로드 시 필요 이미지 넣을 경로지정
public class UploadPath {
    public static String attach_path ="api/pictures";


    public static String path(HttpServletRequest request){
        String uploadPath ="";

        try{
            String root_path =request.getServletContext().getRealPath("/");

            uploadPath =root_path+attach_path.replace('/', File.separatorChar);

        }catch(Exception e){
            e.printStackTrace();
        }

        return uploadPath;
    }
}
