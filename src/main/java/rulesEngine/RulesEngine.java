package rulesEngine;

import person.Person;
import product.Product;

import java.util.List;
import java.util.Map;

public class RulesEngine {
    public String runRules(Person person, Product product, Map<String, Object> rules) {

        //I assummed the rules are now as a Map<String, Object> and assuming comes from the settings below:
        /*
        * {
          	disqualified_states:['Florida'],
	        interest_rate_change_amount_for_higher_credit_score: -0.3,
	        interest_rate_change_amount_for_lower_credit_score: 0.5,
	        credit_score_condition: 720,
	        product_type_with_interest_rate_change_amount: {"7-1 ARM": 0.5, "5-1 ARM": 0.4, "30 YEARS FIXED": -0.1}
          }
        * */

        // person, product, rules can not be null
        if (person == null || product == null || rules == null) {
            System.err.println("Person, Product, or Rules cannot be null");
            System.exit(0);
        }

        String result = "";

        //Setting the values from the rules that is loaded...
        List<String> disqualified_states = (List<String>) rules.get("disqualified_states");
        double interest_rate_change_amount_for_higher_credit_score = (double) rules.get("interest_rate_change_amount_for_higher_credit_score");
        double interest_rate_change_amount_for_lower_credit_score = (double) rules.get("interest_rate_change_amount_for_lower_credit_score");
        int credit_score_condition = (int) rules.get("credit_score_condition");
        double interest_rate = product.interest_rate;
        Map<String, Double> product_type_with_interest_rate_change_amount = (Map<String, Double>) rules.get("product_type_with_interest_rate_change_amount");

        //Credit score condition
        double rateForCreditScore = 0.0;
        String operator = "";
        if (person.creditScore >= credit_score_condition) {
            rateForCreditScore = interest_rate_change_amount_for_higher_credit_score;
            interest_rate -= rateForCreditScore;
            operator = " - ";
        } else {
            rateForCreditScore = interest_rate_change_amount_for_lower_credit_score;
            interest_rate += rateForCreditScore;
            operator = " + ";
        }

        //Product name condition(s)
        boolean hasProduct = false;
        double rateForProductType = 0.0;
        if (product_type_with_interest_rate_change_amount.containsKey(product.name.toLowerCase())) {
            rateForProductType = product_type_with_interest_rate_change_amount.get(product.name.toLowerCase());
            interest_rate += rateForProductType;
            hasProduct = true;
        }
        if (!hasProduct) {
            System.out.println("Product '" + product.name + "' not found");
            System.exit(0);
        }

        //Disqualified state(s)
        if (disqualified_states.stream().anyMatch(str -> str.trim().toLowerCase().equals(person.state.toLowerCase()))) {
            product.disqualified = true;
        }

        String strRateForCreditScore = String.valueOf(rateForCreditScore);
        if(strRateForCreditScore.charAt(0)=='0') strRateForCreditScore =strRateForCreditScore.substring(1);

        String strRateForProductType = String.valueOf(rateForProductType);
        if(strRateForProductType.charAt(0)=='0') strRateForProductType =strRateForProductType.substring(1);

        result = "product.interest_rate == " + interest_rate + " ( " + product.interest_rate + operator + strRateForCreditScore + " + "
                + strRateForProductType + " )";
        result += "\n\nproduct.disqualified==" + product.disqualified;
        System.out.println(result);
        return result;
    }
}

