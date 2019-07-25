package taojinsimu.com.mortgage.condition;

import lombok.Data;

import java.util.List;

/**
 * @author bmr
 * @time 2019-07-25 21:57
 */
@Data
public class LendCondition {

    /**
     * 出借状态集合
     */
    private List<Integer> lendStatusList;
}
