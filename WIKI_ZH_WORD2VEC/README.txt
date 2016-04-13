WIKI_ZH_WORD2VEC

time: 2016.3.15

discription:
    I use jieba to parse the corpus(downloaded from wiki),
then write a C# program to remove the html-tag. After parsing,
I use word2vec(python) to train the vector-model.

structure:
- jieba (Chinese parser - python)
- wiki_zh_1gb (1G-corpus, well trained model/vector)
- wiki_zh_60mb (60M-corpus, well trained model/vector)
- WikiExtractor.py (extract the corpus to local)
- train_word2vec_model.py (program to train word2vec model - python)
