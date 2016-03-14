# Train cannot exceed capacity or be below 0
# Should start and finish empty
# No passenger should wait if train is not full
# No passengers should wait at the last station

capacity, num_stops = [int(e) for e in input().split()]

# Format: [Num left] [Num entered] [Num waited]
passengers = 0

for i in range(num_stops):
    left, entered, waited = [int(e) for e in input().split()]

    passengers += entered - left
    if passengers < 0 or passengers > capacity:
        print('impossible')
        break

    if i == 0 and left != 0:
        print('impossible')
        break

    if waited != 0 and passengers != capacity:
        print('impossible')
        break

    if i == num_stops - 1:
        if passengers != 0 or waited != 0:
            print('impossible')
            break

    if i == num_stops - 1:
        print('possible')

