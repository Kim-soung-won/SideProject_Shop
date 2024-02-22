package com.i.minishopping.Config.CustomValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.ArrayList;
import java.util.List;

public class CustomRuleValidator implements ConstraintValidator<Password, String> {
    private static final int MIN_COMPLEX_RULES = 2; //최소 2개는 맞춰야함
    private static final int MAX_REPETITIVE_CHARS = 3; //동일 문자 반복 횟수
    private static final int MIN_SPECIAL_CASE_CHARS = 1; //특수문자 최소 1개
    private static final int MIN_UPPER_CASE_CHARS = 1; //대문자 최소 1개
    private static final int MIN_LOWER_CASE_CHARS = 1; //소문자 최소 1개
    private static final int MIN_DIGIT_CASE_CHARS = 1; //숫자 최소 1개

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context){
        List<Rule> passwordRules = new ArrayList<>();
        passwordRules.add(new LengthRule(8, 30)); //8자 ~30자 사이
        CharacterCharacteristicsRule characterCharacteristicsRule =
                new CharacterCharacteristicsRule(MIN_COMPLEX_RULES,
                        new CharacterRule(EnglishCharacterData.Special,MIN_SPECIAL_CASE_CHARS),
                        new CharacterRule(EnglishCharacterData.UpperCase,MIN_UPPER_CASE_CHARS),
                        new CharacterRule(EnglishCharacterData.LowerCase,MIN_LOWER_CASE_CHARS),
                        new CharacterRule(EnglishCharacterData.Digit,MIN_DIGIT_CASE_CHARS));
        passwordRules.add(characterCharacteristicsRule);
        passwordRules.add(new RepeatCharacterRegexRule(MAX_REPETITIVE_CHARS));
        PasswordValidator passwordValidator = new PasswordValidator(passwordRules);
        PasswordData passwordData = new PasswordData(password);
        RuleResult ruleResult = passwordValidator.validate(passwordData);
        return ruleResult.isValid();
    }
}
