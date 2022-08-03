# Spring Boot 프로젝트 생성
- [spring initializr](https://start.spring.io/)
![image](https://user-images.githubusercontent.com/78733700/182294531-3addbc3e-7a17-4ecb-b9fe-2c37dd50d43b.png)

# IntelliJ에서 한글 파일 깨질 때
### 1. Error: nmappable character for encoding x-windows-949 경우
  - Settings(ctrl + alt + s) -> File Encodings
  - Encoding 방법을 다 UTF-8로 변경!!
![image](https://user-images.githubusercontent.com/78733700/177230088-399477de-ce2c-404a-bca8-aba94f82b9a8.png)

### 2. 콘솔에서 한글 깨지는 경우
  - [Help] -> [Edit Custom VM Options...]
  - 맨 아래 밑의 코드 두 줄 추가
  ```
  -Dfile.encoding=UTF-8
  -Dconsole.encoding=UTF-8
  ```
  ![image](https://user-images.githubusercontent.com/78733700/177230253-f82f4e44-ec85-4932-b3c8-8beeb9883a91.png)

  - 인텔리제이 재시작
    + 재시작을 해도 안된다면?
    + `build`파일 삭제 후 다시 run
<!-- 참고링크: https://beemiel.tistory.com/4 -->
