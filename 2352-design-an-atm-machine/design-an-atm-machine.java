class ATM {

    long[] notes;
    int[] value = {20, 50, 100, 200, 500};

    public ATM() {
        notes = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            notes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] ans = new int[5];

        for (int i = 4; i >= 0; i--) {
            long take = Math.min(notes[i], amount / value[i]);
            ans[i] = (int) take;
            amount -= take * value[i];
        }

        if (amount != 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < 5; i++) {
            notes[i] -= ans[i];
        }

        return ans;
    }
}