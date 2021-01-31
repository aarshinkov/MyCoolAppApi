package com.aarshinkov.rest.mycoolapp.repositories;

import com.aarshinkov.rest.mycoolapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(Long userId);
    
    UserEntity findByUsername(String username);
}
