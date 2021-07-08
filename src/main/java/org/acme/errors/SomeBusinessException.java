package org.acme.errors;

import io.smallrye.graphql.api.ErrorCode;

@ErrorCode("some-business-error-code")
public class SomeBusinessException extends RuntimeException {

}
