package bibim.backend.repository;

import bibim.backend.domain.Post;

public interface PostRepository {
    void save(Post post);
    Post findById(Long id);
    void put(Post post);

    Post deleteById(Long postId);
}
