export class MassiveUmpire {
    public playGame(rawAnswer: string[], rawGuess: string[]): [number, number] {
        // 1. 입력 검증
        this.validateInput(rawAnswer, rawGuess);

        // 2. 파싱 (String -> Number)
        const answer = this.parseInput(rawAnswer);
        const guess = this.parseInput(rawGuess);

        // 3. 스트라이크 판정
        const strikeCount = this.countStrike(answer, guess);

        // 4. 볼 판정
        const ballCount = this.countBall(answer, guess);

        // 5. 결과 반환 [스트라이크, 볼]
        return [strikeCount, ballCount];
    }

    private validateInput(rawAnswer: string[], rawGuess: string[]){
        if (!rawAnswer || !rawGuess) {
            throw new Error("입력값은 null이나 undefined일 수 없습니다.");
        }
        if (rawAnswer.length !== 3 || rawGuess.length !== 3) {
            throw new Error("입력값의 길이가 3이어야 합니다.");
        }
    }

    private parseInput(raw: string[]): number[]{
        const input: number[] = [];

        for (let i = 0; i < 3; i++) {
            const parsed = Number(raw[i]);

            if (Number.isNaN(parsed)) {
                throw new Error("숫자만 입력 가능합니다.");
            }
            input.push(parsed);
        }

        return input;
    }

    private countStrike(answer: number[], guess: number[]): number{
        let strikeCount = 0;
        for (let i = 0; i < 3; i++) {
            if (answer[i] === guess[i]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private countBall(answer: number[], guess: number[]): number{
        let ballCount = 0;
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                if (i !== j && answer[i] === guess[j]) {
                    ballCount++;
                }
            }
        }

        return ballCount;
    }
}
