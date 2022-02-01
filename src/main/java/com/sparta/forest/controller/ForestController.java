package com.sparta.forest.controller;

import com.sparta.forest.dto.ForestRequestDto;
import com.sparta.forest.model.Forest;
import com.sparta.forest.repository.ForestRepository;
import com.sparta.forest.service.ForestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ForestController {
    private final ForestRepository forestRepository;
    private final ForestService forestService;

//    @Autowired
//    public ForestController(ForestService forestService) {
//        this.forestRepository = forestService;
//    }

    @GetMapping("/api/forests")
    public List<Forest> readForest() {
        return forestRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/forests")
    public Forest createForest(@RequestBody ForestRequestDto requestDto) {
        Forest forest = new Forest(requestDto);
        System.out.println(requestDto);
        return forestRepository.save(forest);
    }

    @DeleteMapping("/api/forests/{id}")
    public Long deleteForest(@PathVariable Long id) {
        forestRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/forests/{id}")
        public Long updateForest(@PathVariable Long id, @RequestBody ForestRequestDto requestDto) {
            forestService.update(id, requestDto);
            return id;
        }

}
