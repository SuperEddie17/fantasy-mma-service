package avc.fantasy_mma_service.user;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {

    private Long id;

    private String nickname;

    private String email;

    private double budget;

}
