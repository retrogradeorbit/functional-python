from random import random
import math

def new(x, y):
    return (x,y)

def add(u, v):
    return new(u[0] + v[0], u[1] + v[1])

def scale(v, c):
    return new(v[0] * c, v[1] * c)

def random_unit():
    return rotate(new(1,0), random() * 2 * math.pi)

def rotate(v, theta):
    return new(
        v[0] * math.cos(theta) - v[1] * math.sin(theta),
        v[0] * math.sin(theta) + v[1] * math.cos(theta)
    )

zero = new(0, 0)
i = new(1, 0)
j = new(0, 1)
