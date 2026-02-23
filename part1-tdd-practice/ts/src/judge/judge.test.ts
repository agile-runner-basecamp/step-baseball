// Step 1 & 2: 스트라이크 / 볼 판정
import { judge } from './judge';

describe('judge - 스트라이크 판정', () => {
  test('완전히 일치하면 3스트라이크 0볼', () => {
    expect(judge([1, 2, 3], [1, 2, 3])).toEqual({ strikes: 3, balls: 0 });
  });

  test('첫 번째 자리만 같으면 1스트라이크 0볼', () => {
    expect(judge([1, 2, 3], [1, 5, 6])).toEqual({ strikes: 1, balls: 0 });
  });

  test('아무것도 안 맞으면 0스트라이크 0볼', () => {
    expect(judge([1, 2, 3], [4, 5, 6])).toEqual({ strikes: 0, balls: 0 });
  });

  test('두 번째, 세 번째 자리 일치하면 2스트라이크 0볼', () => {
    expect(judge([1, 2, 3], [9, 2, 3])).toEqual({ strikes: 2, balls: 0 });
  });
});

describe('judge - 볼 판정', () => {
  test('숫자는 있지만 자리가 다르면 볼', () => {
    // answer: 1,2,3 / guess: 3,1,2 → 모두 볼
    expect(judge([1, 2, 3], [3, 1, 2])).toEqual({ strikes: 0, balls: 3 });
  });

  test('1스트라이크 1볼', () => {
    // answer: 1,2,3 / guess: 1,3,9 → 1번 자리 스트라이크, 3이 볼
    expect(judge([1, 2, 3], [1, 3, 9])).toEqual({ strikes: 1, balls: 1 });
  });

  test('1스트라이크 2볼', () => {
    // answer: 1,2,3 / guess: 1,3,2 → 1번 스트라이크, 2와 3이 볼
    expect(judge([1, 2, 3], [1, 3, 2])).toEqual({ strikes: 1, balls: 2 });
  });

  test('경계값: 3스트라이크는 0볼이어야 한다 (볼로 중복 카운트 금지)', () => {
    expect(judge([1, 2, 3], [1, 2, 3])).toEqual({ strikes: 3, balls: 0 });
  });

  test('경계값: 0스트라이크 0볼 (낫아웃)', () => {
    expect(judge([1, 2, 3], [7, 8, 9])).toEqual({ strikes: 0, balls: 0 });
  });
});