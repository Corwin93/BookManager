package org.lance.bookmanager.validator;

import org.lance.bookmanager.annotation.BookValidation;
import org.lance.bookmanager.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

/**
 * Created by Corwin on 09.02.2016.
 */

@Component
@BookValidation
public class BookValidator implements Validator {

    @Autowired
    private MessageSource messageSource;

    public static final String AUTHOR_REGEX = "[a-zA-Z�-��-�'.,\\- ]+";

    public BookValidator() {
        super();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        ValidationUtils.rejectIfEmptyOrWhitespace
                (errors, "title", "title.empty", messageSource.getMessage("title.empty", null, Locale.getDefault()));
        if(book.getAuthor().matches(AUTHOR_REGEX)) {
            ValidationUtils.rejectIfEmptyOrWhitespace
                    (errors, "author", "author.empty", messageSource.getMessage("author.empty", null, Locale.getDefault()));
        } else {
            errors.rejectValue("author", "author.regex", messageSource.getMessage("author.regex", null, Locale.getDefault()));
        }
    }
}
