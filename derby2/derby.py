import vec2

class Derby:
    def __init__(self, vehicles=()):
        self.vehicles = tuple(vehicles)

    def add(self, vehicle):
        return Derby(self.vehicles + (vehicle,))

    def remove(self, vehicle):
        return Derby(v for v in self.vehicles if v != vehicle)

    def update(self):
        return Derby(v.wander().update() for v in self.vehicles)

    def sum_vel(self):
        return reduce(lambda x, y: x.add(y.vel), self.vehicles, vec2.zero)

    def sum_pos(self):
        return reduce(lambda x, y: x.add(y.pos), self.vehicles, vec2.zero)

    def __str__(self):
        return "<Derby [" + "\n\t".join([str(v) for v in self.vehicles]) + "\n]>"
