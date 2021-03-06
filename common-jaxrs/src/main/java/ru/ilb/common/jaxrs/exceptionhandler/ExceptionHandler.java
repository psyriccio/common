/*
 * Copyright 2016 Bystrobank
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
package ru.ilb.common.jaxrs.exceptionhandler;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

/**
 *
 * @author slavb
 */
public class ExceptionHandler extends AbstractExceptionHandler<Exception>{
    private static final Logger LOG = Logger.getLogger(ExceptionHandler.class.getName());

    @Override
    public Response toResponse(Exception ex) {
        int responseStatus = defaultResponseStatus;
        String outMess = ex.getMessage();
        if (outMess == null) {
            outMess = "";
        }
        LOG.log(Level.SEVERE, outMess, ex);

        return Response.status(responseStatus).entity(outMess).type(contentType).build();

    }

}
