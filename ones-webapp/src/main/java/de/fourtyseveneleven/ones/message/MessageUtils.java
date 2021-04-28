package de.fourtyseveneleven.ones.message;

import static de.fourtyseveneleven.ones.message.configuration.ExceptionMessageConfiguration.DEFAULT_LOCALE;
import static java.util.Objects.isNull;

import java.util.Locale;

import de.fourtyseveneleven.ones.message.configuration.ExceptionMessageConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;

public final class MessageUtils {

	private static final Logger LOG =
	        LoggerFactory.getLogger(MessageUtils.class);

	private static final MessageSource EXCEPTION_MESSAGE_SOURCE = ExceptionMessageConfiguration.exceptionMessageSource();

	private MessageUtils() {
	}

	public static String getExceptionMessage(String key,
	        Object... arguments) {

		try {
			return EXCEPTION_MESSAGE_SOURCE.getMessage(key, arguments,
			    getLocale());
		} catch (NoSuchMessageException e) {
			LOG.warn("Missing message for key {} and locale {}", key,
			    getLocale());
			return key;
		}
	}

	public static Locale getLocale() {

		final LocaleContext localeContext =
		        LocaleContextHolder.getLocaleContext();
		if (isNull(localeContext)) {
			return DEFAULT_LOCALE;
		}

		final Locale locale = localeContext.getLocale();
		if (isNull(locale)) {
			return DEFAULT_LOCALE;
		}

		// We only want the language-specific locale without the region (e.g.
		// "de" instead of "de-DE"
		return Locale.forLanguageTag(locale.getLanguage());
	}
}
