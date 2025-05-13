package org.js.springbootdeveloper.domain;


import com.nimbusds.openid.connect.sdk.assurance.evidences.Name;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity // 엔티티로 지정
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // 'title'이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    // 글에 글쓴이 추가
    @Column(name = "author", nullable = false)
    private String author;

    @Builder // 빌더 패턴으로 객체 생성
    public  Article(String author, String title, String content) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //수정 메서드
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    //생성, 수정시간 추가
    @CreatedDate // 엔티티가 생성될 때 생성 시간 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate // 엔티티가 수정될 때 수정 시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
