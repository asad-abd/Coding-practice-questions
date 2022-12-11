class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        newDigits = []
        carry = 1
        for digit in reversed(digits):
            new = digit + carry
            carry = int(new / 10)
            new = int(new % 10)

            newDigits.append(new)
        if(carry > 0):
            newDigits.append(carry)

        return reversed(newDigits)