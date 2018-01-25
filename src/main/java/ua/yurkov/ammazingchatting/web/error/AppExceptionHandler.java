package ua.yurkov.ammazingchatting.web.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ua.yurkov.ammazingchatting.service.AmazingChattingException;
import ua.yurkov.ammazingchatting.service.validation.ValidationException;


@RestControllerAdvice
public class AppExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionValue<String>> handleEntityNotFound(NotFoundException nx) {
        LOG.error("Entity was not found. Exception: {}", nx);

        ExceptionValue<String> exceptionValue
                = new ExceptionValue<>(HttpStatus.NOT_FOUND.value(), nx.getMessage());

        return new ResponseEntity<>(exceptionValue, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AmazingChattingException.class)
    public ResponseEntity<ExceptionValue<String>> handleUniversityJournalException(AmazingChattingException acx) {
        LOG.error("Internal error. Exception: {}", acx);

        ExceptionValue<String> exceptionValue
                = new ExceptionValue<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), acx.getMessage());

        return new ResponseEntity<>(exceptionValue, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionValue<String>> handleValidationException(ValidationException vx) {
        LOG.error("Validation error. Exception: {}", vx.getDescription());

        ExceptionValue<String> exceptionValue
                = new ExceptionValue<>(HttpStatus.BAD_REQUEST.value(), vx.getDescription());

        return new ResponseEntity<>(exceptionValue, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionValue<String>> handleArgumentMismatchException(MethodArgumentTypeMismatchException ex) {
        LOG.error("Argument exception. Exception: {}", ex);

        ExceptionValue<String> exceptionValue
                = new ExceptionValue<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        return new ResponseEntity<>(exceptionValue, HttpStatus.BAD_REQUEST);
    }
}
