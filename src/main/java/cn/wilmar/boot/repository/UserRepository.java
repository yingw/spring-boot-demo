package cn.wilmar.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.wilmar.boot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByNameLike(String id);
}