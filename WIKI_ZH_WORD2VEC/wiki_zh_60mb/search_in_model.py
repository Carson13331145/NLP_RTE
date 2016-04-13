#!/usr/bin/env python
# -*- coding: utf-8 -*-

import gensim
model = gensim.models.Word2Vec.load("wiki_zh_model")
model.most_similar(u"电影")

result = model.most_similar(u"电影")
 
for e in result:
    print e[0], e[1]
