package io.qameta.allure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A file with additional information captured during a testng such
 * as log, screenshot, log file, dump, server response and so on.
 * When some testng fails attachments help to understand the reason
 * of failure faster.
 * <p/>
 * An attachment is simply a method annotated with
 * {@link Attachment} returns either String or byte array
 * which should be added to report:
 * <p/>
 * <pre>
 *  &#064;Attachment(value = "Page screenshot", type = "image/png")
 *  public byte[] saveScreenshot(byte[] screenShot) {
 *      return screenShot;
 *  }
 *  </pre>
 *
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 15.05.14
 * @since 1.4.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Attachment {

    /**
     * Attachment name
     */
    String value() default "{method}";

    /**
     * Valid attachment MimeType, for example "text/plain" or "application/json"
     */
    String type() default "";

    /**
     * Optional attachment file extension. By default file extension will be determined by
     * provided media type. Should be started with dot.
     */
    String fileExtension() default "";
}
