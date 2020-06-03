package com.mall.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UploadService {
    private static final List<String> CONTENT_TYPES = Arrays.asList("image/gif","image/jpeg","image/png");
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);
    public String upLoadImage(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        // String s = StringUtils.substringAfterLast(originalFilename, ".");
        // 校验文件类型
        String contentType = file.getContentType();
        if(!CONTENT_TYPES.contains(contentType)){
            LOGGER.info("文件类型不合法：{}", originalFilename);
            return null;
        }
        try {
            // 校验文件内容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if(bufferedImage == null) {
                LOGGER.info("文件内容不合法：{}", originalFilename);
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = sdf.format(new Date());
            // 保存到服务器
            file.transferTo(new File("D:\\javaproj\\myMall\\image\\" +time+originalFilename));
            // 返回url
            return "D:\\javaproj\\myMall\\image\\" +time+originalFilename;
        } catch (IOException e) {
            LOGGER.info("服务器内部错误：{}", originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}
