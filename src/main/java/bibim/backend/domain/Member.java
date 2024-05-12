package bibim.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Member {
    private Long id;
    private String name;
    private int age;
    private List<Post> Posts = new ArrayList<>();

    @Builder
    private Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static Member create(String name, int age){
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }
}
