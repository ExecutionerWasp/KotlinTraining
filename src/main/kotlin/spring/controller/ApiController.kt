package spring.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ApiController {

    private val log = LoggerFactory.getLogger(ApiController::class.java)
    private val objects = HashMap<String, HashMap<String, String>>()

    init {
        objects["first"] = HashMap()
        objects["second"] = HashMap()
        objects["third"] = HashMap()
        log.info("Objects initialized")
    }

    @GetMapping("/")
    fun greeting():ResponseEntity<Map<String, HashMap<String, String>>> {
        return ResponseEntity.ok(objects)
    }

    @PostMapping("/{key}")
    fun greetingPost(@PathVariable key:String, @RequestBody obj:HashMap<String, String>):ResponseEntity<HashMap<String, String>> {
        objects[key] = obj
        return ResponseEntity.ok(obj)
    }

    @PutMapping("/{key}")
    fun greetingPut(@PathVariable key:String, @RequestBody obj:HashMap<String, String>): ResponseEntity<HashMap<String, String>> {
        if (objects.containsKey(key)) {
            objects[key] = obj
            return ResponseEntity.ok(obj)
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{key}")
    fun delete(@PathVariable key:String):ResponseEntity<Any> {
        if(objects.containsKey(key)) {
            objects.remove(key)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}
