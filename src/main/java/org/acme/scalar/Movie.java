package org.acme.scalar;

import io.smallrye.graphql.api.Scalar;
import io.smallrye.graphql.api.ToScalar;

public class Movie {

    @ToScalar(Scalar.Int.class)
    Long idLongThatSchouldChangeToInt;

}
