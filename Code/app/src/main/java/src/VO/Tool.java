package src.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Tool {
    @Getter
    @Setter
    private Boolean toolChargeHoliday;
    
    @Getter
    @Setter
    private Boolean toolChargeWeekend;
    
    @Getter
    @Setter
    private String toolCode;

    @Getter
    @Setter
    private Float toolDailyCharge;

    @Getter
    @Setter
    private String toolType;

    @Getter
    @Setter
    private String toolBrand;
}
