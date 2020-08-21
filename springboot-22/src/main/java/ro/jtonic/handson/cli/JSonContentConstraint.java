package ro.jtonic.handson.cli;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.jtonic.handson.cli.JSonContentConstraint.JSonContentValidator;

@Documented
@Constraint(validatedBy = JSonContentValidator.class)
@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface JSonContentConstraint {
    String message() default "It must be a valid JSON";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

  @Component
  class JSonContentValidator implements ConstraintValidator<JSonContentConstraint, String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void initialize(JSonContentConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
      final JavaType mapJavaType = TypeFactory.defaultInstance()
          .constructType(new TypeReference<Map<String, String>>() {
          });
      return mapper.canDeserialize(mapJavaType);
    }
  }
}