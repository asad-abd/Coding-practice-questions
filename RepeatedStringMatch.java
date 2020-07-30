//929. Unique Email Addresses(Easy)
class RepeatedStringMatch {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String t = "";
            boolean readAllowed = true, dotAllowed = false;
            for (int j = 0; j < emails[i].length(); j++) {
                if (emails[i].charAt(j) == '+')
                    readAllowed = false;
                if (emails[i].charAt(j) == '@') {
                    readAllowed = true;
                    dotAllowed = true;
                }
                if (readAllowed) {
                    if (!dotAllowed && emails[i].charAt(j) == '.')
                        continue;
                    t += emails[i].charAt(j);
                }

            }
            System.out.println(t);
            hs.add(t);
        }
        return hs.size();
    }
}