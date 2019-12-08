package com.ddastudio.mrmr.profile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/11/27
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Optional<Profile> findByIdAndAccount_Id(int id, int accountId);
}
