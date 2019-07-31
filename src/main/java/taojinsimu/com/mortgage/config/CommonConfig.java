package taojinsimu.com.mortgage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2019-07-31 13:58
 */

@Data
@Component
@ConfigurationProperties(prefix = "common-config")
public class CommonConfig {

    private Integer page;


    private Integer pageSize;
}
