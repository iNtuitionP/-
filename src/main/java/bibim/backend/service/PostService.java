package bibim.backend.service;

import bibim.backend.domain.Post;
import bibim.backend.domain.dto.*;
import bibim.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public String create(CreatePostDto createPostDto){
        Post post = Post.create(createPostDto.title(), createPostDto.content());
        postRepository.save(post);
        return post.getId().toString();
    }

    public ResponsePostGetDto findPost(Long postId){
        Post post = postRepository.findById(postId);
        if(post == null){
            return new ResponsePostGetDto("Error!", "we don't have the post you want, please check if the id you've written is right");
        }
        return new ResponsePostGetDto(post.getTitle(), post.getContent());
    }

    public ResponsePostPutDto putPost(PutPostDto putPostDto) {
        Post post = postRepository.findById(putPostDto.id());
        if(post == null) {
            return new ResponsePostPutDto(500, "id 에 해당하는 post 가 존재하지 않음");
        }
        post.setTitle(putPostDto.title());
        post.setContent(putPostDto.content());

        postRepository.put(post);
        return new ResponsePostPutDto(200, "정상적으로 수정됨");
    }

    public ResponsePostDeleteDto deletePost(Long postId) {
        Post post = postRepository.deleteById(postId);
        if(post == null){
            return new ResponsePostDeleteDto(500, null, null, "id 에 해당하는 post 가 존재하지 않음");
        }
        return new ResponsePostDeleteDto(200, post.getTitle(), post.getContent(), "정상적으로 제거됨");
    }
}
