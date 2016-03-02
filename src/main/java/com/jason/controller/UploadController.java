package com.jason.controller;

import com.jason.model.ResponseData;
import com.jason.model.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public ResponseData uploadPicture(@RequestParam("file") MultipartFile file) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(Status.FAILURE);
        if (!file.isEmpty()) {
            Map<String, String> data = new HashMap<>();
            BufferedOutputStream bos = null;
            try {
                byte[] bytes = file.getBytes();
                File uploadPicFullFile = new File("./activityPic/" + file.getOriginalFilename());
                data.put("pictureUrl","/activityPic/"+uploadPicFullFile.getName());
                if (!uploadPicFullFile.getParentFile().exists()) {
                    uploadPicFullFile.getParentFile().mkdir();
                }
                bos = new BufferedOutputStream(new FileOutputStream(uploadPicFullFile));
                bos.write(bytes);
                responseData.setData(data);
                responseData.setStatus(Status.SUCCESS);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseData;
    }
}
