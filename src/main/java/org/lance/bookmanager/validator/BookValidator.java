package org.lance.bookmanager.validator;

import org.lance.bookmanager.annotation.BookValidation;
import org.lance.bookmanager.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Corwin on 09.02.2016.
 */

@Component
@BookValidation
public class BookValidator implements Validator {
    public BookValidator() {
        super();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.name", "Title mustn't be empty!");
    }
}
