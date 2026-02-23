import { parseInput } from './inputParser';

describe('parseInput - 입력 검증', () => {
  test('유효한 입력 "123"은 [1,2,3] 배열을 반환한다', () => {
    expect(parseInput('123')).toEqual([1, 2, 3]);
  });

  test('유효한 입력 "789"은 [7,8,9] 배열을 반환한다', () => {
    expect(parseInput('789')).toEqual([7, 8, 9]);
  });

  test('길이가 3이 아니면 에러를 던진다', () => {
    expect(() => parseInput('12')).toThrow('3자리 숫자를 입력하세요');
    expect(() => parseInput('1234')).toThrow('3자리 숫자를 입력하세요');
    expect(() => parseInput('')).toThrow('3자리 숫자를 입력하세요');
  });

  test('숫자가 아닌 문자가 있으면 에러를 던진다', () => {
    expect(() => parseInput('1a3')).toThrow('숫자만 입력하세요');
    expect(() => parseInput('abc')).toThrow('숫자만 입력하세요');
  });

  test('0이 포함되면 에러를 던진다', () => {
    expect(() => parseInput('012')).toThrow('1~9 사이의 숫자를 입력하세요');
    expect(() => parseInput('102')).toThrow('1~9 사이의 숫자를 입력하세요');
  });

  test('중복된 숫자가 있으면 에러를 던진다', () => {
    expect(() => parseInput('112')).toThrow('중복된 숫자가 있습니다');
    expect(() => parseInput('121')).toThrow('중복된 숫자가 있습니다');
    expect(() => parseInput('111')).toThrow('중복된 숫자가 있습니다');
  });
});