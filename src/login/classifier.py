from numpy import *
import csv
from pandas import *
import os
from nltk.corpus import stopwords 
from nltk.stem.wordnet import WordNetLemmatizer
import string
import gensim
from gensim import corpora

stop = set(stopwords.words('english'))
exclude = set(string.punctuation) 
lemma = WordNetLemmatizer()

dirname = os.path.dirname(__file__)
path = "C:\\Users\\calvi\\Documents\\NetBeansProjects\\StoryGrab\\links.csv"
df = DataFrame.from_csv(path, sep='---split---')
array = df.values
#print(array)
#https://www.analyticsvidhya.com/blog/2016/08/beginners-guide-to-topic-modeling-in-python/

#doc_complete = [df.iloc[0][2],df.iloc[1][2],df.iloc[2][2],df.iloc[3][2]]
doc_complete = [None] * df.shape[0]
for x in range(0,df.shape[0]):
	doc_complete[x] = df.iloc[x][2]

def clean(doc):
    stop_free = " ".join([i for i in doc.lower().split() if i not in stop])
    punc_free = ''.join(ch for ch in stop_free if ch not in exclude)
    normalized = " ".join(lemma.lemmatize(word) for word in punc_free.split())
    return normalized
doc_clean = [clean(doc).split() for doc in doc_complete]   
#print(df.iloc[0][2])
dictionary = corpora.Dictionary(doc_clean)
doc_term_matrix = [dictionary.doc2bow(doc) for doc in doc_clean]
# Creating the object for LDA model using gensim library
Lda = gensim.models.ldamodel.LdaModel

# Running and Trainign LDA model on the document term matrix.
ldamodel = Lda(doc_term_matrix, num_topics=6, id2word = dictionary, passes=50)
print(ldamodel.print_topics(num_topics=6, num_words=3))
