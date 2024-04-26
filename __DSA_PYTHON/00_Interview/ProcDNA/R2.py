# Find out the number of ways we can complete the flooring of the size M*N using tile size M*1


class TileWays:
    def __init__(self):
        self.dp = {}

    def find_no_ways_to_cover_room(self, tile_height, room_width):
        # Base Case
        if room_width == 1:
            return 1
        if room_width != 1 and tile_height == 1:
            return 1

        # if already calculated
        if self.dp.get((tile_height, room_width)):
            return self.dp[(tile_height, room_width)]

        # go horizontally & vertically
        result = self.find_no_ways_to_cover_room(
            tile_height - 1, room_width
        ) + self.find_no_ways_to_cover_room(tile_height, room_width - 1)

        self.dp[(tile_height, room_width)] = result
        return result


tile_ways = TileWays()
no_of_ways_to_cover_room = tile_ways.find_no_ways_to_cover_room(2, 4)
print(no_of_ways_to_cover_room)
