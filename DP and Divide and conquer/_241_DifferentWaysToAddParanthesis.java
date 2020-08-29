import java.util.*;

class _241_DifferentWaysToAddParanthesis {
    // just recursive- 36 ms
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < input.length(); i++) {

            // SMC- silly mistake chance below
            // this is obviously wrong you stupid!
            /*
             * if (input.length() == 1) { ans.add(Integer.parseInt(input)); return ans; }
             */
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {

                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        switch (input.charAt(i)) {
                            case '+':
                                ans.add(left.get(j) + right.get(k));
                                System.out.println("+ and : " + left.get(j) + right.get(k));
                                break;
                            case '-':
                                ans.add(left.get(j) - right.get(k));
                                System.out.println("- and : " + (left.get(j) - right.get(k)));
                                break;
                            case '*':
                                ans.add(left.get(j) * right.get(k));
                                break;
                            default:
                                break;
                        }
                    }
                }

            }
        }
        // SMC- silly mistake chance above
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }

    /*---------------------------------------------------------------------------------------------------*/
    // recursion + memoization
    HashMap<String, List<Integer>> hmap = new HashMap<String, List<Integer>>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < input.length(); i++) {

            // SMC- silly mistake chance below
            // this is obviously wrong you stupid!
            /*
             * if (input.length() == 1) { ans.add(Integer.parseInt(input)); return ans; }
             */
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {

                List<Integer> left = hmap.getOrDefault(input.substring(0, i), diffWaysToCompute(input.substring(0, i)));
                List<Integer> right = hmap.getOrDefault(input.substring(i + 1, input.length()),
                        diffWaysToCompute(input.substring(i + 1, input.length())));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        switch (input.charAt(i)) {
                            case '+':
                                ans.add(left.get(j) + right.get(k));
                                System.out.println("+ and : " + left.get(j) + right.get(k));
                                break;
                            case '-':
                                ans.add(left.get(j) - right.get(k));
                                System.out.println("- and : " + (left.get(j) - right.get(k)));
                                break;
                            case '*':
                                ans.add(left.get(j) * right.get(k));
                                break;
                            default:
                                break;
                        }
                    }
                }

            }
        }
        // SMC- silly mistake chance above
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(input));
        }
        hmap.put(input, ans);
        return ans;
    }
}