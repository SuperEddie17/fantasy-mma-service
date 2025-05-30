package avc.fantasy_mma_service.user;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreationEditUserDto {

    private String nickname;

    private String email;


}
