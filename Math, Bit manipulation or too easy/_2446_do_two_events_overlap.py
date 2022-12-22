'''You are given two arrays of strings that represent two inclusive events that happened on the same day, event1 and event2, where:

event1 = [startTime1, endTime1] and
event2 = [startTime2, endTime2].
Event times are valid 24 hours format in the form of HH:MM.

A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).

Return true if there is a conflict between two events. Otherwise, return false.

 

Example 1:

Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
Output: true
Explanation: The two events intersect at time 2:00.


needed the second or in the if for the below testcase: (use all ifs that are possible in simple questions)
event1 =
["15:19","17:56"]
event2 =
["14:11","20:02"]
'''
class Solution:
    def getMinStamp(self, time: str) -> int:
        hr, min = time.split(':')
        min_stamp = int(hr) * 60 + int(min)
        print(min_stamp)
        return min_stamp

    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        st1 = self.getMinStamp(event1[0])
        st2 = self.getMinStamp(event2[0])

        end1 = self.getMinStamp(event1[1])
        end2 = self.getMinStamp(event2[1])

        # conflict if st2 or end2 between st1 and end1
        if (st2 >= st1 and st2 <= end1) or (end2 >= st1 and end2 <= end1) or (st1 >= st2 and st1 <= end2) or (end1 >= st2 and end1 <= end2):
            return True
        return False


