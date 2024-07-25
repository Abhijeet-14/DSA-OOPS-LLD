"""Leetcode: [https://leetcode.com/problems/asteroid-collision/]"""


class Solution:
    def asteroidCollision(self, asteroids: list[int]) -> list[int]:
        st = []

        for val in asteroids:
            if val > 0:
                st.append(val)
            else:
                while st and val < 0 and st[-1] / val < 0:
                    diff = st[-1] + val
                    if diff < 0:
                        st.pop()
                    elif diff == 0:
                        st.pop()
                        val = 0
                    else:
                        val = 0
                if val != 0:
                    st.append(val)

            # if st and val < 0:
            #     while st and st[-1] > 0 and st[-1]/val<0 and abs(st[-1]) < abs(val):
            #         st.pop()
            #     if st and st[-1]>0:
            #         if abs(st[-1]) < abs(val):
            #             st.append(val)
            #         elif abs(st[-1]) == abs(val):
            #             st.pop()
            #     else:
            #         st.append(val)
            # else:
            #     st.append(val)

        return st
