package src.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Tool {
    @Getter
    @Setter
    private String toolCode;

    @Getter
    @Setter
    private String toolType;

    @Getter
    @Setter
    private String toolBrand;
}
