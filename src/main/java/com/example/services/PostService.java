package com.example.services;

import com.example.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public String uplaodImage(MultipartFile file, String path)
            throws IOException {

        String name = file.getOriginalFilename();
        String pathFile = path + File.separator + name;
        File f = new File(path);

        if (!f.exists()) {
            f.mkdir();
        } else {
            Files.copy(file.getInputStream(), Paths.get(pathFile));
        }
        return name;

    }
}


