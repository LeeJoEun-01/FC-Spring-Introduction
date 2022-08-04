package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("-------------");

		// Text JSON -> Object
		// Object -> Text JSON

		// controller req json(text) -> object
		// response object -> json(text)

		var objectMapper = new ObjectMapper();

		// object -> text
		// object mapper get Method 를 활용한다. (=User가 getter를 꼭 가지고 있어야 함)
		var user = new User("joeun",10, "010-1234-1234");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

		// text -> object
		//  object mapper는 defult 생성자가 필요하다.
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
