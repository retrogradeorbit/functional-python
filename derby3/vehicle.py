from random import random
import vec2

def new(pos=vec2.zero, vel=vec2.zero):
    return {"pos": pos, "vel": vel}

def set_pos(vehicle, pos):
    return new(pos, vehicle['vel'])

def set_vel(vehicle, vel):
    return new(vehicle['pos'], vel)

def update(vehicle):
    return new(vec2.add(vehicle['pos'], vehicle['vel']), vehicle['vel'])

def wander(vehicle):
    return new(vehicle['pos'], vec2.rotate(vehicle['vel'], random() * 0.05))
