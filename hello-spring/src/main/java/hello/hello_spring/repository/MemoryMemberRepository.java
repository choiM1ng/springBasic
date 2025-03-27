package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   //member를 저장할때 sequence값을 하나 올려주고, 그 sequence를 id로 set
        store.put(member.getId(), member);  //store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //null이 반환될 가능성이 있으면 Optional로 감싼다
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))    //member.getName이 파라미터로 넘어온 name과 같은지 확인
                .findAny(); //루프를 돌면서 하나가 찾아지면 그것을 바로 반환, 끝까지 돌렸는데 없으면 옵셔널에 the all이 포함돼서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
