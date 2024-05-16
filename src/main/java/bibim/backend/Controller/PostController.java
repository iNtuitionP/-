package bibim.backend.Controller;

import bibim.backend.domain.dto.CreatePostDto;
import bibim.backend.domain.dto.ResponsePostCreateDto;
import bibim.backend.domain.dto.ResponsePostGetDto;
import bibim.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponsePostCreateDto createDto(
            @RequestBody CreatePostDto createPostDto
            ){
        postService.create(createPostDto);
        return new ResponsePostCreateDto(200, "게시글이 정상적으로 작성됨");
    }

    @GetMapping("/post/{postId}")
    public ResponsePostGetDto getPost(
            @PathVariable Long postId
    ){
        return postService.findPost(postId);
    }
}
