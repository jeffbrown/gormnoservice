package gormnoservice

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.HttpStatus


@Controller("/my")
class MyController {

    @Post('/{name}')
    Person create(String name) {
        Person p
        Person.withNewSession {
           p = new Person(name:name).save()
        }
        p
    }

    @Get('/')
    Map list() {
        List people
        Person.withNewSession {
            people = Person.list()
        }
        [people: people]
    }
}
