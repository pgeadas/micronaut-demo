package org.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/demo")
class DemoController {

    @Get(uri = "/", produces = "text/plain")
    String index() {
        "Example Response"
    }
}
