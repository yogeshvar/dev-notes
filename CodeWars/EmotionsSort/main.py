def sort_emotions(arr, order):
    emotions = {'T_T': 0, ':(': 1, ':|': 2, ':)': 3, ':D': 4}
    return sorted(arr, key=lambda x: emotions[x], reverse= order)