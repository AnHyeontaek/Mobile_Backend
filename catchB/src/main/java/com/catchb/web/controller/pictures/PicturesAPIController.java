package com.catchb.web.controller.pictures;

import com.catchb.domain.pictures.PicturesRepository;
import com.catchb.service.pictures.PicturesService;
import com.catchb.web.dto.pictures.PicturesRequestDto;
import com.catchb.web.dto.pictures.PicturesResponsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/pictures")
public class PicturesAPIController {
    private final PicturesService picturesService;

//    @RequestMapping(value = "/temp", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String upload(@RequestParam("file")MultipartFile file)throws IOException{
//        .....
//    }

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
        System.out.println(picturesService.save(pictures_loc,pictures_name,path+"\\"+fileName));
        return  null;

    }



}
