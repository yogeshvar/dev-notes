"""
AlgoExpert Problem: Tournament Winner
Difficulty: Easy 🟢
"""


def tournamentWinner(competitions: list, result: list) -> str:
    winner = {}
    for idx, a in enumerate(competitions):
        if result[idx] == 0:
            if winner.get(a[1]) is None:
                winner[a[1]] = 3
            else:
                winner[a[1]] += 3
        else:
            if winner.get(a[0]) is None:
                winner[a[0]] = 3
            else:
                winner[a[0]] += 3
    maximum = max(winner, key=winner.get)
    return maximum


output = tournamentWinner(
    [["HTML", "C#"], ["C#", "Python"], ["Python", "HTML"]], [0, 0, 1])
print(output)
