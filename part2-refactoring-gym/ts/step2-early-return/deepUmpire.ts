export class DeepUmpire {
    private readonly TARGET_SIZE = 3;

    public countStrike(answer: number[] | null, guess: number[] | null): number {

        if (answer === null || guess === null) {
            throw new Error("입력값은 null일 수 없습니다.");
        }

        if (answer.length !== this.TARGET_SIZE || guess.length !== this.TARGET_SIZE) {
            throw new Error("입력값의 길이가 올바르지 않습니다.");
        }

        let strikeCount = 0;

        for (let index = 0; index < this.TARGET_SIZE; index++) {
            if (answer[index] === guess[index]) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
