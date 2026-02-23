export interface NumberGenerator {
  generate(min: number, max: number): number;
}


export const randomGenerator: NumberGenerator = {
  generate(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  },
};


export function generateNumber(generator: NumberGenerator): number[] {
  const digits: number[] = [];

  while (digits.length < 3) {
    const n = generator.generate(1, 9);
    if (!digits.includes(n)) {
      digits.push(n);
    }
  }

  return digits;
}