export class BadUmpire {
    private static readonly NUMBER_LENGTH = 3;
    public countStrikes(guess: number[], answer: number[]): number {
        let strikeCount = 0;
        for (let index = 0; index < BadUmpire.NUMBER_LENGTH; index++) {
            if (guess[index] === answer[index]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public countBalls(guess: number[], answer: number[]): number {
        let ballCount = 0;
        for (let index = 0; index < BadUmpire.NUMBER_LENGTH; index++) {
            for (let j = 0; j < BadUmpire.NUMBER_LENGTH; j++) {
                if (index !== j && guess[index] === answer[j]) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
}
