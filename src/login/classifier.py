from numpy import *
import csv
from pandas import *
import os
dirname = os.path.dirname(__file__)
df = DataFrame.from_csv("C:\\Users\\calvi\\Documents\\NetBeansProjects\\StoryGrab\\links.csv", sep='-split-')
array = df.values
