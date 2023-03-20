queries = [5,1,4]

def minimumWaitingTime(queries):
    queries.sort()
    totalWaitingTime = 0
    for idx, duration in enumerate(queries):
        queriesLeft = len(queries) - (idx + 1)
        totalWaitingTime += duration * queriesLeft
    return totalWaitingTime

x = minimumWaitingTime(queries)