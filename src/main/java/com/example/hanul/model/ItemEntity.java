package com.example.hanul.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "Item")
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(name = "item_id")
    private String id;

    @Column(nullable = true)
    private String itemNm;

    @Column(nullable = true, length = 500) // 길이를 500으로 변경
    private String itemDetail;

    @Column(nullable = true)
    private String posterUrl; // 영화 포스터 이미지 URL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
