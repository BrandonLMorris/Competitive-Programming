#!/usr/bin/env python3
"""Solution to the Kattis problem Trik"""

def move_cups(ball_pos, move_type):
    """
    Move the cups around some

    :param ball_pos: The initial position of the ball (0-2)
    :param move_type: The type of move, {'A', 'B', 'C'}
    :returns: The location of the ball after the move (0-2)
    """
    if move_type == 'A':
        # First two cups swap
        if ball_pos == 0: ball_pos = 1
        elif ball_pos == 1: ball_pos = 0
    elif move_type == 'B':
        # Second and thrid cups swap
        if ball_pos == 1: ball_pos = 2
        elif ball_pos == 2: ball_pos = 1
    else:
        # First and third cups swap
        if ball_pos == 0: ball_pos = 2
        elif ball_pos == 2: ball_pos = 0

    return ball_pos


if __name__ == '__main__':
    pos, moves = 0, input()
    for move in moves: pos = move_cups(pos, move)
    print(pos + 1)

