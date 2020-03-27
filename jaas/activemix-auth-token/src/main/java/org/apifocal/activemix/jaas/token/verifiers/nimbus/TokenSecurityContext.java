/*
 * Copyright (c) 2017-2020 apifocal LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apifocal.activemix.jaas.token.verifiers.nimbus;

import java.util.Objects;
import java.util.Optional;

import com.nimbusds.jose.proc.SecurityContext;

/**
 * A security context which delivers a issuer context to token processing.
 */
public class TokenSecurityContext implements SecurityContext {

    private final String issuer;

    public TokenSecurityContext(String issuer) {
        this.issuer = issuer;
    }

    public Optional<String> getIssuer() {
        return Optional.ofNullable(issuer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenSecurityContext)) return false;
        TokenSecurityContext that = (TokenSecurityContext) o;
        return Objects.equals(getIssuer(), that.getIssuer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIssuer());
    }

    @Override
    public String toString() {
        return "TokenSecurityContext(" + issuer + ")";
    }
}
