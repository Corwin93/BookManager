package org.lance.bookmanager.validator;

import org.lance.bookmanager.annotation.UserValidation;
import org.lance.bookmanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

/**
 * Created by Corwin on 17.04.2016.
 */

@Component
@UserValidation
public class UserValidator implements Validator {

    public static final String EMAIL_REGEX = "[a-zA-Z._]+@[a-zA-Z]+.[a-zA-Z]+";

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        if(user.getNickName().length() > 60 || user.getNickName().length() < 4)
            errors.rejectValue("nickName"
                    , "nickName.size", messageSource.getMessage("nickName.size", null, Locale.getDefault()));
        if(user.getFirstName().length() > 60 || user.getFirstName().length() < 4)
            errors.rejectValue("firstName"
                    , "firstName.size", messageSource.getMessage("firstName.size", null, Locale.getDefault()));
        if(user.getLastName().length() > 60 || user.getLastName().length() < 4)
            errors.rejectValue("lastName"
                    , "lastName.size", messageSource.getMessage("lastName.size", null, Locale.getDefault()));
        if(user.getPassword().length() > 60 || user.getPassword().length() < 5)
            errors.rejectValue("password"
                    , "password.size", messageSource.getMessage("password.size", null, Locale.getDefault()));
        if(!user.getEmail().matches(EMAIL_REGEX)) {
            errors.rejectValue("email", "email.regex", messageSource.getMessage("email.regex", null, Locale.getDefault()));
        } else if(user.getEmail().length() > 60 || user.getEmail().length() < 6) {
            errors.rejectValue("email"
                    , "email.size", messageSource.getMessage("email.size", null, Locale.getDefault()));
        }
    }
}
