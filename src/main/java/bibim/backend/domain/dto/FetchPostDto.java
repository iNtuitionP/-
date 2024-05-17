package bibim.backend.domain.dto;

public record FetchPostDto(
        Long id,
        String title,
        String content
) {
}
