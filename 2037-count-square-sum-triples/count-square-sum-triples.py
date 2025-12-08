class Solution:
    def countTriples(self, n: int) -> int:
        s = set()
        count = 0
        for i in range(1,n+1):
            s.add(i**2)
        for j in range(1,n+1):
            for k in range(1,n+1):
                if (j**2 + k**2) in s:
                    count+=1
        return count