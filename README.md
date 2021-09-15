# CleanArchitectureMVVM-2021
드로이드나이츠를 보고 기능별로 모듈을 작은 단위로 나누어 작업해보는 새로운 스타일을 스터디하고자 만들었습니다.

## 어떤것을 할것인가?
- Kotlin DSL
- 기능별로 모듈 작게 나누기
- Compose 적용
- Coroutine 적용

## Development Info

### 현재 Android Studio Version 정보
- Android Studio Bumblebee | 2021.1.1 Canary 11
- Build #AI-211.7628.21.2111.7676841, built on August 27, 2021
- Runtime version: 11.0.11+0-b60-7590822 x86_64
- Kotlin Version : 1.5.21

## 참고

### [Dagger Hilt](https://dagger.dev/hilt/)
Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.

**The goals of Hilt are:**
- To simplify Dagger-related infrastructure for Android apps.
- To create a standard set of components and scopes to ease setup, readability/understanding, and code sharing between apps.
- To provide an easy way to provision different bindings to various build types (e.g. testing, debug, or release).

**Why use Hilt?**
- Reduced boilerplate
- Decoupled build dependencies
- Simplified configuration
- Improved testing
- Standardized components

### 문제 기록

**Compose 적용이 안되는 문제 발생**
`java.lang.IllegalStateException: Backend Internal error: Exception during code generation`
- Composble 로 선언한 코드를 생성하지 못하는 상태
- Kotlin Version 을 1.5.30 으로 지정 / Compose Version 1.0.1 로 지정

**해결**
- ComposeUI 릴리즈 노트를 보고 Kotlin 버전 1.5.21 로 변경

```
버전 1.0.1
2021년 8월 4일
androidx.compose.ui:ui-*:1.0.1이 출시되었습니다. 버전 1.0.1에 포함된 커밋을 확인하세요.
종속 항목 업데이트
Kotlin 1.5.21에 종속되도록 업데이트했습니다.
```

**컴포즈 사용하는 곳에 아티팩트 종속 항목 추가**
```groovy
kotlinOptions {
    jvmTarget = '1.8'
    useIR = true
}
buildFeatures {
    compose true
}
composeOptions {
    kotlinCompilerExtensionVersion Dep.Compose.version
    kotlinCompilerVersion Dep.Kotlin.version
}
```

### 링크
[드로이드나이츠](https://github.com/droidknights/DroidKnights2021_App)
[ComposeUI 릴리즈노트](https://developer.android.com/jetpack/androidx/releases/compose-ui?hl=ko)