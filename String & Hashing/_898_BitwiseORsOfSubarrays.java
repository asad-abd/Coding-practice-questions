//interesting question. Must review and re-read the discussions
class _898_BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> current = new HashSet<>();
        HashSet<Integer> previous = new HashSet<>();
        HashSet<Integer> unique = new HashSet<>();
        previous.add(0);
        for (int x : A) {
            current = new HashSet<>();
            current.add(0);// important to make sure that subarray having just x is there
            for (int y : previous) {
                current.add(y | x);
                if (!unique.contains(y | x))
                    unique.add(y | x);
            }
            previous = current;
        }
        return unique.size();
    }
}
