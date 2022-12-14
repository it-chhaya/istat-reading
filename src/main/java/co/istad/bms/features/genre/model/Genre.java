package co.istad.bms.features.genre.model;

import co.istad.bms.features.upload.model.Image;
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
    private Image icon;
    private Boolean isEnabled;

}
