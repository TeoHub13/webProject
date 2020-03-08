package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Proizvoditel {

    @Id
    @Column(name = "proizvoditel_id")
    private Integer proizvoditelId;
    @Column(name = "proizvoditel_ime")
    private String name;
}
