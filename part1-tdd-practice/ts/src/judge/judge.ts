export interface JudgeResult {
  strikes: number;

}

export function judge(answer: number[], guess: number[]): JudgeResult {
  let strikes = 0;


  for (let i = 0; i < 3; i++) {
    if (answer[i] === guess[i]) {
      strikes++;
    } 
  }

  return { strikes};
}