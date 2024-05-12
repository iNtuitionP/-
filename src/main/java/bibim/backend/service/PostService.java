package bibim.backend.service;

import bibim.backend.domain.Post;
import bibim.backend.domain.dto.CreatePostDto;
import bibim.backend.domain.dto.ResponsePostGetDto;
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
        return new ResponsePostGetDto(post.getTitle(), post.getContent());
    }
}
