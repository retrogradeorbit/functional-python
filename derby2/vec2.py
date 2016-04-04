from random import random
import math

class vec2:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def add(self, v):
        return vec2(self.x + v.x, self.y + v.y)

    def scale(self, c):
        return vec2(self.x * c, self.y * c)

    def random_unit(self):
        return vec2(1,0).rotate(random() * 2 * math.pi)

    def rotate(self, theta):
        return vec2(
            self.x * math.cos(theta) - self.y * math.sin(theta),
            self.x * math.sin(theta) + self.y * math.cos(theta)
        )

    def __str__(self):
        return "vec2({},{})".format(self.x, self.y)

zero = vec2(0, 0)
i = vec2(1, 0)
j = vec2(0, 1)
