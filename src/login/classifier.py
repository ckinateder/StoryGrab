import gzip
import gensim 
import logging
 
logging.basicConfig(format='%(asctime)s : %(levelname)s : %(message)s', level=logging.INFO)
with gzip.open (input_file, 'rb') as f:
        for i,line in enumerate (f):
            print(line)
            break