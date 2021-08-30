class _sprinklr_XOR_coding_test_adjacent_bits_to_make_s1_to_s2{
    /*
    Given two binary strings A and B. In one move you can choose any two adjust numbers from 
    string A and replace any of them with XOR of them and another one with OR of them. 
    Ex: A=0010110. You chose 0 and 1 so, 0 XOR 1=1 and 0 OR 1=1 so, 01 becomes 11. 
    You can apply this move on string A any number of times and it is possible 
    to make string B from A then return YES otherwise NO. (50 Marks)

    Answer : Count number of ones in both string. lets counts be cnt1 and **cnt2. 
    **answer is “YES” if (cnt1>0 && cnt2>0) or if (cnt1==0 && cnt2==0), 
    otherwise answer is “NO”. 
    Do not forget to check length of two strings. 
    Obviously answer will be “NO” if strings are of different length. because 2 bits are creating 2 bits only. 
        no way of increasing/decreasing them.
    */
}