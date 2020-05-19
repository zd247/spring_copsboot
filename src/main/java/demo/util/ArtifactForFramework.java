package demo.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * To indicate that the constructor is solely there for a framework that needs
 * it but is not intended to be used by the application itself.
 */

@Retention(value = RetentionPolicy.SOURCE)
public @interface ArtifactForFramework { }
