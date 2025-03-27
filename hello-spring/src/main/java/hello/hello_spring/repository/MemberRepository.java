package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 저장 및 저장된 회원 반환
    Optional<Member> findById(Long id); //id로 회원 찾기
    Optional<Member> findByName(String name);   //name으로 회원 찾기
    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트 반환
}
