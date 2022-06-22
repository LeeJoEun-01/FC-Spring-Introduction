package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 어노테이션으로 repository 명시
public interface TodoRepository extends JpaRepository<TodoEntity, Long> { // 제네릭으로 타입 설정: TodoEntity와 Long(id)으로

}
