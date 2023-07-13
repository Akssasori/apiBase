package com.redis.cache.exceptions;

import com.redis.cache.config.MessagesConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LocaleContext {
    /**
     * MessageSource object used to get internationalization messages.
     */
    private static MessageSource messageSource;

    /**
     * Creates a static reference to the title source, so that the
     * internationalization of enums can be invoked by objects that cannot
     * have the {@link LocaleContext} component injected (objects that are
     * not spring beans, like DTOs, for example).
     */
    @PostConstruct
    public void init() {

        messageSource = MessagesConfig.loadMessageSource();
    }

    /**
     * Returns an String object that represents a message configured in
     * resource file.
     *
     * @param    format  key to find in resource file
     * @return      return the message value
     * @see         String
     */
    public static String format(final String format) {
        String formatMessage = format;
        try {
            formatMessage = messageSource.getMessage(format,
                    null,
                    LocaleContextHolder.getLocale());
        } catch (Exception e) {
        }
        return formatMessage;
    }

    /**
     * Returns an String object that represents a message configured and
     * formatted with de args informed.
     *
     * @param    format  key to find in resource file
     * @param    args  arguments to put on message body
     * @return      return the message value
     * @see         String
     */
    public static String format(final String format, final Object... args) {
        return String.format(format(format), args);
    }
}
