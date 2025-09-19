# 3rd-teamproject
3번째 팀 프로젝트 헬스장 홈페이지 만들


# 짐 케어 헬스&PT 프로젝트 분석

## 📋 프로젝트 개요

- **프로젝트명**: 짐 케어 헬스&PT 일산 탄현점
- **기술 스택**: Spring Boot, Thymeleaf, MyBatis, Bootstrap
- **아키텍처**: MVC 패턴, 3-Tier Architecture
- **주요 기능**: 회원 관리, PT 예약, 게시판, 운동기구 관리

## 🏗️ 시스템 아키텍처

### 1. 계층 구조 (3-Tier Architecture)

```
📁 Presentation Layer (View)
├── templates/ (Thymeleaf HTML)
├── CSS/JavaScript (프론트엔드)
└── Controller (Spring MVC)

📁 Business Layer (Service)
├── Controller Classes
├── Interceptors (인증/권한)
└── Business Logic

📁 Data Layer (Model)
├── DAO (Data Access Object)
├── VO (Value Object)
└── MyBatis Mappers

```

### 2. 패키지 구조

```
lx.gymproject.springboot/
├── controller/          # 컨트롤러
├── dao/                # 데이터 접근 객체
├── vo/                 # 값 객체
├── interceptor/        # 인터셉터
└── configuration/      # 설정 클래스

```

## 🎯 주요 기능별 설계

### 1. 회원 관리 시스템 👥

**관련 파일:**

- `UserController.java` - 회원 관련 요청 처리
- `GymUserDAO.java` - 회원 데이터베이스 접근
- `GymUserVO.java` - 회원 정보 객체

**구현 기능:**

- 회원가입/로그인/로그아웃
- 마이페이지 (정보 수정)
- 세션 기반 인증 시스템

**핵심 코드:**

```java
@PostMapping("/login.do")
public String login(Model model, HttpSession session,
        @RequestParam String userEmail,
        @RequestParam String userPassword) {

    GymUserVO vo = dao.doLoginByUserId(userEmail);

    if(vo == null || !vo.getUserPassword().equals(userPassword)) {
        model.addAttribute("loginFailed", true);
        return "loginPage";
    }

    session.setAttribute("loginUser", vo);
    return "home";
}

```

### 2. PT 예약 시스템 📅

**관련 파일:**

- `GymAppointmentVO.java` - 예약 정보 객체
- `GymAppointmentDAO.java` - 예약 데이터 접근
- `UserController.java` - 예약 관련 기능

**구현 기능:**

- PT 예약 신청
- 예약 현황 대시보드
- 예약 상태 관리

**데이터 모델:**

```java
public class GymAppointmentVO {
    private String appointmentId;
    private String userName;
    private String email;
    private String serviceType;
    private String appointmentDate;
    private String status1;
    // ... 기타 필드
}

```

### 3. 게시판 시스템 💬

**관련 파일:**

- `PostController.java` - 게시글 컨트롤러
- `GymPostDAO.java` - 게시글 데이터 접근
- `GymPostVO.java` - 게시글 객체

**구현 기능:**

- 게시글 CRUD (작성, 조회, 수정, 삭제)
- 작성자 권한 검증
- 게시글 목록/상세 보기

**권한 검증 로직:**

```java
@Override
public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
    HttpSession session = req.getSession();
    String authorName = req.getParameter("authorName");
    GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");

    if(!loginUser.getUserName().equals(authorName)) {
        res.sendRedirect("/postBoard.do?block=true");
        return false;
    }
    return true;
}

```

### 4. 운동기구 관리 시스템 🏋️

**관련 파일:**

- `MachineController.java` - 기구 관리 컨트롤러
- `GymMachineDAO.java` - 기구 데이터 접근
- `GymMachineVO.java` - 기구 정보 객체

**구현 기능:**

- 운동기구 목록 조회
- 기구 정보 CRUD
- 기구 설명 및 이미지/동영상 관리

## 🔒 보안 및 인증 시스템

### 1. 인터셉터 기반 인증

- `LoginCheckInterceptor`: 로그인 필수 페이지 접근 제어
- `CheckUserIdAndPostUserId`: 게시글 작성자 권한 검증

### 2. 보호되는 URL 패턴

```java
registry.addInterceptor(new LoginCheckInterceptor())
    .addPathPatterns("/mypage.do", "/reservation.do",
                    "/postWrite.do", "/postEdit.do");

```

## 🎨 프론트엔드 설계

### 1. 템플릿 구조

- **공통 템플릿**: `header.html`, `footer.html`
- **페이지별 템플릿**: 각 기능별 독립적인 HTML
- **반응형 디자인**: Bootstrap 5 + 커스텀 CSS

### 2. 사용자 경험 (UX)

- 모바일 친화적 설계
- 직관적인 네비게이션
- 실시간 위치 서비스 (카카오맵 API)

### 3. 주요 페이지

- **홈페이지**: 헬스장 소개 및 메인 기능 접근
- **로그인/회원가입**: 사용자 인증
- **마이페이지**: 개인정보 관리
- **PT 예약**: 개인 트레이닝 신청
- **게시판**: 커뮤니티 기능
- **운동기구 소개**: 기구별 상세 정보
- **위치 안내**: 카카오맵 연동

## 🗄️ 데이터베이스 설계

### 주요 엔티티

1. **사용자 (GymUser)**
    - userId, userEmail, userPassword, userName
    - userTel, userBirth, userGender
2. **예약 (GymAppointment)**
    - appointmentId, userName, serviceType
    - appointmentDate, appointmentDuration, status1
3. **게시글 (GymPost)**
    - poId, poName, poContent, poUserId
    - poTag, poImg, poLike, poView, poBoardCode
4. **운동기구 (GymMachine)**
    - machineId, machineName, machinePrice
    - machinePurchaseDate, machineServiceContact

## ⚙️ 기술적 특징

### 1. MyBatis 연동

- XML 매퍼를 통한 SQL 관리
- DAO 패턴으로 데이터 접근 추상화
- SqlSession을 통한 데이터베이스 연동

### 2. Session 기반 상태 관리

```java
session.setAttribute("loginUser", vo);
GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");

```

### 3. RESTful한 URL 설계

- `.do` 확장자를 통한 요청 매핑
- 기능별 명확한 URL 구조
- GET/POST 메서드 적절한 활용

## 🚀 프로젝트의 장점

1. **명확한 계층 분리**: MVC 패턴 충실히 구현
2. **보안 강화**: 인터셉터 기반 접근 제어
3. **사용자 친화적**: 반응형 디자인, 직관적 UI
4. **확장성**: 모듈별 독립적 설계
5. **실용성**: 실제 헬스장에서 사용 가능한 기능들

## 🔧 개선 가능한 부분

1. **보안**: 패스워드 암호화 (BCrypt 등)
2. **예외 처리**: 전역 예외 처리기 추가
3. **로깅**: 체계적인 로그 관리
4. **테스트**: 단위 테스트 및 통합 테스트
5. **API 문서화**: Swagger 등을 통한 API 문서화

## 📊 결론

이 프로젝트는 Spring Boot 기반의 실용적인 헬스장 관리 시스템으로, MVC 패턴과 3계층 아키텍처를 잘 적용한 예시입니다. 회원 관리부터 PT 예약, 게시판, 운동기구 관리까지 헬스장 운영에 필요한 핵심 기능들을 체계적으로 구현했습니다.

특히 인터셉터를 활용한 보안 처리와 세션 기반 사용자 인증, 그리고 반응형 웹 디자인 등 실무에서 요구되는 다양한 기술들을 적절히 활용한 점이 돋보입니다. 🎯

**** servive, seviceImplements / input type=”file” **accept="image/*”** 확장자 표시 해주기
