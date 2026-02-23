import * as readline from 'readline';
import { judge } from './judge/judge';
import { generateNumber, randomGenerator } from './numbergenerator/numberGenerator';
import { parseInput } from './inputParser/inputParser';

function createReadline() {
  return readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });
}

function question(rl: readline.Interface, prompt: string): Promise<string> {
  return new Promise((resolve) => rl.question(prompt, resolve));
}

async function playGame(rl: readline.Interface): Promise<void> {
  const answer = generateNumber(randomGenerator);
  console.log('\n 숫자 야구 게임 시작! (1~9 사이 서로 다른 3자리 숫자)');

  while (true) {
    const input = await question(rl, '\n숫자를 입력하세요: ');

    let guess: number[];
    try {
      guess = parseInput(input.trim());
    } catch (e) {
      console.log(` 입력 오류: ${(e as Error).message}`);
      continue;
    }

    const { strikes, balls } = judge(answer, guess);

    if (strikes === 3) {
      console.log('3스트라이크');
      return;
    }

    if (strikes === 0 && balls === 0) {
      console.log('낫싱');
    } else {
      const parts: string[] = [];
      if (balls > 0) parts.push(`${balls}볼`);
      if (strikes > 0) parts.push(`${strikes}스트라이크`);
      console.log(parts.join(' '));
    }
  }
}

async function main() {
  const rl = createReadline();

  while (true) {
    await playGame(rl);

    while (true) {
      const choice = await question(
        rl,
        '\n다시 시작하시겠습니까? (1: 재시작 / 2: 종료): '
      );
      if (choice.trim() === '1') break;
      if (choice.trim() === '2') {
        console.log('게임을 종료합니다.');
        rl.close();
        return;
      }
      console.log('1 또는 2를 입력하세요.');
    }
  }
}

main().catch(console.error);