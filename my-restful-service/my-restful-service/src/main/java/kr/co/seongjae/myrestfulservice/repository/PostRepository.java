package kr.co.seongjae.myrestfulservice.repository;

import kr.co.seongjae.myrestfulservice.bean.Post;
import kr.co.seongjae.myrestfulservice.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
