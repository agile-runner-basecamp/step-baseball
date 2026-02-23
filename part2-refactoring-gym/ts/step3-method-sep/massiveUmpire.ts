export class MassiveUmpire {
    private readonly TARGET_SIZE = 3;
    public playGame(rawAnswer: string[], rawGuess: string[]): [number, number] {
        this.validateInput(rawAnswer, rawGuess);

        const answer = this.parseToNumbers(rawAnswer);
        const guess = this.parseToNumbers(rawGuess);
        const strikeCount = this.countStrikes(answer, guess);
        const ballCount = this.countBalls(answer, guess);
        return [strikeCount, ballCount];
    }

    private validateInput(rawAnswer: string[] | null | undefined, rawGuess: string[] | null | undefined): void {
        
        // 1. 입력 검증
        if (!rawAnswer || !rawGuess) {
            throw new Error("입력값은 null이나 undefined일 수 없습니다.");
        }
        if (rawAnswer.length !== this.TARGET_SIZE || rawGuess.length !== this.TARGET_SIZE) {
            throw new Error("입력값의 길이가 3이어야 합니다.");
        }
    }

    private parseToNumbers(raw: string[]): number[] {

        const numbers: number[] = [];
        for (let i = 0; i < this.TARGET_SIZE; i++) {
            const parsed = Number(raw[i]);

            if (Number.isNaN(parsed)) {
                throw new Error("숫자만 입력 가능합니다.");
            }  
            numbers.push(parsed);
        }
        return numbers;
    }

    private countStrikes(answer: number[], guess: number[]): number {
        let strikeCount = 0;

        for (let i = 0; i < this.TARGET_SIZE; i++) {
            if (answer[i] === guess[i]) {
                strikeCount++;
            }  
        }
        return strikeCount;
    }   

    private countBalls(answer: number[], guess: number[]): number {
        let ballCount = 0;
        for (let i = 0; i < this.TARGET_SIZE; i++) {
            for (let j = 0; j < this.TARGET_SIZE; j++) {
                if (i !== j && answer[i] === guess[j]) {
                    ballCount++;
                }
            }
        }   return ballCount;  
    }
}
