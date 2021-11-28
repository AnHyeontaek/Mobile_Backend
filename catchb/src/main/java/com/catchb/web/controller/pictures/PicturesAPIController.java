package com.catchb.web.controller.pictures;

import com.catchb.service.pictures.PicturesService;
import com.catchb.web.dto.pictures.PicturesResponsDto;
import com.catchb.web.dto.pictures.PicturesResultDto;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
//@ComponentScan(basePackages = "com.catchb.web.controller.pictures")

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/pictures")
public class PicturesAPIController {
    private final PicturesService picturesService;
    //List <String> testlist = new ArrayList<String>();

    @RequestMapping(value = "/temp", method = RequestMethod.POST)
    public Map upload(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                      @RequestParam Map<String, String> paramMap){
        String pictures_name = paramMap.get("pictures_name");
        String pictures_loc = paramMap.get("pictures_loc");

        String path = "C:\\pictures\\"+pictures_loc;
        String fileName = "";

        Map<String, Object> map =new HashMap<>();
        try{
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
            Iterator<String> iter = multipartHttpServletRequest.getFileNames();
            MultipartFile multipartFile = null;
            String fieldName = "";
            List<Map<String, java.io.Serializable>> list = new ArrayList<Map<String, java.io.Serializable>>();

            File file = new File(path);
            if(!file.isDirectory()){
                file.mkdir();
            }
            while (iter.hasNext()){
                fieldName = iter.next();
                multipartFile = multipartHttpServletRequest.getFile(fieldName);
                fileName = new String(multipartFile.getOriginalFilename().getBytes("8859_1"), "UTF-8");

                if("".equals(fileName)){
                    continue;
                }
                File serverfile = new File(path + File.separator + fileName);
                multipartFile.transferTo(serverfile);

                Map file2 =new HashMap<>();
                file2.put("fileName", fileName);
                file2.put("serverfile", serverfile);
                list.add(file2);
            }
            map.put("files", list);
            map.put("serverfile", multipartHttpServletRequest.getParameterMap());
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        picturesService.save(pictures_loc,pictures_name,path+"\\"+fileName);
        return  null;
    }

    @GetMapping(value = "/get/{pictures_loc}")
    public List<PicturesResponsDto> findByPicturesLoc(@PathVariable String pictures_loc){
        return picturesService.findByPicturesLoc(pictures_loc);
    }

    @RequestMapping(value = "/PATH", method = {RequestMethod.GET})
    public PicturesResultDto Ppath(@RequestParam(value = "pictures_loc")String pictures_loc){
        return picturesService.Ppath(pictures_loc);
    }

    //이미지 하나 서버에 띄우기
    @GetMapping(value = "/img", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] imageSearch(@RequestParam("pictures_loc") String pictures_loc,
                            @RequestParam("pictures_name") String pictures_name) throws IOException {

        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String fileDir = "C:\\pictures\\" + pictures_loc + "\\" + pictures_name + ".jpg";
        System.out.println(fileDir);
        try {
            fis = new FileInputStream(fileDir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try {
            while ((readCount = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch (IOException e) {
            throw new RuntimeException("File Error");
        }
        return fileArray;
    }
}

