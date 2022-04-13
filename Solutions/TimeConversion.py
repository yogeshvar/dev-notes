input = "12:45:54PM"


def time_conversion(time_given):
    if time_given[-2:] == "AM":
        if time_given[:2] == "12":
            return "00" + time_given[2:-2]
        else:
            return time_given[:-2]
    else:
        if time_given[:2] == "12":
            return time_given[:-2]
        hours = 12 + int(time_given[:2])
        time_given = time_given.replace(time_given[:2], str(hours))
        return time_given[:-2]


print(time_conversion(input))
