package ralph.ci.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description  文件上传
 * @author ralph
 * @create 2021-06-05 19:22
 */
@Slf4j
@Controller
public class FromTestController {

    @GetMapping("/form_layouts")
    public String formLayouts(){
        return "form/form_layouts";
    }

    /**
     * @Description MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("[log:] 上传的信息: email={},username={},headerImg={},phots={}",email,username,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\java\\ralph_springboot\\javawork\\cache\\"+originalFilename));
        }
        if(photos.length > 0){
            for(MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\java\\ralph_springboot\\javawork\\cache\\"+originalFilename));
                }
            }
        }
        return "main";
    }
}
