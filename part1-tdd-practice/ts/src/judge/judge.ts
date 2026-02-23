export interface JudgeResult {
  strikes: number;
  balls: number;
}

export function judge(answer: number[], guess: number[]): JudgeResult {
  let strikes = 0;
  let balls = 0;

  for (let i = 0; i < 3; i++) {
    if (answer[i] === guess[i]) {
      strikes++;
    } else if (answer.includes(guess[i])) {
      balls++;
    }
  }

  return { strikes, balls };
}