# Jetpack Compose

## 텍스트 컴포저블로 간단한 앱 빌드

### Jetpack Compose란 무엇인가요?
- Android UI를 빌드하기 위해 사용하는 최신 툴킷
- 적은 양의 코드
- 직관적인 Kotlin 기능 : UI 개발을 간소화 및 가속

#### Composable
- UI 일부를 설명
- 반환 값 
- 입력을 통해 화면에 표시되는 내용 생성
- 여러 UI 요소를 내보낼 수 있음

#### Annotation
- 코드에 추가 정보를 첨부하는 방법
- 매개변수를 넣을 수 있음

#### Composable의 예시
- 모든 Composable function에는 **@Composable**이 존재해야 한다.
    - Annotation은 데이터를 UI로 변환한다고 Compose Compiler에게 알림
    - Compiler는 기계어로 변환하는 특수한 프로그램(자바의 경우 바이트코드로 변환)

#### Composable func 네이밍
- 명사여야 한다 : DoneButton()
- 동사면 안된다 : DrawTextField() 
- 전치사가 명사화된 것은 안된다 : TextFieldWithLink()
- 형용사도 안된다 : Bright()
- 부사도 안된다 : Outside()
- 명사 앞에 형용사를 붙이는 것은 가능하다 : RoundIcon()

### 글꼴 크기 변경 
- SP (Scale-Independent Pixels) : 시스템 사이즈의 따라 변경
- DP (Density-Independent Pixels) : 화면의 크기가 달라도 동일한 비율

### 행과 열에 텍스트 요소 정렬

#### Compose의 3가지 표준 레이아웃 요소
- Column
- Row
- Box

--- 

## Android 앱에 이미지 추가

### 이미지 컴포저블 추가
- painterResource() : drawable file의 이미지를 가져옴

### Box layout 추가

#### Box
- 요소들을 서로 위에 쌓을 수 있음
- 정렬 가능

### 이미지 Composable의 위치 지정 및 크기 조정

#### Modifier
- Composable이 매개변수로 허용해야 사용가능
- 배경 지정
- padding 지정
- 동작 추가
- fillMaxHeight, fillMaxWidth : 높이, 너비 채우기

#### ContentScale
- ContentScale을 이용하여 이미지의 비율 조정 가능
- ContentScale.Crop

### 텍스트 정렬 및 패딩 추가
- fillMaxWidth : 너비를 끝까지 채울 수 있는 공간을 만듬
- wrapContentWidth : 채울 수 있는 공간 내에서 자신의 너비만큼 채움
    - 정렬 가능
    - 매개 변수에 Alignment.Start, Alignment.Top, Alignment.End, Alignment.Bottom을 넣어 정렬 가능
- padding은 Modifier를 통해 사용이 가능

### 적절한 코드 사례 채택

#### 번역
- 하드코딩된 String은 번역이 어렵다. 따라서, String Resource로 구분해준다.

---

## 연습 Compose 기본 사항
