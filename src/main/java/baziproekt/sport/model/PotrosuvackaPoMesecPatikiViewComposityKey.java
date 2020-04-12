package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PotrosuvackaPoMesecPatikiViewComposityKey implements Serializable {

    private Integer produktId;
    private Integer mesec;
    private Integer godina;

}
