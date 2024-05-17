package bibim.backend.domain.dto;

public record ResponsePostDeleteDto(
        int status,
        String title,
        String content,
        String message
) {
}
