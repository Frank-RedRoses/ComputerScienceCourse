

def flip(c): return str(1-int(c))

def flip_s(s, i):
   t =  s[:i]+flip(s[i])+s[i+1:]
   return t

def hamming(s, k):
 if k>1:
      c = s[-1]
      s1 = [y+c for y in hamming(s[:-1], k)] if len(s) > k else []
      s2 = [y+flip(c) for y in hamming(s[:-1], k-1)]
      r = []
      r.extend(s1)
      r.extend(s2)
      return r
 else:
    return [flip_s(s,i) for i in range(len(s))]

