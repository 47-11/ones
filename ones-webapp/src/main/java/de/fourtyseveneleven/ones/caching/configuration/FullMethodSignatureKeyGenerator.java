package de.fourtyseveneleven.ones.caching.configuration;

import static java.lang.String.format;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

class FullMethodSignatureKeyGenerator implements KeyGenerator {

    @Override
    @NonNull
    public Object generate(@NonNull Object target, @NonNull Method method,
                           @NonNull Object... params) {

        // Target can safely be ignored: Class is compared in method, and we
        // don't need to compare the exact instance, since services are
        // singletons
        return new FullMethodSignatureKey(method, params);
    }

    private static class FullMethodSignatureKey {

        private final Method method;
        private final Object[] params;

        private final int hashCode;

        FullMethodSignatureKey(Method method, Object[] params) {
            this.method = method;
            this.params = params;
            this.hashCode = Objects.hash(method, Arrays.deepHashCode(params));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            FullMethodSignatureKey that = (FullMethodSignatureKey) o;
            return hashCode == that.hashCode && method.equals(that.method)
                    && Arrays.deepEquals(params, that.params);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public String toString() {

            return format("FullMethodSignatureKey{ %s.%s(%s) }",
                    method.getDeclaringClass().getSimpleName(), method.getName(),
                    StringUtils.arrayToCommaDelimitedString(params));
        }
    }

}
