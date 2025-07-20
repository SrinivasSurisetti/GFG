class Solution:
    def countValid(self, n, arr):
        forbidden = set(arr)
        total = 9 * pow(10, n - 1)

        # Count how many n-digit numbers have NO digit from 'arr'
        def countWithoutForbidden():
            allowed_digits = [d for d in range(10) if d not in forbidden]
            if 0 in allowed_digits:
                first_digit_choices = len(allowed_digits) - 1
            else:
                first_digit_choices = len(allowed_digits)

            if first_digit_choices == 0:
                return 0

            return first_digit_choices * pow(len(allowed_digits), n - 1)

        without = countWithoutForbidden()
        return total - without

        # 13 15
        # 23 25 30
        # - 9
        # - 3
        # - 9
        # - 2 66
        # - 2 77
        # - 2 88
        # - 2 99