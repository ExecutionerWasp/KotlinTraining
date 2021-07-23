package spring.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import spring.domain.Entities

class Repositories {
    @Repository
    interface ArticleRepository : CrudRepository<Entities.Article, Long> {
        fun findAllByOrderByAddedAtDesc(): Iterable<Entities.Article>
    }

    @Repository
    interface UserRepository : CrudRepository<Entities.User, Long> {
        fun findByLogin(login: String): Entities.User?
    }
}
