package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Kieran_Chase
 * @project big-event
 * @date 2026/1/18
 */
@RestController
public class FileUploadController {
    /*@PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        // 1. 获取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 2. 确定存储目录
        String dirPath = "C:\\Users\\bulang\\Desktop\\file\\";
        File dir = new File(dirPath);

        // 3. 【关键修复】如果目录不存在，则自动创建目录
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 4. 执行转存
        // 使用 File(parent, child) 构造器比手动拼字符串更安全，能减少斜杠错误
        file.transferTo(new File(dir, originalFilename));

        return Result.success("url访问地址。。。");
    }
}*/

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        //保证文件的名字是唯一的，从而防止文件覆盖
        String filename= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //file.transferTo(new File("C:\\Users\\bulang\\Desktop\\file\\"+originalFilename));
        String url= AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
