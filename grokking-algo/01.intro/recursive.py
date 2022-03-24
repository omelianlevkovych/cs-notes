# recursive binary search
def rec(list, item, bot, up):
    mid = (bot + up) // 2
    guess = list[mid]

    if bot == up and item != guess:
        return None
    if guess < item:
        return rec(list, item, mid + 1, up)
    if guess > item:
        return rec(list, item, bot, mid - 1)
    if guess == item:
        return mid

list = [1,4, 6, 9]

res = rec(list, 64, 0, len(list) - 1)
print(res)

## yea this seems a bit stupid but I did it :)