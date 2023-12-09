package dev.radom.constructmanage.api.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}
