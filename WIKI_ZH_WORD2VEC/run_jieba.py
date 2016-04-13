#import urllib2
import sys,time
import sys
sys.path.append("../../")
import jieba
#jieba.enable_parallel(500)

#url = sys.argv[1]
content = open("wiki_60mb_pure_fixed_chs","rb").read()
t1 = time.time()
words = list(jieba.cut(content))

t2 = time.time()
tm_cost = t2-t1

log_f = open("wiki_60mb_pure_ceg","wb")
for w in words:
    print >> log_f, w.encode("utf-8"), "/" ,

print 'speed', len(content)/tm_cost, " bytes/second"
