package co.istad.bms.features.genre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    
    private Integer id;
    private String title;
    private String description;
    private Integer icon;
    private Boolean isEnabled;

}
