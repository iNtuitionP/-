package bibim.backend.repository;

import bibim.backend.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryPostRepository implements  PostRepository{
    private static Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public void save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
    }

    @Override
    public Post findById(Long id) {
        // we don't have the post they want to find
        if(!store.containsKey(id)){
            return null;
        }
        // otherwise, there is the post in the DB
        return store.get(id);
    }

    @Override
    public void put(Post post) {
        store.put(post.getId(), post);
    }

    @Override
    public Post deleteById(Long postId) {
        // we don't have the post they want to delete
        if(!store.containsKey(postId)){
            return null;
        }
        // otherwise, we can delete the post
        Post post = store.get(postId);
        store.remove(postId);
        return post;
    }
}
