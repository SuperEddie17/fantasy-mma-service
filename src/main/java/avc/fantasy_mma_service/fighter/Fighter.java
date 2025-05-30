package avc.fantasy_mma_service.fighter;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Fighter {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String SecondName;

    private String weightClass;

    private double price;

    private int points;



}
