package br.ufpb.dcx.apiVeiculos.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class MarcaValidator implements ConstraintValidator<MarcaValida, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> marcas = Arrays.asList(
                "BYD", "Volkswagen", "Hyundai", "Fiat", "Chevrolet", "Toyota", "Nissan",
                "Jeep", "Honda", "Renault"
        );
        return marcas.contains(s);
    }
}
