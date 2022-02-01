package com.sparta.forest.service;

import com.sparta.forest.dto.ForestRequestDto;
import com.sparta.forest.model.Forest;
import com.sparta.forest.repository.ForestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ForestService {
    private final ForestRepository forestRepository;

    @Transactional
    public Long update(Long id, ForestRequestDto requestDto) {
        Forest forest = forestRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        forest.update(requestDto);
        return forest.getId();
    }

}
