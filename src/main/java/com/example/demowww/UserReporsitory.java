package com.example.demowww;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReporsitory extends CrudRepository<User,Long> {
}
