package com.cpinelli.hydra.ep.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({HydraConfig.class})
public @interface EnableHydra {

    HydraType value() default HydraType.HYDRA;

    public static enum HydraType {
        HYDRA,UBER,SIREN,HTML,HAL
    }


}