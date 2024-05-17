package bibim.backend.domain.dto;

public record PutPostDto(
        Long id,
        String title,
        String content
) {
}
