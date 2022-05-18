package au.com.rainmore.input;

import java.util.List;

public interface Validator<T> {

    void validate(T t, List<Error> errors);

}