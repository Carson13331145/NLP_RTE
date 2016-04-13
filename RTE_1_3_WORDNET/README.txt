RTE_1_3_WORDNET

time: 2016.4.14

discription:
    use standford-parser to parse the textual from RTE(1-3),
then I write some java programs to get rid of xml-tag, and
save the word-class of the words. Then I use java to change
the word-class tag to WordNet style (for example, NN -> NOUN).
At last, I write a java-project to count the number of synonyms
between text and hypertext.

structure:
- DEV_FIX
-- RTE_ORIGIN.xml (RTE 1-3)
-- *_PURE.txt (text after removing xml-tag)
-- *_FIX.txt (after parsing by standford-parser)
-- *_JWI.txt (change tag-name into WordNet style)
-- TRUE_OR_FALSE.txt (whether entailed or not)

note:
    after fixed, the corresponding text and hypertext is in the
same line of its file (their entailment information is stored in
TRUE_OR_FALSE.txt by 1<true> or 0<false>).
