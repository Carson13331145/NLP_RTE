#!/usr/bin/env python
# -*- coding: utf-8 -*-

import gensim

print 'loading model...'
model = gensim.models.Word2Vec.load("wiki_1g_model")
print 'complete.'

print 'searching for \'电影\' in model...'
model.most_similar(u"电影")
result = model.most_similar(u"电影")
for e in result:
    print e[0], e[1]

print 'searching for \'北京大学\' in model...'
model.most_similar(u"北京大学")
result = model.most_similar(u"北京大学")
for e in result:
    print e[0], e[1]

print 'searching for \'男人\' in model...'
model.most_similar(u"男人")
result = model.most_similar(u"男人")
for e in result:
    print e[0], e[1]

print 'searching for \'圣经\' in model...'
model.most_similar(u"圣经")
result = model.most_similar(u"圣经")
for e in result:
    print e[0], e[1]

print 'searching for \'习近平\' in model...'
model.most_similar(u"习近平")
result = model.most_similar(u"习近平")
for e in result:
    print e[0], e[1]

