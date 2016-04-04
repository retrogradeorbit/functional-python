from random import random
import vec2

class Vehicle:
    def __init__(self, pos=vec2.zero, vel=vec2.zero):
        self.pos = pos
        self.vel = vel

    def set_pos(self, pos):
        self.pos = pos

    def set_vel(self, vel):
        self.vel = vel

    def update(self):
        self.pos.add(self.vel)

    def wander(self):
        self.vel.rotate(random() * 0.05)

    def __str__(self):
        return "<Vehicle pos={} vel={}>".format(self.pos, self.vel)
