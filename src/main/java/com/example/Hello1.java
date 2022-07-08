package com.example;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.Optional;

public class Hello1 {

        @FunctionName("hello1")
        public HttpResponseMessage run(
                        @HttpTrigger(name = "req", 
                        methods = HttpMethod.GET, 
                        authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
                        final ExecutionContext context) {

                context.getLogger().info("Java HTTP trigger processed a request.");
                
                String message = null;

                String query = request.getQueryParameters().get("message");                
                message = request.getBody().orElse(query);
                context.getLogger().info(message);         
                if(null == message)
                     message = "World";                
                return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + message +"!").build();
        }
}