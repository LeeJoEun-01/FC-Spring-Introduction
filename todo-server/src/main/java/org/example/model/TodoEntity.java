package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정
@Entity
// Entity란? DB에서 영속적으로 저장된 데이터를 자바 객체로 매핑하여 '인스턴스의 형태'로 존재하는 데이터를 말한다.
@NoArgsConstructor
// Class 기본 생성자를 자동으로 추가해준다.
@AllArgsConstructor
// Class 모든 필드 값을 파라미터로 받는 생성자를 추가한다.

public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //데이터가 없는 경우 false
    private  String title;

    @Column(name = "todoOrder", nullable = false)
//  order 키워드가 h2 database에 이미 예약어로 사용되고 있기때문에 별도의 컬럼명을 지정
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

}
