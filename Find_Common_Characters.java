class Solution {
    public List<String> commonChars(String[] words) {
        List<String> l = new ArrayList<>();
        Map<Character, Integer> mp = new HashMap<>();
        
        // Initialize frequency map with characters from the first word
        String s = words[0];
        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> temp = new HashMap<>();

        // Process each subsequent word
        for (int i = 1; i < words.length; i++) {
            String a = words[i];
            
            // Count characters in the current word
            for (char ch : a.toCharArray()) {
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }
            
            // Update the frequency map to keep minimum counts
            for (char ch : mp.keySet()) {
                if (temp.containsKey(ch)) {
                    mp.put(ch, Math.min(mp.get(ch), temp.get(ch)));
                } else {
                    mp.put(ch, 0);
                }
            }
            
            // Clear the temporary map for the next iteration
            temp.clear();
        }

        // Build the result list based on the final frequency map
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            char d = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                l.add(String.valueOf(d));
                count--;
            }
        }
        
        return l;
    }
}
