package com.example;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.Optional;

public class Healthcheck {

        @FunctionName("health-check")
        public HttpResponseMessage run(
                        @HttpTrigger(name = "req", 
                        methods = { HttpMethod.GET,HttpMethod.POST }, 
                        authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
                        final ExecutionContext context) {

                context.getLogger().info("Java HTTP trigger processed a request.");
                String message = "I am healthy and running as azure function ";
                return request.createResponseBuilder(HttpStatus.OK).body(message).build();
        }
}
