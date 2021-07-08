package org.acme.scalar;

import io.smallrye.graphql.api.Scalar;
import io.smallrye.graphql.api.ToScalar;
import org.acme.entity.Phone;

public class Person {

    @ToScalar(Scalar.String.class)
    Phone phone;
}
