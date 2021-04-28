package de.fourtyseveneleven.ones.util;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static de.fourtyseveneleven.ones.message.MessageUtils.getLocale;
import static java.util.Locale.ENGLISH;
import static java.util.Locale.GERMAN;
import static java.util.Locale.GERMANY;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;

class MessageUtilsTest {

	@Test
	void testLocaleFromLocaleContextHolderIsUsed() {

		LocaleContextHolder.setLocale(ENGLISH);
		assertThat(getLocale()).isEqualTo(ENGLISH);

		LocaleContextHolder.setLocale(GERMAN);
		assertThat(getLocale()).isEqualTo(GERMAN);
	}

	@Test
	void testDefaultLocaleIsUsedWhenLocaleContextIsNull() {

		LocaleContextHolder.resetLocaleContext();

		assertThat(getLocale()).isEqualTo(ENGLISH);
	}

	@Test
	void testDefaultLocaleIsUsedWhenLocaleContextHasNoLocale() {

		LocaleContextHolder.resetLocaleContext();
		LocaleContextHolder.setLocaleContext(() -> null);

		assertThat(getLocale()).isEqualTo(ENGLISH);
	}

	@Test
	void testRegionIsIgnored() {

		LocaleContextHolder.setLocale(GERMANY);

		assertThat(GERMANY).isNotEqualTo(GERMAN);
		assertThat(getLocale()).isEqualTo(GERMAN);
	}

	@Test
	void testGetExceptionMessagesUsesLocale() {

		LocaleContextHolder.setLocale(GERMAN);
		assertThat(getExceptionMessage("test.foo")).isEqualTo("foo german");

		LocaleContextHolder.setLocale(ENGLISH);
		assertThat(getExceptionMessage("test.foo")).isEqualTo("foo english");
	}

	@Test
	void testGetExceptionMessagesHonorsArgumentOrder() {

		LocaleContextHolder.setLocale(GERMAN);
		assertThat(getExceptionMessage("test.bar", "zero", "one"))
		    .isEqualTo("bar one / zero german");

		LocaleContextHolder.setLocale(ENGLISH);
		assertThat(getExceptionMessage("test.bar", "zero", "one"))
		    .isEqualTo("bar zero / one english");
	}

	@Test
	void testGetExceptionMessagesFallsBackToDefaultLocale() {

		LocaleContextHolder.setLocale(GERMAN);
		assertThat(getExceptionMessage("test.baz")).isEqualTo("baz english");

		LocaleContextHolder.setLocale(ENGLISH);
		assertThat(getExceptionMessage("test.baz")).isEqualTo("baz english");
	}

	@Test
	void testGetExceptionMessagesUsesKeyAsFallback() {

		assertThat(getExceptionMessage("test.unknown-message"))
		    .isEqualTo("test.unknown-message");
	}
}
