package ge.softgen.loanexpert.security.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnyAccess {
	Access[] value();
}
