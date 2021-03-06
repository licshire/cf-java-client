/*
 * Copyright 2013-2018 the original author or authors.
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

package org.cloudfoundry.uaa.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.cloudfoundry.Nullable;
import org.cloudfoundry.QueryParameter;
import org.cloudfoundry.uaa.IdentityZoned;
import org.immutables.value.Value;

import java.util.List;

/**
 * The request payload for the change user password operation
 */
@JsonSerialize
@Value.Immutable
abstract class _InviteUsersRequest implements IdentityZoned {

    @Value.Check
    void check() {
        if (getEmails().isEmpty()) {
            throw new IllegalStateException("Cannot build InviteUsersRequest, at least one email must be provided");
        }
    }

    /**
     * The client registration information
     */
    @Nullable
    @QueryParameter("client_id")
    abstract String getClientId();

    /**
     * The emails to invite
     */
    @JsonProperty("emails")
    abstract List<String> getEmails();

    /**
     * The redirect URI
     */
    @QueryParameter("redirect_uri")
    abstract String getRedirectUri();

}
