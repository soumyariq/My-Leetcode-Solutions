class FrequencyTracker {
    private Map<Integer, Integer> occ;  
    private Map<Integer, Integer> freq; 
    public FrequencyTracker() {
        occ = new HashMap<>();
        freq = new HashMap<>();
    }
    public void add(int number) {
        int oldFreq = occ.getOrDefault(number, 0);
        int newFreq = oldFreq + 1;
        occ.put(number, newFreq);
        freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);
        if (oldFreq > 0) {
            freq.put(oldFreq, freq.getOrDefault(oldFreq, 0) - 1);
        }
    }
    public void deleteOne(int number) {
        if (occ.containsKey(number) && occ.get(number) > 0) {
            int oldFreq = occ.get(number);
            int newFreq = oldFreq - 1;
            occ.put(number, newFreq);
            if (newFreq > 0) {
                freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);
            }
            freq.put(oldFreq, freq.getOrDefault(oldFreq, 0) - 1);
        }
    }   
    public boolean hasFrequency(int frequency) {
        return freq.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */