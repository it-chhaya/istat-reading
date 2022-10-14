package co.istad.bms.features.upload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {
    private Integer id;
    private String uuid;
    private String extension;
    private Double size;
    private Boolean isEnabled;
}
