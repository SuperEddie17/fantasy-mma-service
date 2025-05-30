package avc.fantasy_mma_service.fighter;


import lombok.Data;

@Data
public class FighterDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String weightClass;

    private double price;

    private int points;
}
