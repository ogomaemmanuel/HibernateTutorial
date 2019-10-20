package com.ogoma.authserver.repositories;

import com.ogoma.authserver.enitities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Nullable
    public User findByEmail(String email);
}
