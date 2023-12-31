package com.example.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Flux<Member> getAll() {
        return memberRepository.findAll();
    }

    public Mono<Member> getById(Long id) {
        return memberRepository.findById(id);
    }

    public Flux<Member> getByMemberName(String name) {
        return memberRepository.findByName(name);
    }

}
