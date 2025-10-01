package br.ufpb.dcx.apiVeiculos.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = MarcaValidator.class)
public @interface MarcaValida {
}
