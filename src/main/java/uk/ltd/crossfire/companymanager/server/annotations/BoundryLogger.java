package uk.ltd.crossfire.companymanager.server.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: awconstable
 * Date: 13/11/2012
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface BoundryLogger {

}
