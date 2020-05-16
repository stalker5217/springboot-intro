package com.springboot.service.posts;

import com.springboot.domain.posts.Posts;
import com.springboot.domain.posts.PostsRepository;
import com.springboot.web.dto.PostsResponseDto;
import com.springboot.web.dto.PostsSaveRequestDto;
import com.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * update에서 실제 repository로 update를 하는 구문이 없다.
     * JPA에 영속성 컨텍스트라는 개념이 있다.
     * Transaction 안에서, 가져온 데이터는 영속성이 유지되며
     * 이 Entity의 값을 바꾸기만 해도 Trnasaction 종료 시 값이 자동으로 싱크된다.
     * 이를 'Dirty Checking'이라고도 한다.
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
