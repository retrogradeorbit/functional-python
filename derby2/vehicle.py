from random import random
import vec2

class Vehicle:
    def __init__(self, pos=vec2.zero, vel=vec2.zero):
        self.pos = pos
        self.vel = vel

    def set_pos(self, pos):
        return Vehicle(pos, self.vel)

    def set_vel(self, vel):
        return Vehicle(self.pos, vel)

    def update(self):
        return Vehicle(self.pos.add(self.vel), self.vel)

    def wander(self):
        return Vehicle(self.pos, self.vel.rotate(random() * 0.05))

    def __str__(self):
        return "<Vehicle pos={} vel={}>".format(self.pos, self.vel)
