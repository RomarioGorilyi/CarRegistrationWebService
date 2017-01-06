package training.registration.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Roman Horilyi
 */
@Entity
@Data
public class Car implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String color;
    private int weight;
    private String registrationNo;
    private Long engineCapacity;
    private String carDeptId;
}
