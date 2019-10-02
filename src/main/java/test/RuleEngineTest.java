package test;

import person.Person;
import product.Product;
import static rulesEngine.LoadingRules.loadRules;
import rulesEngine.RulesEngine;

import java.util.Map;

public class RuleEngineTest {
    public static void main(String[] args) {

        Person person = new Person(740, "Florida");

        Product product = new Product("7-1 ARM",5.0);

        RulesEngine rules_engine = new RulesEngine();

        Map<String, Object> rules = loadRules();

        rules_engine.runRules(person, product, rules);
    }
}
