export function parseInput(input: string): number[] {
  if (input.length !== 3) {
    throw new Error('3자리 숫자를 입력하세요');
  }

  if (!/^\d+$/.test(input)) {
    throw new Error('숫자만 입력하세요');
  }

  const digits = input.split('').map(Number);

  if (digits.some((n) => n === 0)) {
    throw new Error('1~9 사이의 숫자를 입력하세요');
  }

  if (new Set(digits).size !== 3) {
    throw new Error('중복된 숫자가 있습니다');
  }

  return digits;
}