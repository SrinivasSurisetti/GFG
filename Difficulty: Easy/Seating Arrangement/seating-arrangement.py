class Solution:
    def canSeatAllPeople(self, k, seats):
        n = len(seats)

        # Check existing arrangement
        for i in range(n - 1):
            if seats[i] == 1 and seats[i + 1] == 1:
                return False

        count = 0

        # Try to seat new people
        for i in range(n):

            if seats[i] == 1:
                continue

            left_empty = (i == 0 or seats[i - 1] == 0)
            right_empty = (i == n - 1 or seats[i + 1] == 0)

            if left_empty and right_empty:
                seats[i] = 1
                count += 1

        return count >= k