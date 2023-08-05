package pm.practice.cinema.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pm.practice.cinema.dto.incoming.ScreeningCommand;

@Component
public class ScreeningValidators implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ScreeningCommand.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        ScreeningCommand screeningCreationCommand = (ScreeningCommand) target;
        if (screeningCreationCommand.getTitle().trim().length() < 3) {
            errors.rejectValue("title", "screening.title.tooShort");
        }
        if (screeningCreationCommand.getTotalSeat() == null) {
            errors.rejectValue("seats", "screening.seats.notGiven");
        }
    }
}
