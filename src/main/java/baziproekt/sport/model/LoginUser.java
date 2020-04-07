package baziproekt.sport.model;

import baziproekt.sport.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUser {

    private String username;
    private Integer id;
    private Role uloga;
}
