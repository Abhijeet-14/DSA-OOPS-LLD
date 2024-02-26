"""
The cuty of hackerland organized a ches tournament for its citizens
There are n participants numbered 1 to n where the ith partcipant has potential denoted by potential[i]. The potential of each layer is distinct. initially, all player stand in a queue in order from the 1st to the nth player in each game,, the first 2 participants of the queue compete and the participant with a higher potentails wins the gam. agter each game, the winner remains at the beginning of the queuq and plays with next person from the quueu aand the losing player goes to the end of the queue. The cgames continues until a player win k consecutive games.
Given the potential of the participants and deciding factor k, find the potential of the winning player.
"""

"""
# Sample code to perform I/O:

name = input()                  # Reading input from STDIN
print('Hi, %s.' % name)         # Writing output to STDOUT

# Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
"""
from collections import deque

n, k = 6, 2
potential = [5, 2, 3, 6, 1, 4]

winner = [0] * n


dq = deque()
for i in range(0, n):
    dq.append(i)

previous_win = 0
while not winner.__contains__(k):
    fighter_1 = dq.popleft()
    fighter_2 = dq.popleft()

    if potential[fighter_1] > potential[fighter_2]:
        if previous_win != fighter_1:
            winner = [0] * n
        winner[fighter_1] += 1
        previous_win = fighter_1

        dq.appendleft(fighter_1)
        dq.append(fighter_2)
    else:
        if previous_win != fighter_2:
            winner = [0] * n
        winner[fighter_2] += 1
        previous_win = fighter_2

        dq.appendleft(fighter_2)
        dq.append(fighter_1)

palyer_win = winner.index(k)

print(potential[palyer_win])


# for i in range(2001, 3000):
#     text = f"insert ignore into mydb.matches (name, tourId, format, startTime, endTime) values ('GT@{i} vs RCB@{i}', 1, 'T20', '2023-04-09 18:00:00', '2023-04-09 23:00:00');"
#     print(text)


# DELIMITER //
# CREATE PROCEDURE  if not exists mydb.InsertTour()
# BEGIN
#   DECLARE i INT DEFAULT 1;

#   WHILE i >= 0 and i <= 30000 DO
#     insert into mydb.tours (name, sportId, startTime, endTime) values (CONCAT('A_TOUR', i), 1, '2023-04-09 00:00:00', '2023-05-30 00:00:00');


#     SET i = i + 1;
#   END WHILE;
# END //
# DELIMITER ;
# --
# -- -- Call the stored procedure
# CALL InsertTour();
