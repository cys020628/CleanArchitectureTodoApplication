# ✅ Clean Architecture 기반 Todo 앱

## 🚀 주요 기술 스택

- Hilt: DI(Dependency Injection)로 의존성 관리
- Coroutine: 비동기 작업 처리
- Clean Architecture: 유지보수와 확장성을 고려한 설계
- MVVM: Presentation 계층의 데이터 및 상태 관리
- Jetpack Compose: UI를 선언적으로 작성
- Room: SQLite 데이터베이스 관리

## 🗂️ 프로젝트 구조

```md
📂 root
├── app
│   ├── TodoApplication.kt        # Hilt 초기화
│
├── data                          # 데이터 계층 (Local DataSource, Entity)
│                                 
│   ├── TodoDao.kt                # 데이터베이스 액세스 객체
│   ├── TodoDatabase.kt           # Room 데이터베이스 설정
│   ├── TodoEntity.kt             # Todo 데이터 모델(Entity)
│   ├── TodoModule.kt             # Hilt 모듈 (Repository 주입)
│   ├── TodoRepository.kt         # 데이터 소스와의 인터페이스 구현
│
├── domain                        # 비즈니스 로직 계층
│                                 
│   ├── TodoUseCase.kt            # 할 일 관련 UseCase (비즈니스 규칙 관리)
│
├── presentation      
│                                 # UI 및 ViewModel 계층
│   ├── TodoListScreen.kt         # Compose 기반 UI 화면
│   ├── TodoViewModel.kt          # 상태 관리 및 이벤트 처리
│   ├── MainActivity.kt           # 앱의 진입점

```

## 🛠️ 프로젝트 흐름

- graph TD;
- A[UI (Jetpack Compose)] -->|User Interaction| B[ViewModel (MVVM)]
-  B -->|비즈니스 로직 호출| C[UseCase (Domain)]
-  C -->|데이터 요청| D[Repository (Data)]
-  D -->|로컬 데이터 소스 접근| E[Room Database]

## 🔑 주요 파일 설명

### data 계층
- TodoDao.kt: 데이터베이스 CRUD 작업을 정의
- TodoDatabase.kt: Room 데이터베이스 설정 및 초기화
- TodoEntity.kt: 데이터베이스 Entity 정의
- TodoModule.kt: Repository에 의존성을 주입하는 Hilt 모듈
- TodoRepository.kt: 데이터 소스(Room DB)와 도메인 계층 간의 연결

### domain 계층
- TodoUseCase.kt: 비즈니스 로직 처리 (e.g., 데이터 필터링, 검증)

### presentation 계층
- TodoListScreen.kt: Jetpack Compose로 작성된 UI
- TodoViewModel.kt: UI 상태 관리 및 비즈니스 로직 호출

## 🎯 주요 기능
- 할 일 추가
- 할 일 수정 -> 후에 추가 예정
- 할 일 삭제
- 데이터의 상태 기반 UI 업데이트



