package com.catchb.web.controller.images;

import com.catchb.web.dto.images.ImagesResponseDto;
import com.catchb.web.dto.images.ImagesSaveRequestDto;
import com.catchb.service.images.ImagesService;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/images")
public class ImagesAPIController {
    private final ImagesService imagesService;

    @RequestMapping( method = RequestMethod.POST)
    public Map upload(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                      @RequestParam Map<String, String> paramMap){
        String image_address = paramMap.get("image_address");
        String image_credit = paramMap.get("image_credit");
        String image_starttime = paramMap.get("image_starttime");
        String image_endtime = paramMap.get("image_endtime");
        String image_description = paramMap.get("image_description");
        String image_hint = paramMap.get("image_hint");

        System.out.println(image_address + ", " +image_credit + ", " +image_description);
        String path = "C:\\Users\\anht0\\upload_image\\"+image_address;
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
        imagesService.save(image_address, image_credit, image_starttime, image_endtime, image_description, path+"\\"+fileName, fileName,image_hint);
        return  null;

    }

    @GetMapping(value = "/{image_id}")
    public ImagesResponseDto findById(@PathVariable Long image_id){
        return imagesService.findById(image_id);
    }

    @GetMapping(value = "/address/{image_address}")
    public List<ImagesResponseDto> findByAddress(@PathVariable String image_address){
        return imagesService.findByAddress(image_address);
    }

    @GetMapping(value = "/name/{image_name}")
    public List<ImagesResponseDto> findByName(@PathVariable String image_name){
        return imagesService.findByName(image_name);
    }

    @GetMapping(value = "/id/{image_id}")
    public List<ImagesResponseDto> findById2(@PathVariable Long image_id){
        return imagesService.findById2(image_id);
    }

    @GetMapping(value = "/view", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] imageSearch(@RequestParam("image_address") String image_address,
                              @RequestParam("image_name") String image_name) throws IOException {

        //for(int i = 0; )
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String fileDir = "C:\\Users\\anht0\\upload_image\\" + image_address + "\\" + image_name;
        System.out.println(fileDir);
        //String fileDir = "C:\\pictures\\Busan\\jisoo.jpg";
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
