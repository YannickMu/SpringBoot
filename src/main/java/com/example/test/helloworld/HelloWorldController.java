package com.example.test.helloworld;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    @GetMapping
    @Operation(summary = "Returns \"Hello World!\" if random random int between 1 and 100 is under 51 or conflict if its above.")
    @ApiResponses(value = {
            @ApiResponse(description = "get Hello World!", responseCode = "200", content = {@Content(examples = @ExampleObject(value = "Hello World!"), schema = @Schema(implementation = String.class))}),
            @ApiResponse(description = "get Conflict", responseCode = "409", content = @Content(examples = @ExampleObject(value = "Something went wrong!"), schema = @Schema(implementation = String.class))),
    })
    public ResponseEntity<?> helloWorld() {
        Random random = new Random();
        if (random.nextInt(1, 100) <= 50) {
            return ResponseEntity.status(200).body("Hello World!");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Something went wrong!");
        }
    }
}
