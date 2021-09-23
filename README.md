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

###LazyColumn 구성시 content: LazyListScope 구현 범위
LazyColumn 으로 리스트를 구현할때 content 로 리스트 아이템을 구현하는데 LazyListScope 라는것이 있어서 어떤것을 할수 있는지 살펴 보았다.

```kotlin
// LazyDsl.kt
@Composable
fun LazyColumn(
    ...
    content: LazyListScope.() -> Unit
)
```

```kotlin
interface LazyListScope {
    fun item(key: Any? = null, content: @Composable LazyItemScope.() -> Unit)

    fun items(
        count: Int,
        key: ((index: Int) -> Any)? = null,
        itemContent: @Composable LazyItemScope.(index: Int) -> Unit
    )

    fun stickyHeader(key: Any? = null, content: @Composable LazyItemScope.() -> Unit)
}
```
- item: 리스트 아이템 하나를 그리는데 사용
- items: 리스트 여러개를 그리는데 사용
- stickyHeader: 고정된 아이템을 그리는데 사용
**위 함수복합적으로 사용 가능**

**속성 설명**
key
- 항목을 나타내는 고유한 키
- 여러 항목에 대해 동일한 키를 허용하지 않는다.
- 키는 번들을 통해 저장할수 있어야 한다.
- 키를 지정하면 스크롤 위치가 키를 기반으로 유지된다.

```kotlin
LazyColumn {
    stickyHeader {
        Session(
            modifier = Modifier.background(Color.White),
            onSessionClick = onSessionClick
        )
        Divider(
            modifier = Modifier.padding(horizontal = 24.dp),
            color = "#EFEFEF".toColor()
        )
    }

    item(key = 1) {
        Session(onSessionClick = onSessionClick)
        Divider(
            modifier = Modifier.padding(horizontal = 24.dp),
            color = "#EFEFEF".toColor()
        )
    }

    items(count = 20) {
        Session(onSessionClick = onSessionClick)
        Divider(
            modifier = Modifier.padding(horizontal = 24.dp),
            color = "#EFEFEF".toColor()
        )
    } 
}
```

### ConcatAdapter
여러 어댑터의 콘텐츠를 순서대로 표시하는 {@link Adapter} 구현

```java
    /**
     * Creates a ConcatAdapter with {@link Config#DEFAULT} and the given adapters in the given
     * order.
     *
     * @param adapters The list of adapters to add
     */
    @SafeVarargs
    public ConcatAdapter(@NonNull Adapter<? extends ViewHolder>... adapters) {
        this(Config.DEFAULT, adapters);
    }
```
- 기본은 Config#DEFAULT 이며 어댑터에 주어진 순서에따라 ConcatAdapter 를 생성 

```java
    /**
     * Creates a ConcatAdapter with the given config and the given adapters in the given order.
     *
     * @param config   The configuration for this ConcatAdapter
     * @param adapters The list of adapters to add
     * @see Config.Builder
     */
    @SafeVarargs
    public ConcatAdapter(
            @NonNull Config config,
            @NonNull Adapter<? extends ViewHolder>... adapters) {
        this(config, Arrays.asList(adapters));
    }
```
- 주어진 Config, Adapter, 순서에 따라서 ConcatAdapter 를 생성

**ConcatAdapter Config**

```java
public final boolean isolateViewTypes;
```
- false인 경우 ConcatAdapter는 할당된 모든 어댑터가 동일한 ViewType 을 사용하여 동일한 RecyclerView.ViewHolders를 참조하도록 전역 ViewType 풀을 공유한다고 가정합니다.

```java
public final StableIdMode stableIdMode;

public enum StableIdMode {
    NO_STABLE_IDS,
    ISOLATED_STABLE_IDS,
    SHARED_STABLE_IDS   
}
```
- {@link ConcatAdapter}가 Stable ID를 지원해야 하는지 여부를 정의합니다({@link Adapter#hasStableIds()}.


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
[kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)
[kotlinx.serialization 1.2 출시](https://blog.jetbrains.com/ko/kotlin/2021/05/kotlinx-serialization-1-2-released/)