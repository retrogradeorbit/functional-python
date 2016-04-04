from data import languages

aaa = len(languages)

bbb = [l['inventor'] for l in languages]

ccc = [l for l in languages if l['first-year']>2000]

ddd = [l['language'] for l in languages if 'Lisp' in
       l['influenced-by']]

eee = [l['language'] for l in languages if [inf for inf in
                                            l['influenced-by'] if 'Lisp' in inf]]

fff = reduce( lambda a,ll: a+ll, [l['influenced-by'] for l in
                                      languages] )
uniq_fff = set(fff)

# helper functions
def assoc(d, k, v):
    copy = d.copy()
    copy[k] = v
    return copy

# count up vals
def counter(acc, val):
    return assoc(acc, val, acc.get(val, 0) + 1)

ggg = reduce(counter, fff, {})


hhh = list(
    reversed(
        sorted(
            [(v,k)
             for k,v in ggg.iteritems()]
        )
    )
)[:5]

print "aaa", aaa
print "bbb", bbb
print "ccc", ccc
print "ddd", ddd
print "eee", eee
print "fff", uniq_fff
print "ggg", ggg
print "hhh", hhh
