# import libraries
from collections import defaultdict
import math
import re
import pandas as pd
from pprint import pprint
import nltk
import contractions
from nltk.corpus import stopwords
from nltk.stem import PorterStemmer, SnowballStemmer
from nltk.tokenize.treebank import TreebankWordDetokenizer
from nltk.stem import WordNetLemmatizer
from nltk.tokenize import word_tokenize
import sys
import time
import string

# constants
ENCODING = "ISO-8859-1"
FILE_NAME = "NB-Classifier/imdb_master.csv"
CONFIG = {
    "stemming": True,
    "stop_words_removal": True,
    "contractions": False,
    "punctuation_removal": True,
    "lemmatization": False,
}


class text_normalization:
    def __init__(self, config, df):
        self.config = config
        self.df = df
        self.normalize()

    def normalize(self):
        self.df.review = self.df.review.apply(lambda x: x.lower())
        if self.config.get("contractions"):
            self.df.review = self.df.review.apply(
                lambda x: contractions.fix(x))
            self.df.review = self.df.review.apply(
                lambda x: re.sub(r"\'nt", " not", x))
        if self.config.get("stop_words_removal"):
            stop_words = set(stopwords.words('english'))
            word_tokens = []
            for i in range(len(self.df)):
                word_tokens = nltk.word_tokenize(self.df.review[i])
                filtered_sentence = [
                    w for w in word_tokens if not w in stop_words]
                self.df.review[i] = ' '.join(filtered_sentence)
        if self.config.get("punctuation_removal"):
            self.df.review = self.df.review.apply(
                lambda x: re.sub(r'<.*?>', '', x))
            self.df.review = self.df.review.apply(
                lambda x: re.sub(r'\s+', ' ', x))
            self.df.review = self.df.review.apply(
                lambda x: re.sub(r'\d+', ' ', x))
            self.df.review = self.df.review.apply(
                lambda x: x.translate(str.maketrans('', '', string.punctuation)))
            self.df.review = self.df.review.apply(
                lambda x: re.sub(r'https?://\S+|www\.\S+', '', x))
            self.df.review = self.df.review.apply(
                lambda x: re.sub(r'\d+', '', x))
        if self.config.get("stemming"):
            ps = SnowballStemmer('english')
            self.df.review = self.df.review.apply(
                lambda x: ' '.join([ps.stem(word) for word in x.split()]))
        if self.config.get("lemmatization"):
            wnl = WordNetLemmatizer()
            self.df.review = self.df.review.apply(lambda x: ' '.join(
                [wnl.lemmatize(word) for word in x.split()]))
        detokenizer = TreebankWordDetokenizer()
        self.df.review.apply(
            lambda x: detokenizer.detokenize(x))
        processed_df = self.df
        return processed_df


"""
Naive Bayes' Classifier 
Reference: https://web.stanford.edu/~jurafsky/slp3/ (Speech and Language Processing (3rd ed. draft))
"""


class NaiveBayes:
    def __init__(self):
        self.nc = {}
        self.logprior = {}
        self.word_counts = {}
        self.vocabulary = set()
        self.loglikelihood = defaultdict(defaultdict)

    def get_word_counts(self, words):
        count_word = {}
        for word in words:
            count_word[word] = count_word.get(word, 0.0) + 1.0
        return count_word

    def get_bigram_counts(self, words):
        count_bigram = {}
        for i in range(len(words)-1):
            bigram = words[i] + ' ' + words[i+1]
            count_bigram[bigram] = count_bigram.get(bigram, 0.0) + 1.0
        return count_bigram

    def train(self, data, labels, isBigram=False):
        # Number of docs
        Ndoc = len(labels)
        # Classes in the data
        C = set(labels)

        # For each class c belongs to C
        for class_ in C:
            # Number of docs in class c
            self.nc['pos' if class_ == 1 else 'neg'] = labels.count(class_)
            # logprior = log(nc/Ndoc)
            self.logprior['pos' if class_ == 1 else 'neg'] = math.log(
                self.nc['pos' if class_ == 1 else 'neg'] / Ndoc)
            self.word_counts['pos' if class_ == 1 else 'neg'] = {}

        # bigDoc
        for x, y in zip(data, labels):
            c = 'pos' if y == 1 else 'neg'
            counts = self.get_word_counts(word_tokenize(x))
            if isBigram == True:
                bigram_counts = self.get_bigram_counts(word_tokenize(x))
                for word, count in bigram_counts.items():
                    if word not in self.vocabulary:
                        self.vocabulary.add(word)
                    if word not in self.word_counts[c]:
                        self.word_counts[c][word] = 0.0

                    self.word_counts[c][word] += count
            for word, count in counts.items():
                if word not in self.vocabulary:
                    self.vocabulary.add(word)
                if word not in self.word_counts[c]:
                    self.word_counts[c][word] = 0.0

                self.word_counts[c][word] += count

        for class_ in C:
            total_count = 0
            # occurrences of w in bigdoc
            for word in self.vocabulary:
                total_count += self.word_counts['pos' if class_ ==
                                                1 else 'neg'].get(word, 0.0)

            # loglikelihood[w,c]
            for word in self.vocabulary:
                count = self.word_counts['pos' if class_ == 1 else 'neg'].get(
                    word, 0.0)
                self.loglikelihood[class_][word] = math.log(
                    (count + 1) / (total_count + 1 * len(self.vocabulary)))

    def classify(self, data, isBigram=False):
        result = []
        for x in data:
            counts = self.get_word_counts(word_tokenize(x))
            pos_score = 0
            neg_score = 0
            # sum logprior to score
            pos_score += self.logprior['pos']
            neg_score += self.logprior['neg']
            if isBigram == True:
                bigram_counts = self.get_bigram_counts(word_tokenize(x))
                for word, _ in bigram_counts.items():
                    try:
                        if word in self.vocabulary:
                            pos_score += self.loglikelihood['pos'][word]
                            neg_score += self.loglikelihood['neg'][word]
                    except KeyError:
                        netural_score = 0
                        pos_score += netural_score
                        neg_score += netural_score
            for word, _ in counts.items():
                if word in self.vocabulary:
                    pos_score += self.loglikelihood[1][word]
                    neg_score += self.loglikelihood[0][word]
            # instead of return argmax(sum[c]), we return append the result.
            if pos_score > neg_score:
                result.append(1)
            else:
                result.append(0)
        return result


"""
Split the data into training and testing data
"""


def split_data(df):
    df_train = pd.DataFrame(columns=['type', 'review', 'label'])
    df_test = pd.DataFrame(columns=['type', 'review', 'label'])
    for _, row in df.iterrows():
        typ = row.type
        if typ == 'test':
            df_test = df_test.append(row)
        else:
            df_train = df_train.append(row)

    train_data = df_train.review.tolist()
    test_data = df_test.review.tolist()

    train_labels = df_train.label.tolist()
    test_labels = df_test.label.tolist()
    train_labels = [1 if x == 'pos' else 0 for x in train_labels]
    test_labels = [1 if x == 'pos' else 0 for x in test_labels]

    return train_data, train_labels, test_data, test_labels


""" 
Load the data from the given filename
"""


def load_data(filename):
    lines = pd.read_csv(open(filename, "r", encoding=ENCODING))
    data = lines.dropna()
    data = data.iloc[0:, 1:-1]
    data = data[data.label != 'unsup']
    return data


"""
Calculate Confusion Matrix from Predicted and Actual Labels
"""


def calc_confusion_matrix(predicted, actual):
    tpos = 0
    fpos = 0
    tneg = 0
    fneg = 0
    for i in range(len(predicted)):
        if predicted[i] == 1 and actual[i] == 1:
            tpos += 1
        elif predicted[i] == 1 and actual[i] == 0:
            tneg += 1
        elif predicted[i] == 0 and actual[i] == 1:
            fpos += 1
        elif predicted[i] == 0 and actual[i] == 0:
            fneg += 1

    return tpos, fpos, tneg, fneg


"""
Metrics for the prediction model.

"""


def accuracy_score(pred, labels):
    tpos, fpos, tneg, fneg = calc_confusion_matrix(pred, labels)
    return (tpos + tneg) / (tpos + tneg + fpos + fneg)


def f1_score(pred, labels):
    tpos, fpos, tneg, fneg = calc_confusion_matrix(pred, labels)
    precision = tpos / (tpos + tneg)
    recall = tpos / (tpos + fpos)
    return 2 * (precision * recall) / (precision + recall)


def main():
    try:
        start = time.time()
        data = load_data(FILE_NAME)
        dataFrame = pd.DataFrame(data, columns=['type', 'review', 'label'])
        processed_df = text_normalization(CONFIG, dataFrame)
        end = time.time()
        print("Time taken to process data: ", end-start)
        df = processed_df.df
        train_data, train_labels, test_data, test_labels = split_data(df)

        start = time.time()

        NB_Classifier = NaiveBayes()
        NB_Classifier.train(train_data, train_labels)
        pred = NB_Classifier.classify(test_data)

        end = time.time()
        print("Time taken for Model: ", round(end - start, 3))
        pprint(CONFIG)
        print(" ==> ", calc_confusion_matrix(pred, test_labels))
        print(" => ", f1_score(pred, test_labels))
    except:
        print("Error: ", sys.exc_info())


if __name__ == "__main__":
    main()
