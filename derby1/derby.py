import vec2

class Derby:
    def __init__(self, vehicles=[]):
        self.vehicles = vehicles

    def add(self, vehicle):
        self.vehicles.append(vehicle)

    def remove(self, vehicle):
        self.vehicles.remove(vehicle)

    def update(self):
        for v in self.vehicles:
            v.wander()
            v.update()

    def sum_vel(self):
        if len(self.vehicles):
            total = self.vehicles[0].vel
            for v in self.vehicles[1:]:
                total.add(v.vel)
            return total
        else:
            return vec2.zero

    def sum_pos(self):
        if len(self.vehicles):
            total = self.vehicles[0].pos
            for v in self.vehicles[1:]:
                total.add(v.pos)
            return total
        else:
            return vec2.zero

    def __str__(self):
        output = "<Derby ["
        for n,v in enumerate(self.vehicles):
            output += "\n\t" + str(v)
            if n<len(self.vehicles):
                output += ","
        output += "\n]>"
        return output
