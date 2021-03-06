/*
 * Copyright 2016-2017 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openo.sdnhub.osdriverservice.rest.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.openo.sdnhub.osdriverservice.openstack.client.exception.OpenStackException;

/**
 * OpenStackException response provider.<br>
 *
 * @author
 * @version SDNHUB 0.5 August 10, 2016
 */
@Provider
public class OpenStackExceptionMapper implements ExceptionMapper<OpenStackException> {

    @Override
    public Response toResponse(OpenStackException exception) {
        ExceptionMessage message = new ExceptionMessage();
        message.setErrorCode(String.valueOf(exception.getErrorCode()));
        message.setHttpCode(exception.getHttpCode());
        message.setMessage(exception.getMessage());
        return Response.status(message.getHttpCode()).
                type(MediaType.APPLICATION_JSON).entity(message).build();
    }
}
