package rulesEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadingRules {

    public static Map<String, Object> loadRules(){

        double interest_rate_change_amount_for_higher_credit_score = .3;
        double interest_rate_change_amount_for_lower_credit_score = .5;
        int credit_score_condition = 720;

        Map<String, Object> product_type_with_interest_rate_change_amount = new HashMap<>();
        product_type_with_interest_rate_change_amount.put("7-1 ARM".toLowerCase(), .5);
        product_type_with_interest_rate_change_amount.put("5-1 ARM".toLowerCase(), .4);
        product_type_with_interest_rate_change_amount.put("30 YEARS FIXED".toLowerCase(), .1);

        List<String> disqualified_states = new ArrayList<>();
        disqualified_states.add("FLORIDA".toLowerCase());
        disqualified_states.add("CALIFORNIA".toLowerCase());
        disqualified_states.add("MAINE".toLowerCase());

        Map<String, Object> rules = new HashMap<>();
        rules.put("product_type_with_interest_rate_change_amount", product_type_with_interest_rate_change_amount);
        rules.put("interest_rate_change_amount_for_higher_credit_score", interest_rate_change_amount_for_higher_credit_score);
        rules.put("disqualified_states", disqualified_states);
        rules.put("interest_rate_change_amount_for_lower_credit_score", interest_rate_change_amount_for_lower_credit_score);
        rules.put("credit_score_condition", credit_score_condition);
        return rules;
    }
}
