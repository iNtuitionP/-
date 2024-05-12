package bibim.backend.Controller;

import bibim.backend.domain.dto.CreateMemberDto;
import bibim.backend.domain.dto.ResponseMemberCreateDto;
import bibim.backend.domain.dto.ResponseMemberGetDto;
import bibim.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseMemberCreateDto createMember(
            @RequestBody CreateMemberDto createMemberDto
    ){
        memberService.create(createMemberDto);
        return new ResponseMemberCreateDto(200, "멤버가 잘 생성됨.");
    }
    @GetMapping("/member/{memberId}")
    public ResponseMemberGetDto getMember(
            @PathVariable Long memberId
    ){
        return memberService.findMember(memberId);
    }
}
