#https://www.analyticsvidhya.com/blog/2016/08/beginners-guide-to-topic-modeling-in-python/
#https://machinelearningmastery.com/clean-text-machine-learning-python/
print("Importing")
from numpy import *
import csv
from pandas import *
import os
from nltk.corpus import stopwords 
from nltk.stem.wordnet import WordNetLemmatizer
import string
import gensim
from gensim import corpora
import string
from pprint import pprint

stop = set(stopwords.words('english'))
exclude = set(string.punctuation) 
lemma = WordNetLemmatizer()
print("Initialized WordNetLemmatizer")
dirname = os.path.dirname(__file__)
path = "datasets\\links.csv"
path = "datasets/links.csv"
df = DataFrame.from_csv(path, sep='---split---')
array = df.values
print("DataFrame loaded")
#doc_complete = [df.iloc[0][2],df.iloc[1][2],df.iloc[2][2],df.iloc[3][2]]
doc_complete = [None] * df.shape[0]
for x in range(0,df.shape[0]):
	doc_complete[x] = df.iloc[x][2]
print("DataFrame into list - now cleaning")
def clean(doc):
    stop_free = " ".join([i for i in doc.lower().split() if i not in stop])
    punc_free = ''.join(ch for ch in stop_free if ch not in exclude)
    normalized = " ".join(lemma.lemmatize(word) for word in punc_free.split())
    normalized = normalized.encode('ascii',errors='ignore')
    #normalized = gensim.utils.simple_preprocess(str(normalized), deacc=True)
    return normalized
doc_clean = [clean(doc).split() for doc in doc_complete]   
print("List cleaned")
#print(df.iloc[0][2])
dictionary = corpora.Dictionary(doc_clean)
doc_term_matrix = [dictionary.doc2bow(doc) for doc in doc_clean]
# Creating the object for LDA model using gensim library
Lda = gensim.models.ldamodel.LdaModel
print("LDA created - now training")
# Running and Trainign LDA model on the document term matrix.
ldamodel = Lda(doc_term_matrix, num_topics=4, id2word = dictionary, passes=75)
print("Finished")
pprint(ldamodel.print_topics(num_words=3))
