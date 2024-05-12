package bibim.backend.domain.dto;

import bibim.backend.domain.Post;

import java.util.List;

public record ResponseMemberGetDto(
        String name,
        int age,
        List<Post> posts
) {
}
