#!/usr/bin/python
import sys

def gen_primes():
    D = {}  
    q = 2  
    while True:
        if q not in D: 
            yield q        
            D[q * q] = [q]
        else:
            for p in D[q]:
                D.setdefault(p + q, []).append(p)
            del D[q]
        q += 1

def nth_prime(n):
    return (j for i,j in enumerate(gen_primes()) if i == n-1).next()
	
f = open(sys.argv[1], "r")
val = int(f.readline())
f.close()

print nth_prime(val);