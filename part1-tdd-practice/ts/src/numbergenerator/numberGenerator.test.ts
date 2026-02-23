import { NumberGenerator, generateNumber } from './numbergenerator';

const makeSequenceGenerator = (seq: number[]): NumberGenerator => {
  let i = 0;
  return {
    generate: (_min: number, _max: number) => seq[i++ % seq.length],
  };
};

describe('generateNumber', () => {
  test('3자리 숫자 배열을 반환한다', () => {
    const gen = makeSequenceGenerator([1, 2, 3]);
    expect(generateNumber(gen)).toHaveLength(3);
  });

  test('중복이 없는 숫자를 반환한다', () => {
    const gen = makeSequenceGenerator([1, 2, 3]);
    const result = generateNumber(gen);
    expect(new Set(result).size).toBe(3);
  });

  test('중복 숫자는 스킵하고 3개를 채운다', () => {
    const gen = makeSequenceGenerator([1, 1, 2, 3]);
    const result = generateNumber(gen);
    expect(result).toEqual([1, 2, 3]);
  });

  test('생성기 교체로 결과 제어 가능 (랜덤 격리 증명)', () => {
    const gen = makeSequenceGenerator([7, 8, 9]);
    expect(generateNumber(gen)).toEqual([7, 8, 9]);
  });

  test('generate()가 min=1, max=9로 호출된다 (범위 계약)', () => {
    let capturedMin = 0;
    let capturedMax = 0;
    let call = 0;
    const spyGen: NumberGenerator = {
      generate(min: number, max: number): number {
        capturedMin = min;
        capturedMax = max;
        return [4, 5, 6][call++ % 3];
      },
    };
    generateNumber(spyGen);
    expect(capturedMin).toBe(1);
    expect(capturedMax).toBe(9);
  });
});