# Step 2: Early Return (else 제거와 depth 줄이기)

이 코드는 **기능적으로 완벽하게 동작하며 모든 테스트를 통과**합니다.
하지만 입력값을 검증하고 로직을 수행하는 과정에서 `if-else`가 중첩되어 있어 코드의 depth(들여쓰기 깊이)가 3~4단계에 달합니다. 

## 🎯 학습 목표
- 조건문을 만났을 때 로직을 끝까지 읽지 않아도 되게 만드는 `Early Return` 패턴을 연습합니다.
- `else` 예약어를 코드에서 완전히 제거합니다.

## 📝 요구 사항
1. `DeepUmpire.java` 코드를 열고, 중첩된 `if-else` 구조를 평탄화하세요.
2. 모든 `else` (또는 `else if`) 를 지우고, 값이 유효하지 않은 경우 **빠르게 `return` 하거나 `throw` 하도록**(Early Return) 수정하세요.
3. 결과적으로 메서드 내부의 최대 들여쓰기(depth)를 1단계로 유지해보세요.
4. 리팩토링 중간중간 테스트(`DeepUmpireTest.java`)를 실행하여 동작이 깨지지 않았는지 확인하세요!

## ⌨️ IntelliJ 리팩토링 단축키

| 기능 | Windows/Linux | macOS |
|------|--------------|-------|
| **인라인 변수** (Inline Variable) | `Ctrl + Alt + N` | `⌘ + ⌥ + N` |
| **코드 감싸기** (Surround With) | `Ctrl + Alt + T` | `⌘ + ⌥ + T` |
| **조건 반전** (Invert Condition) | `Alt + Enter` → 선택 | `⌥ + Enter` → 선택 |

> 💡 `if` 문 위에서 `Alt + Enter` → "Invert 'if' condition"을 선택하면 조건을 자동으로 뒤집어줍니다!

## 📚 참고 자료
- [BE] 읽기 좋은 코드 작성법 → §3.1 Early Return, §3.2 사고의 depth 줄이기

