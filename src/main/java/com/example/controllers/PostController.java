package com.example.controllers;

import com.example.models.Post;
import com.example.repositories.PostRepository;
import com.example.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    private PostService postService;
    @Value("${project.file}")
    private String path;

    @PostMapping("/upload")
    public Post uplaodImage(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("content") String content)
            throws IOException {

        if (!(file == null)) {

            return postRepository.save(Post.builder()
                    .fileName(postService.uplaodImage(file, path))
                    .fileType(file.getContentType())
                    .content(content)
                    .createdDate(LocalDate.now())
                    .build());
        } else {

            return postRepository.save(Post.builder().content(content).createdDate(LocalDate.now()).build());
        }
    }

    @GetMapping("/post")
    public List<Post> getListOfPost()
            throws IOException {

        return postRepository.findAll();
    }

    @GetMapping(path = {"/get/image/info/{name}"})
    public Optional<Post> getPost(@PathVariable("name") String name) throws IOException {

        return postRepository.findByFileName(name);
    }

    @DeleteMapping(value = "/deletepost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Integer id) {
        postRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Post deleted with success");
    }

    @GetMapping("/nbr")
    public Long countNbrPost()
            throws IOException {

        return postRepository.count();
    }
}
