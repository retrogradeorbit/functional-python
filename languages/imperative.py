from data import languages

aaa = 0
bbb = []
ccc = []
ddd = []
eee = []
fff = []
ggg = {}
hhh = []

for language in languages:
    aaa += 1

    for iii in language['influenced-by']:
        if iii=='Lisp':
            ddd.append(language['language'])
        if 'Lisp' in iii:
            eee.append(language['language'])
        if iii not in fff:
            fff.append(iii)
        if iii not in ggg:
            ggg[iii]=1
            continue

        ggg[iii]+=1

    bbb.append(language['inventor'])
    if language['first-year']>2000:
        ccc.append(language)

for k,v in ggg.iteritems():
    if len(hhh)<5:
        hhh.append((k,v))
        continue

    m=99999
    for t,c in hhh:
        if c<m:
            m=c
    i = 0
    for n,c in hhh:
        if c==m:
            hhh[i] = (k,v)
            break
        i+=1

print "aaa", aaa
print "bbb", bbb
print "ccc", ccc
print "ddd", ddd
print "eee", eee
print "fff", fff
print "ggg", ggg
print "hhh", hhh
